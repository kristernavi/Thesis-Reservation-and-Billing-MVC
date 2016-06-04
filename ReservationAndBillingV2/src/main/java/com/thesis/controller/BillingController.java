package com.thesis.controller;

import java.math.BigDecimal;
import java.util.List;
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
import com.thesis.model.Billing;
import com.thesis.model.BillingMethod;
import com.thesis.model.CalculateBilling;
import com.thesis.model.CreditCardBillingReservation;
import com.thesis.model.Occupancy;
import com.thesis.service.AddOnDetailService;
import com.thesis.service.AddonService;
import com.thesis.service.BillingService;
import com.thesis.service.OccupancyService;
import com.thesis.service.ProccessBillingService;

@Controller
@RequestMapping("auth/billing")
public class BillingController {

	@Autowired
	private BillingService billingService;
	@Autowired
	private OccupancyService occService;
	@Autowired
	private ProccessBillingService pbService;
	@Autowired
	private AddOnDetailService addDService;
	@Autowired
	private AddonService addService;
	@RequestMapping("/")
	public String loadFirst(Map<String,Object>map){
		
		map.put("check_inList", occService.getAllCheckIn());
		return "manage-billing";
	}
	@RequestMapping("/view/{occ_id}")
	public String viewAddOn(@PathVariable long occ_id,Map<String,Object>map)
	{
		List<AddOnDetail>aDetail = addDService.getAllAvailAddon(occ_id);
		map.put("addList", aDetail);
		return "view-addon";
	}
	
	@RequestMapping("/add/{occ_id}")
	public String addAddOn(@PathVariable long occ_id,Map<String,Object>map)
	{
		AddOnDetail ad = new AddOnDetail();
		map.put("addOnDetail", ad);
		map.put("addOnList", addService.getAllAddOn());
		map.put("occ_id", occ_id);
		return "add-addon";
	}
	@RequestMapping("saveAddon")
	public String saveAddOn(@ModelAttribute("addOnDetail") AddOnDetail addOnDetail,Map<String,Object>map, RedirectAttributes redirectAttributes)
	{
		String msg1 = "\"alert alert-warning\"";
		String msg2 = "\"alert\"";
		String msg3 = "\"alert alert-success\"";
		Occupancy occ = occService.getOccupancy(addOnDetail.getOccupancy().getId());
		AddOn addOn = addService.getAddOn(addOnDetail.getAddOn().getId());
		BigDecimal calc = occ.getPayable();
		calc = calc.add(addOn.getRate());
		occ.setPayable(calc);
		System.out.println(addOn.getRate());
		System.out.println(occ.getPayable());
		System.out.println(calc);
		occService.save(occ);
		addDService.save(addOnDetail);
		redirectAttributes.addFlashAttribute("message", "<div class="+msg3+" role="+msg2+"> Avail Successfully!</div>");
		return "redirect:/auth/billing/";
	}
	@RequestMapping("/get/{index}")
	public String getRoom(@PathVariable int index, Map<String, Object> map) {
		CalculateBilling cb = (CalculateBilling) billingService.getCalculateBalance().get(index-1);
		Billing billing = new Billing();
		CreditCardBillingReservation ccBr = new CreditCardBillingReservation();
		map.put("ccBilling", ccBr);
		map.put("cb", cb);
		map.put("billing",billing);
		return "/billingForm";
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
		return "redirect:/auth/billing/";
	}
}
