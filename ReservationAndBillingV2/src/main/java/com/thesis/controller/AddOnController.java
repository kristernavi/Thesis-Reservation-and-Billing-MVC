package com.thesis.controller;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thesis.model.AddOn;
import com.thesis.model.AddOnDetail;
import com.thesis.model.Occupancy;
import com.thesis.service.AddOnDetailService;
import com.thesis.service.AddonService;
import com.thesis.service.OccupancyService;

@Controller

@RequestMapping("/auth/addon")
public class AddOnController {
	@Autowired
	private AddonService addOnService;
	@Autowired
	private OccupancyService occService;
	@Autowired
	private AddOnDetailService addOnDetailService;
	
	@RequestMapping("/")
	public String firstLoad(Map<String,Object>map){
		AddOn addOn = new AddOn();
		map.put("check_inList",occService.getAllCheckIn());
		map.put("addOnList",addOnService.getAllAddOn());
		map.put("addOn",addOn);
		return "manage-addon";
	}
	@RequestMapping("/save")
	public String saveAddon(@ModelAttribute("addOn") AddOn addon, 
	BindingResult result,Map<String,Object>map, RedirectAttributes redirectAttributes){
		String msg1 = "\"alert alert-warning\"";
		String msg2 = "\"alert\"";
		String msg3 = "\"alert alert-success\"";
		String msg="";
		if(addon.getId()==0){
			msg = "<div class="+msg3+" role="+msg2+"> Add On Record Successfully Saved!</div>";
		}
		else
		{
			msg = "<div class="+msg3+" role="+msg2+"> Add On Record Successfully Edited!</div>";
		}
		redirectAttributes.addFlashAttribute("message", msg);
		
		addOnService.saveAddon(addon);
		return "redirect:/auth/addon/";
	}
	
	@RequestMapping("/get/{addOnId}")
	public String getAddOn(@PathVariable Long addOnId, Map<String, Object> map) {

		AddOn addOn = addOnService.getAddOn(addOnId);
		map.put("check_inList",occService.getAllCheckIn());
		map.put("addOn", addOn);

		return "/addOnForm";
	}
	@RequestMapping("/gets/{addOnId}")
	public String getAddOns(@PathVariable Long addOnId, Map<String, Object> map) {
		
		AddOnDetail addOnDetail = new AddOnDetail();
		map.put("addOnDetail", addOnDetail);
		AddOn addOn = addOnService.getAddOn(addOnId);
		if(occService.getAllCheckIn().isEmpty())
		{
			return "noCheck-in";
		}
		map.put("check_inList",occService.getAllCheckIn());
		map.put("addOn", addOn);

		return "/assignAddOnForm";
	}
	
	@RequestMapping("/delete/{addOnId}")
	public String deleteRoom(@PathVariable("addOnId") Long addOnId, RedirectAttributes redirectAttributes) {
		String msg1 = "\"alert alert-warning\"";
		String msg2 = "\"alert\"";
		String msg3 = "\"alert alert-success\"";

		addOnService.delete(addOnId);

		/*
		 * redirects to the path relative to the current path
		 */
		// return "redirect:../listRooms";

		/*
		 * Note that there is the slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the project root path
		 * 
		 */
		redirectAttributes.addFlashAttribute("message", "<div class="+msg3+" role="+msg2+"> Record Deleted!</div>");
		
		return "redirect:/auth/addon/";
	}
	
	@RequestMapping("/assign")
	public String assignAddon(@ModelAttribute("addOnDetail") AddOnDetail addOnDetail, 
	BindingResult result,Map<String,Object>map, RedirectAttributes redirectAttributes){
		String msg1 = "\"alert alert-warning\"";
		String msg2 = "\"alert\"";
		String msg3 = "\"alert alert-success\"";
		if(result.hasErrors())
		{
			redirectAttributes.addFlashAttribute("message", "<div class="+msg1+" role="+msg2+"> Failed to assign addon</div>");
			return "redirect:/auth/addon/";
		}
		Occupancy occ = occService.getOccupancy(addOnDetail.getOccupancy().getId());
		AddOn addOn = addOnService.getAddOn(addOnDetail.getAddOn().getId());
		BigDecimal calc = occ.getPayable();
		calc = calc.add(addOn.getRate());
		occ.setPayable(calc);
		System.out.println(addOn.getRate());
		System.out.println(occ.getPayable());
		System.out.println(calc);
		redirectAttributes.addFlashAttribute("message", "<div class="+msg3+" role="+msg2+"> Avail Successfully!</div>");
		occService.save(occ);
		addOnDetailService.save(addOnDetail);
		return "redirect:/auth/addon/";
	}
	
	
	

}
