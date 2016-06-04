package com.thesis.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
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
import com.thesis.model.ReferenceKey;
import com.thesis.model.Reservation;
import com.thesis.model.ReservationPreLoad;
import com.thesis.model.Room;
import com.thesis.model.RoomReservation;
import com.thesis.model.RoomReservationAndOccupancy;
import com.thesis.model.SearchDate;
import com.thesis.service.BillingService;
import com.thesis.service.ProccesReservationService;
import com.thesis.service.ReservationService;
import com.thesis.service.RoomReservationService;
import com.thesis.service.RoomService;

@Controller
public class ClientReservationController {

	
	@Autowired
	private ReservationService reservationService; 
	@Autowired
	private RoomService roomService; 
	@Autowired
	private BillingService billingService;
	@Autowired
	private RoomReservationService rrService;
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
		tomorrow.setHours(12);
		
		today.setHours(12);
		Room room = new Room();
		ReservationPreLoad rpl = new ReservationPreLoad();
		map.put("reservation",ar);
		map.put("reservePreLoad", rpl);
		map.put("room",room);
		map.put("dates", searchDate);
		searchDate.setCheck_in(today);
		searchDate.setCheck_out(tomorrow);
		System.out.println("Check-in Date: "+searchDate.getCheck_in() +" "+"Check-out Date :"+searchDate.getCheck_in());
		map.put("roomAvailableList", roomService.getAvailableRoom(searchDate.getCheck_in(), searchDate.getCheck_out()));
		return "searchAvailableGuest";
		
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
		return "searchAvailableGuest";
		
	}
	@RequestMapping("reference")
	public String searchReference(Map<String,Object>map){
		ReferenceKey key= new ReferenceKey();
				
		map.put("reference", key);
		return "reference";
	}
	@RequestMapping("reference.do")
	public String searchReferenceKey(@ModelAttribute("reference") ReferenceKey key,Map<String,Object>map,RedirectAttributes attributes){
		Reservation reservation = reservationService.getReservationByReference(key.getKey());
		


		if(reservation==null)
		{
		attributes.addFlashAttribute("message", "Invalid Serial Reference Key, Please try again.");
		return "redirect:/reference";
		}
		
		else	
		return "redirect:reference/"+key.getKey();
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
		List<Room>roomList = new ArrayList<Room>();
		for(Integer r :rpl.getAr().getRoom_id()){
			counter++;
			Room rm = roomService.getRoom(r);
			roomList.add(rm);
			payable = payable.add(rm.getRate().multiply(new BigDecimal(rpl.getNumberOfDays())));
		}
		rpl.setPayable(payable);
		rpl.setCounter(counter);
		map.put("test", rpl.getAr().getRoom_id());
		map.put("roomNumber", rpl.getAr().getRoom_id());
		map.put("roomNumber2", roomList);
		map.put("payable", rpl.getPayable());
		map.put("rpl", rpl);
		map.put("counter", rpl.getCounter());

		

		
		return "preLoadForClient";
	}
	@RequestMapping("delete/{id}")
	public String deleteReserve(@PathVariable long id, Map<String, Object> map,RedirectAttributes attributes)
	{
		rrService.deleteRr(id);
		Reservation r = reservationService.getReservation(id);
		reservationService.delete(r.getId());
		attributes.addFlashAttribute("message", "Record Deleted!");
		return "redirect:/";
	}
	@RequestMapping(value="proccesReservation",method=RequestMethod.POST)
	public String procces(@ModelAttribute("reservation") ReservationPreLoad rpl, BindingResult result, Map<String,Object>map)
	{
		String theReturn = "";
		String msg1 = "\"alert alert-warning\"";
		String msg2 = "\"alert\"";
		String msg="";
		String key = RandomStringUtils.randomAlphanumeric(12).toUpperCase();
		rpl.getCcBillingReservation().getReservation().setReference(key);
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
			theReturn = "successClient";
			break;
		}
		
		}
		map.put("test", rpl.getAr().getRoom_id());
		
		map.put("payable", rpl.getPayable());
		map.put("rpl", rpl);
		map.put("counter", rpl.getCounter());
		
		map.put("message", msg);
		return theReturn;
	}
	@RequestMapping("reference/get/{from}/{to}/{id}/{rate}/{key}")
	public String getEditRoom(@PathVariable Date from,@PathVariable Date to,
			@PathVariable long id,@PathVariable BigDecimal rate,
			@PathVariable String key,Map<String,Object>map)
	{
		List <Room> roomAvailable = roomService.getAvailableEditRoom(from, to, id, rate);
		if(roomAvailable.isEmpty()){
			return "no-avail";
		}
		ChangeRoom cr = new ChangeRoom();
		cr.setRr_id(id);
		cr.setKey(key);
		map.put("cr", cr);
		map.put("changeRoom", roomAvailable);
		return "clientChangeRoomForm";
	}
	
	@RequestMapping("saveChangeRoom")
	public String changeRoom(@ModelAttribute("cr") ChangeRoom cr,BindingResult result,Map<String,Object>map, RedirectAttributes attributes){
		Room room = roomService.getRoom(cr.getRoom_id());
		RoomReservation rr = rrService.getRoomReservation(cr.getRr_id());
		String msg1 = "\"alert alert-success\"";
		String msg2 = "\"alert\"";
		String msg="";
		System.out.println("success2");
		msg="<div class="+msg1+" role="+msg2+">Record Change!</div>";
		rr.setRoom(room);
		rrService.save(rr);
		attributes.addFlashAttribute("message",msg);
		return "redirect:reference/"+cr.getKey();
	}
	
	@RequestMapping("saveChangeDate")
	public String saveChangeDate(@ModelAttribute("er") EditReservation er, BindingResult result,Map<String,Object>map,RedirectAttributes attributes)
	{
		String msg1 = "\"alert alert-success\"";
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
		return "redirect:reference/"+er.getKey();
	}


	@RequestMapping("reference/{key}")
	public String searchReferenceKey2(@PathVariable String key,Map<String,Object>map,RedirectAttributes attributes){
		Reservation reservation = reservationService.getReservationByReference(key);
		List<RoomReservation> rr = rrService.getReserveRoom(reservation.getId());
		EditReservation er = new EditReservation();
		RoomReservationAndOccupancy rrAndocc = new RoomReservationAndOccupancy();



		
		
		map.put("er", er);
		map.put("rrList",rr);
		map.put("reserveList", reservation);	
		return "viewReservation";
	}
}
