package com.thesis.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thesis.model.Guest;
import com.thesis.service.GuestService;

@Controller
@RequestMapping("auth/guest")
public class GuestController {
	@Autowired
	private GuestService guestService;
	
	
	@RequestMapping("/")
	public String loadFirst(Map<String, Object> map){
		Guest guest = new Guest();
		List<Guest>guestView = new ArrayList<Guest>();
		for(Guest g: guestService.getAllGuest())
		{
			Locale obj = new Locale("", g.getNationality());
			g.setNationality(obj.getDisplayCountry());
			guestView.add(g);
		}
		map.put("guest", guest);
		map.put("genderList",guest.getGender().values());
		map.put("guestList", guestView);
		
		return "manage-guest";
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

	
	@RequestMapping("/delete/{id}")
	public String deleteGuest(@PathVariable("id") Long id) {

		guestService.delete(id);

		/*
		 * redirects to the path relative to the current path
		 */
		// return "redirect:../listGuests";

		/*
		 * Note that there is the slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the project root path
		 */
		return "redirect:/auth/guest/";
	}
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveGuest(@ModelAttribute("guest") Guest guest,
			BindingResult result,RedirectAttributes attributes) {
		String msg1 = "\"alert alert-success\"";
		String msg2 = "\"alert\"";
		String msg="";
		
		if(result.hasErrors()){
			System.out.println("WEreeroro");
		}
		
		msg="<div class="+msg1+" role="+msg2+">Guest record edited successfully!</div>";
		attributes.addFlashAttribute("message",msg);
		guestService.saveGuest(guest);

		/*
		 * Note that there is no slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the current path
		 */
		return "redirect:/auth/guest/";
	}
	@RequestMapping("/get/{id}")
	public String getGuest(@PathVariable Long id, Map<String, Object> map) {

		Guest guest = guestService.getGuest(id);

		map.put("guest", guest);

		return "/guestForm";
	}

}
