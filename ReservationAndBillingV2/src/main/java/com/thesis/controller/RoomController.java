package com.thesis.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thesis.model.Room;
import com.thesis.model.RoomReservation;
import com.thesis.model.UniqueRoom;
import com.thesis.service.RoomReservationService;
import com.thesis.service.RoomService;

@Controller
@RequestMapping("auth/room")
public class RoomController {
	@Autowired
	private RoomService roomService;
	@Autowired
	private RoomReservationService rrService;
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String setupForm(Map<String, Object> map,RedirectAttributes redirectAttributes){
		Room room = new Room();
		map.put("room", room);
		map.put("roomList1", roomService.getAllRoom());
		map.put("statusList",room.getStatus().values());
		map.put("typeList",room.getType().values());
		return "manage-room";
	}
	
	@RequestMapping("/delete/{room_no}")
	public String deleteRoom(@PathVariable("room_no") Long id, RedirectAttributes redirectAttribute) {
		String msg1 = "\"alert alert-success\"";
		String msg2 = "\"alert\"";
		redirectAttribute.addFlashAttribute("message","<div class="+msg1+" role="+msg2+">Room Record Successfully Deleted</div>");
		
		roomService.deleteRoom(id);

		/*
		 * redirects to the path relative to the current path
		 */
		// return "redirect:../listRooms";

		/*
		 * Note that there is the slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the project root path
		 */
		return "redirect:/auth/room/";
	}
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveRoom(@ModelAttribute("room") Room room,
			BindingResult result, Map<String,Object>map,RedirectAttributes redirectAttribute) {
		String msg1 = "\"alert alert-success\"";
		String msg2 = "\"alert\"";

		if(result.hasErrors())
		{
			return "manage-room";
		}
		
		roomService.saveRoom(room);
		if(room.getId()>=1)
		{
			redirectAttribute.addFlashAttribute("message","<div class="+msg1+" role="+msg2+">Room Record Succesfully Edited</div>");
		}
		else
			redirectAttribute.addFlashAttribute("message","<div class="+msg1+" role="+msg2+">Room Record Successfully Saved</div>");
		/*
		 * Note that there is no slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the current path
		 */
		return "redirect:/auth/room/";
	}
	@RequestMapping("/get/{room_no}")
	public String getRoom(@PathVariable Long room_no, Map<String, Object> map) {

		Room room = new Room();

		for(Room r: roomService.getAllRoom())
		{
			if(r.getId()==room_no)
			{
				room = r;
			}
		}
		map.put("room", room);

		return "/roomForm2";
	}
	@RequestMapping("/get/roomform")
	public String getRoom(Map<String, Object> map) {
		Room room = new Room();

		map.put("room", room);
		return "/roomForm";
	}
	
	@RequestMapping(value = "/roomNo", method = RequestMethod.GET)
	@ResponseBody
	public UniqueRoom isBrandNameExists(HttpServletResponse response,
	        @RequestParam Long room_no) throws IOException {

		UniqueRoom ur= new UniqueRoom();
		ur.setValid(true);
		for(Room r: roomService.getAllRoom()){
			if(r.getRoom_no()==room_no){
			ur.setValid(false);	
			}
		}
		
		
		return ur;
	}
	

}
