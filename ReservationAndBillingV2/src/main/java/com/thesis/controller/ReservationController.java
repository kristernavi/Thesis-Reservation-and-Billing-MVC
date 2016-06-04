package com.thesis.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thesis.model.ArrayOfRooms;
import com.thesis.model.BillingMethod;
import com.thesis.model.ChangeRoom;
import com.thesis.model.Client;
import com.thesis.model.EditReservation;
import com.thesis.model.Reservation;
import com.thesis.model.ReservationPreLoad;
import com.thesis.model.Room;
import com.thesis.model.RoomReservation;
import com.thesis.model.RoomReservationAndOccupancy;
import com.thesis.model.SearchDate;
import com.thesis.service.ClientService;
import com.thesis.service.OccupancyService;
import com.thesis.service.ProccesReservationService;
import com.thesis.service.ReservationService;
import com.thesis.service.RoomReservationService;
import com.thesis.service.RoomService;

@Controller
@RequestMapping("auth/reserve")
public class ReservationController {
	@Autowired
	private RoomReservationService rrService;
	@Autowired
	private OccupancyService occService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private ReservationService rService;
	@Autowired
	private ClientService cService;
	
	@Autowired
	private ProccesReservationService prService;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value="search", method=RequestMethod.GET)
	public String room(@ModelAttribute(value="searchDate") SearchDate searchDate,Map<String,Object> map){
		Reservation reserve = new Reservation();
		ArrayOfRooms ar = new ArrayOfRooms();

		Calendar now = Calendar.getInstance();
        now.set(Calendar.HOUR, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
		Date today = now.getTime();
		Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
		Room room = new Room();
		ReservationPreLoad rpl = new ReservationPreLoad();
		map.put("reservation",ar);
		map.put("reservePreLoad", rpl);
		map.put("room",room);
		map.put("dates", searchDate);
		searchDate.setCheck_in(today);
		searchDate.setCheck_out(tomorrow);
		map.put("roomAvailableList", roomService.getAvailableRoom(searchDate.getCheck_in(), searchDate.getCheck_out()));
		return "add-reservation";
		
	}
	@RequestMapping(value="search.do", method=RequestMethod.POST)
	public String roomDo(@ModelAttribute(value="searchDate") SearchDate searchDate,Map<String,Object> map){
		ArrayOfRooms ar = new ArrayOfRooms();
		Reservation reserve = new Reservation();
		map.put("reservation",ar);
		Room room = new Room();
		ReservationPreLoad rpl = new ReservationPreLoad();
		map.put("reservePreLoad", rpl);
		map.put("room",room);
		map.put("dates", searchDate);
		map.put("roomAvailableList", roomService.getAvailableRoom(searchDate.getCheck_in(), searchDate.getCheck_out()));
		return "add-reservation";
		
	}
	
	@RequestMapping("/save")
	public String saveGuestReservation(@ModelAttribute("reservation2") Reservation reservation, BindingResult result, Map<String,Object>map){
		Client client = new Client();
		client.setAddress("aa");
		client.setFirstname("test");
		client.setLastname("testl");
		client.setSex("M");
		
		reservation.setClient(client);
		reservation.setPayable(new BigDecimal(300));
		reservation.setReference("AA");
		reservation.setReserveDate(new Date());
		return "success";
	}
	@RequestMapping("/test")
	
	public String test(@ModelAttribute("reservation") ReservationPreLoad rpl, BindingResult result, Map<String,Object>map){
		 
		Reservation reservation = new Reservation();
		
		reservation.setReserveDate(new Date());
		List<Room> room = new ArrayList<Room>();
		List<RoomReservation> rr2 = new ArrayList <RoomReservation>();
		BigDecimal payable = new BigDecimal(0);
		int counter = 0;
		System.out.println(rpl.getAr().getRoom_id());
		for(Integer r :rpl.getAr().getRoom_id()){
			counter++;
			Room rm = roomService.getRoom(r);
			payable = payable.add(rm.getRate().multiply(new BigDecimal(rpl.getNumberOfDays())));
		}
		rpl.setPayable(payable);
		rpl.setCounter(counter);
		map.put("test", rpl.getAr().getRoom_id());
	
		map.put("payable", rpl.getPayable());
		map.put("rpl", rpl);
		map.put("counter", rpl.getCounter());

		
		return "preLoadForm4";
	}
	@RequestMapping(value="proccesReservation",method=RequestMethod.POST)
	public String procces(@ModelAttribute("reservation") ReservationPreLoad rpl, BindingResult result, Map<String,Object>map)
	{
		String theReturn = "";
		String msg1 = "\"alert alert-warning\"";
		String msg2 = "\"alert\"";
		String msg="";
		if(rpl.getCcBillingReservation().getBilling().getMethod()==BillingMethod.CREDIT_CARD)
		{
		switch (prService.saveMethodCreditCard(rpl)) {
		case "notfound":
		{
			System.out.println("notfound");
			msg="<div class="+msg1+" role="+msg2+">Invalid Credit Card. Please enter again</div>";
			theReturn = "/preLoadForClient";
			break;
		}
		case "conflict":
		{
			System.out.println("conflict");
			msg="<div class="+msg1+" role="+msg2+">Conflict Reservation Please Click Cancel Button to try again</div>";
			theReturn = "/preLoadForClient";
			break;
		}
		case "insuficient":
		{
			System.out.println("insuficient");
			msg="<div class="+msg1+" role="+msg2+">Transaction error. Please check with your bank</div>";
			theReturn = "/preLoadForClient";
			break;
		}
		case "success":
		{
			System.out.println("success2");
			msg="Succesfully Reserve";
			theReturn = "redirect:/auth/reserve/";
			break;
		}
		}
		
		}
		else
		{
			switch (prService.saveMethodCash(rpl)) {
			case "conflict":
			{
				System.out.println("conflict");
				msg="<div class="+msg1+" role="+msg2+">Conflict Reservation Please Click Cancel Button to try again</div>";
				theReturn = "/preLoadForClient";
				break;
			}
			case "success":
			{
				System.out.println("success2");
				msg="Succesfully Reserve";
				theReturn = "redirect:/auth/reserve/";
				break;
			}
			}
		}
		map.put("test", rpl.getAr().getRoom_id());
		
		map.put("payable", rpl.getPayable());
		map.put("rpl", rpl);
		map.put("counter", rpl.getCounter());
		
		map.put("message", msg);
		return theReturn;
	}

	
	
	@RequestMapping("/")
	public String loadFirst(Map<String,Object>map){
		
		map.put("rrList", rrService.getAllRoomReservation());
		return "manage-reservation";
	}
	

	@RequestMapping("view/{id}")
	public String getReserve(@PathVariable long id, Map<String, Object> map)
	{
		EditReservation er = new EditReservation();
		RoomReservationAndOccupancy rrAndocc = new RoomReservationAndOccupancy();
		RoomReservation rr = new RoomReservation();
		RoomReservation rr2 = (RoomReservation) rrService.getReserveRoom(id).get(0);
		map.put("er", er);
		map.put("rr", rr);
		map.put("rr", rr2);
		map.put("param_id", id);
		map.put("rrAndocc", rrAndocc);
		map.put("viewReservation", rrService.getReserveRoom(id));
		return "manage-reservation2";
	}
	@RequestMapping("saveChangeDate")
	public String saveChangeDate(@ModelAttribute("er") EditReservation er, BindingResult result,Map<String,Object>map,RedirectAttributes attributes)
	{
		String msg1 = "\"alert alert-warning\"";
		String msg2 = "\"alert\"";
		String msg="";
		
		if(er.getMethod()==BillingMethod.CREDIT_CARD){
		switch(prService.editDaysSaveCreditCard(er)){
	case "notfound":
	{
		System.out.println("notfound");
		msg="<div class="+msg1+" role="+msg2+">Invalid Credit Card. Please enter again</div>";
		break;
	}
	case "conflict":
	{
		System.out.println("conflict");
		msg="<div class="+msg1+" role="+msg2+">Conflict Reservation Please Click Cancel Button to try again</div>";
		break;
	}
	case "insuficient":
	{
		System.out.println("insuficient");
		msg="<div class="+msg1+" role="+msg2+">Transaction error. Please check with your bank</div>";
		break;
	}
	case "success":
	{
		System.out.println("success2");
		msg="<div class="+msg1+" role="+msg2+">Record Change!</div>";
		break;
	}
	}
	
	}
	else
	{
		switch (prService.editDaysSaveCash(er)) {
		case "conflict":
		{
			System.out.println("conflict");
			msg="<div class="+msg1+" role="+msg2+">Conflict Reservation Please to reselect a date again</div>";
			break;
		}
		case "success":
		{
			System.out.println("success2");
			msg="<div class="+msg1+" role="+msg2+">Record Change!</div>";
			break;
		}
		}
	}
		attributes.addFlashAttribute("message", msg);
		return "redirect:/auth/reserve/view/"+er.getParam_id();
	}
	@RequestMapping("delete/{id}")
	public String deleteReserve(@PathVariable long id, Map<String, Object> map,RedirectAttributes attributes)
	{
		rrService.deleteRr(id);
		Reservation r = rService.getReservation(id);
		rService.delete(r.getId());
		attributes.addFlashAttribute("message", "Record Deleted!");
		return "redirect:/auth/reserve/";
	}
	
	@RequestMapping("view/get/{from}/{to}/{id}/{rate}")
	public String getEditRoom(@PathVariable Date from,@PathVariable Date to,
			@PathVariable long id,@PathVariable BigDecimal rate
			,Map<String,Object>map)
	{
		List <Room> roomAvailable = roomService.getAvailableEditRoom(from, to, id, rate);
		if(roomAvailable.isEmpty()){
			return "no-avail";
		}
		ChangeRoom cr = new ChangeRoom();
		cr.setRr_id(id);
		map.put("cr", cr);
		map.put("changeRoom", roomAvailable);
		return "changeRoomForm";
	}
	
	@RequestMapping("saveChangeRoom")
	public String changeRoom(@ModelAttribute("cr") ChangeRoom cr,BindingResult result,Map<String,Object>map, RedirectAttributes attributes){
		Room room = roomService.getRoom(cr.getRoom_id());
		RoomReservation rr = rrService.getRoomReservation(cr.getRr_id());
		String msg1 = "\"alert alert-success\"";
		String msg2 = "\"alert\"";
		String msg="";
		rr.setRoom(room);
		rrService.save(rr);
		System.out.println("success2");
		msg="<div class="+msg1+" role="+msg2+">Record Change!</div>";
		attributes.addFlashAttribute("message", msg);
		
		return "redirect:/auth/reserve/view/"+rr.getReserve().getId();
	}

}
