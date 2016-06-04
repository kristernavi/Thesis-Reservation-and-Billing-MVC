package com.thesis.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thesis.model.BillingCollection;
import com.thesis.model.NationalityReport;
import com.thesis.model.OccupancyReport;
import com.thesis.model.OccupancyReportV2;
import com.thesis.model.SearchReportDate;
import com.thesis.model.SearchReportDateAndRoom;
import com.thesis.service.BillingService;
import com.thesis.service.OccupancyService;
import com.thesis.service.RoomService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("auth/report")
public class ReportController {
	
	@Autowired
	public RoomService roomService;
	@Autowired
	public BillingService billingService;
	@Autowired
	public OccupancyService occService;
	
	@RequestMapping("/")
	public String loadFirst(Map<String,Object>map){
		SearchReportDate sRd = new SearchReportDate();
		map.put("search",sRd);
		SearchReportDateAndRoom srdr = new SearchReportDateAndRoom();
		map.put("searchWithRoom",srdr);
		map.put("roomList", roomService.getAllRoom());
		
		return "generateReport";
	}
	
	
	
	 @RequestMapping( value = "pdf/occupancy",method=RequestMethod.POST)
	    public ModelAndView generateOccupancyReport(@ModelAttribute("searchWithRoom") SearchReportDate srd, ModelAndView modelAndView, RedirectAttributes attributes){
	 
		 Map<String,Object> parameterMap = new HashMap<String,Object>();
		 
	        List<OccupancyReportV2>usersList =  occService.getOccpancyReport(srd);
	        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);
	        parameterMap.put("datasource", JRdataSource);
	        String msg1 = "\"alert alert-warning\"";
			String msg2 = "\"alert\"";
			if(usersList.isEmpty()){
	        	System.out.println("print if no record");
	        	attributes.addFlashAttribute("message", "<div class="+msg1+" role="+msg2+">No record found please try again</div>");
	        	 modelAndView = new ModelAndView("redirect:/auth/report/");
	        }
			else
	        modelAndView = new ModelAndView("occupancyPdfReport", parameterMap);
	 
	        return modelAndView;
	 
	      
	    
	 
	    }
	 @RequestMapping( value = "pdf/collection",method=RequestMethod.POST)
	    public ModelAndView generateHtmlReport(@ModelAttribute("search") SearchReportDate sRd, ModelAndView modelAndView, RedirectAttributes attributes){
	 
	 
	        Map<String,Object> parameterMap = new HashMap<String,Object>();
	 
	        List<BillingCollection> usersList = billingService.getCollection(sRd);
	       
	       
	        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);
	        parameterMap.put("datasource", JRdataSource);
	        String msg1 = "\"alert alert-warning\"";
			String msg2 = "\"alert\"";
			if(usersList.isEmpty()){
	        	System.out.println("print if no record");
	        	attributes.addFlashAttribute("message", "<div class="+msg1+" role="+msg2+">No record found please try again</div>");
	        	 modelAndView = new ModelAndView("redirect:/auth/report/");
	        }
			else
	        modelAndView = new ModelAndView("collectionPdfReport", parameterMap);
	 
	        return modelAndView;
	 
	    }
	 @RequestMapping( value = "pdf/nationality",method=RequestMethod.POST)
	    public ModelAndView nationalityReportPdf(@ModelAttribute("search") SearchReportDate sRd, ModelAndView modelAndView, RedirectAttributes attributes){
	 
	 
	        Map<String,Object> parameterMap = new HashMap<String,Object>();
	 
	        List<NationalityReport>usersList = occService.getNationalityReport(sRd);
	       
	        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);
	        parameterMap.put("datasource", JRdataSource);
	        String msg1 = "\"alert alert-warning\"";
			String msg2 = "\"alert\"";
			if(usersList.isEmpty()){
	        	System.out.println("print if no record");
	        	attributes.addFlashAttribute("message", "<div class="+msg1+" role="+msg2+">No record found please try again</div>");
	        	 modelAndView = new ModelAndView("redirect:/auth/report/");
	        }
			else
	        modelAndView = new ModelAndView("nationalityPdfReport", parameterMap);
	 
	        return modelAndView;
	 
	    }
	 @ModelAttribute("yearList")
	 public Map<Integer,Integer> populateCreditCardTypes() {
Map<Integer,Integer> year = new LinkedHashMap<Integer,Integer>();
Calendar yr = Calendar.getInstance();
int yrs = Calendar.getInstance().get(Calendar.YEAR);
		int counter = 0;
		while(yrs!=2003){
			yr.add(Calendar.YEAR, counter);
			yrs = yr.get(Calendar.YEAR);
			yr = Calendar.getInstance();
			year.put(yrs, yrs);
			System.out.println("The year is :"+yrs);
			counter--;
		}
	        return year;
	    }


}
