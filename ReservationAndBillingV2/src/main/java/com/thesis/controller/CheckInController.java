package com.thesis.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
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

import com.thesis.model.Billing;
import com.thesis.model.BillingMethod;
import com.thesis.model.PreOccupancy;
import com.thesis.model.Room;
import com.thesis.model.RoomReservation;
import com.thesis.model.RoomReservationAndOccupancy;
import com.thesis.model.SearchDate;
import com.thesis.service.BillingService;
import com.thesis.service.OccupancyService;
import com.thesis.service.ProccessOccupancyService;
import com.thesis.service.ReservationService;
import com.thesis.service.RoomReservationService;
import com.thesis.service.RoomService;

@Controller
@RequestMapping("auth/check_in")
public class CheckInController {
	
	@Autowired
	private RoomReservationService rrService;
	@Autowired
	private OccupancyService occService;
	@Autowired
	private RoomService roomService;
	@Autowired	
	private BillingService billingService;
	@Autowired
	private ProccessOccupancyService pcService;
	@Autowired
	private ReservationService rService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	
	@RequestMapping("/")
	public String firstLoad(Map<String,Object>map){
		
		
		map.put("rrActive", rrService.getAllActiveReservation());
		return "manage-check-in";
	}
	
	@RequestMapping("view/{id}")
	public String getReserve(@PathVariable long id, Map<String, Object> map)
	{
		RoomReservationAndOccupancy rrAndocc = new RoomReservationAndOccupancy();
		RoomReservation rr = new RoomReservation();
		map.put("rr", rr);
		map.put("rrAndocc", rrAndocc);
		map.put("viewReservation", rrService.getReserveRoom(id));
		return "manage-check-in2";
	}
	
	
	@RequestMapping(value="view/saveCheckIn",method=RequestMethod.POST)
	public String saveCheckInWithReservation(@ModelAttribute("rrAndocc") RoomReservationAndOccupancy rrAndOcc,BindingResult result,Map<String,Object>map, RedirectAttributes attributes){
		String msg1 = "\"alert alert-warning\"";
		String msg2 = "\"alert\"";
		String msg3 = "\"alert alert-success\"";
		String msg="";
		System.out.println(rrAndOcc.getOcc().getStatus());
		System.out.println(rrAndOcc.getRr().getId());
		RoomReservation rr = rrService.getRoomReservation(rrAndOcc.getRr().getId());
		rrService.delete(rrAndOcc.getRr().getId());
		List <RoomReservation> listOfrr = rrService.getReserveRoom(rr.getReserve().getId());
		if(listOfrr.isEmpty()){
			System.out.println("aaaaaaaaaaaaa"+ rr.getReserve().getId());
			rService.delete(rr.getReserve().getId());
		}
		occService.save(rrAndOcc.getOcc());
		msg="<div class="+msg3+" role="+msg2+">Checked-in!</div>";
		attributes.addFlashAttribute("message", msg);
		return "redirect:/auth/check_in/";
	}
	@ModelAttribute("countryList")
	 public Map<String,String> populateCreditCardTypes() {
Map<String,String> country = new LinkedHashMap<String,String>();
		
		for(String c: Locale.getISOCountries())
		{
			Locale obj = new Locale("", c);
			country.put(obj.getCountry(),obj.getDisplayCountry());
			

		}
		             
	        return country;
	    }
	
	@RequestMapping("view/get/{id}")
	public String getRoomReserve(@PathVariable long id, Map<String, Object> map)
	{
		RoomReservationAndOccupancy rrAndocc = new RoomReservationAndOccupancy();
		map.put("rrAndocc", rrAndocc);
		map.put("rr", rrService.getRoomReservation(id));
		return "check-inFormWithReservation";
	}
	
	
	//walk in check in start
	
	@RequestMapping("search")
	public String room(@ModelAttribute(value="searchDate") SearchDate searchDate,Map<String,Object> map){

		Calendar now = Calendar.getInstance();
        now.set(Calendar.HOUR, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
		Date today = now.getTime();
		Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
		Room room = new Room();
		PreOccupancy pocc = new PreOccupancy();
		map.put("preOccupancy", pocc);
		map.put("room",room);
		map.put("dates", searchDate);
		searchDate.setCheck_in(today);
		searchDate.setCheck_out(tomorrow);
		map.put("roomAvailableList", roomService.getAvailableRoom(searchDate.getCheck_in(), searchDate.getCheck_out()));
		return "searchRoomFrontCheckIn";
		
	}
	@RequestMapping(value="search.do", method=RequestMethod.POST)
	public String roomDo(@ModelAttribute(value="searchDate") SearchDate searchDate,Map<String,Object> map){
		Date today = new Date();    
		searchDate.setCheck_in(today);
		Room room = new Room();
		PreOccupancy pocc = new PreOccupancy();
		map.put("preOccupancy", pocc);
		map.put("room",room);
		map.put("dates", searchDate);
		map.put("roomAvailableList", roomService.getAvailableRoom(searchDate.getCheck_in(), searchDate.getCheck_out()));
		return "searchRoomFrontCheckIn";
		
	}
	
	
	@RequestMapping("/cif")
	public String formFill2(
			@ModelAttribute("preOccupancy")PreOccupancy preOcc,BindingResult result,
			Map<String, Object> map
			) {
		Room room = roomService.getRoom(preOcc.getRoom_id());
		preOcc.setRoom(room);
		map.put("room", room);
		return "/preLoadFormCheckIn";
	}
	@RequestMapping("/saveWalkIn")
	public String saveWalkIn(@ModelAttribute("preOccupancy") PreOccupancy preOcc
			, BindingResult result, Map<String,Object>map, RedirectAttributes rAttribe)
	{
	
		String msg1 = "\"alert alert-warning\"";
		String msg2 = "\"alert\"";
		String msg3 = "\"alert alert-success\"";
		String msg="";
		String theReturn = "";
		
		
		Room room = roomService.getRoom(preOcc.getRoom_id());

		Billing billing = new Billing();
		preOcc.setRoom(room);
		preOcc.getOcc().setRoom(room);
		if(preOcc.getBilling().getMethod()==BillingMethod.CREDIT_CARD)
		{
			switch(pcService.methodCreditCard(preOcc)){
			case "notfound":
			{
				System.out.println("notfound");
				msg="<div class="+msg1+" role="+msg2+">Credit Card Not Found</div>";
				theReturn = "preLoadFormCheckIn";
				break;
			}
			case "conflict":
			{
				System.out.println("conflict");
				msg="<div class="+msg1+" role="+msg2+">Conflict Reservation Please Click Cancel Button to try again</div>";
				theReturn = "preLoadFormCheckIn";
				break;
			}
			case "insuficient":
			{
				System.out.println("insuficient");
				msg="<div class="+msg1+" role="+msg2+">Transaction error. Please check with your bank</div>";
				theReturn = "preLoadFormCheckIn";
				break;
			}
			case "success":
			{
				System.out.println("success2");
				rAttribe.addFlashAttribute("message", "<div class="+msg3+" role="+msg2+">Checked-In!</div>");
				
				theReturn = "redirect:/auth/check_in/";
				break;
			}
			
			}
			
		}
		else if(preOcc.getBilling().getMethod()==BillingMethod.CASH){
			switch(pcService.methodCashSave(preOcc)){
			case "conflict":
			{
				System.out.println("conflict");
				msg="<div class="+msg1+" role="+msg2+">Conflict Reservation Please Click Cancel Button to try again</div>";
				theReturn = "preLoadFormCheckIn";
				break;
			}
			case "success":
			{
				System.out.println("success2");
				rAttribe.addFlashAttribute("message", "<div class="+msg3+" role="+msg2+">Checked-In!</div>");
				
				theReturn = "redirect:/auth/check_in/";
				break;
			}
			
			}
		}
		
		
		map.put("message", msg);
		return theReturn;
	}
	
	//walk in check in end
	
	
}
