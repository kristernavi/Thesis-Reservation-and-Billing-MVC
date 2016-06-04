package com.thesis.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thesis.model.Billing;
import com.thesis.model.BillingMethod;
import com.thesis.model.CreditCardBillingReservation;
import com.thesis.model.Occupancy;
import com.thesis.service.OccupancyService;
import com.thesis.service.ProccessBillingService;

@Controller
@RequestMapping("auth/check_out")
public class CheckOutController {
	
	@Autowired
	private OccupancyService occService;
	@Autowired
	private ProccessBillingService pbService;
	
	@RequestMapping("/")
	public String loadFirst(Map<String,Object>map){
		Occupancy occ = new Occupancy();
		CreditCardBillingReservation ccBr = new CreditCardBillingReservation();
		
		map.put("ccBilling", ccBr);
		map.put("occ2", occ);
		
		map.put("allowList", occService.getAllCheckIn());
		return "manage-check-out";	
		
	}
	@RequestMapping("confirm/{id}")
	public String confirm(@PathVariable long id, RedirectAttributes rAttribe)
	{
		Occupancy occ = occService.getOccupancy(id);
		occ.setStatus("CHECK_OUT");
		occ.setTo(new Date());
		occService.save(occ);
		String msg1 = "\"alert alert-success\"";
		String msg2 = "\"alert\"";
		rAttribe.addFlashAttribute("message", "<div class="+msg1+" role="+msg2+">Checked-Out!</div>");
		return "redirect:/auth/check_out/";
	}
	
	@RequestMapping("save")
	public String saveBilling(@ModelAttribute("ccBilling") CreditCardBillingReservation ccBr, BindingResult result,Map<String,Object>map, RedirectAttributes rAttributes){
		String msg1 = "\"alert alert-warning\"";
		String msg2 = "\"alert\"";
		String msg3 = "\"alert alert-success\"";
		String msg= "";
		if(ccBr.getBilling().getMethod()==BillingMethod.CREDIT_CARD){
			switch (pbService.methodCreditCardSave(ccBr)) {
			case "success":
				msg = "<div class="+msg3+" role="+msg2+">Transcation Saved!</div>";
				
				break;

			case "notfound":
				msg = "<div class="+msg1+" role="+msg2+">Invalid Credit Card. Please enter again</div>";
				break;
			case "insuficient":
				msg =  "<div class="+msg1+" role="+msg2+">Transaction error. Please check with your bank</div>";
				break;
			}
		}
		else
		{
			pbService.methodCashSave(ccBr);
			msg = "<div class="+msg3+" role="+msg2+">Transcation Saved!</div>";
		}
		rAttributes.addFlashAttribute("message",msg);
		return "redirect:/auth/check_out/";
	}
	
	@RequestMapping("get/{id}")
	public String getOccupancy(@PathVariable long id, Map<String,Object>map){
		Occupancy occ = occService.getOccupancy(id);
		Billing billing = new Billing();
		CreditCardBillingReservation ccBr = new CreditCardBillingReservation();
		map.put("ccBilling", ccBr);
		map.put("billing",billing);
		
		map.put("occ2", occ);
		return "billingForm";
	}


}
