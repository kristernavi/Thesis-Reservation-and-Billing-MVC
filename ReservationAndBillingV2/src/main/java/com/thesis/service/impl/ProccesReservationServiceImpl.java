package com.thesis.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.model.CreditCard;
import com.thesis.dao.BillingDao;
import com.thesis.dao.CreditCardDao;
import com.thesis.dao.ReservationDao;
import com.thesis.dao.RoomDao;
import com.thesis.dao.RoomReservationDao;
import com.thesis.model.Billing;
import com.thesis.model.BillingMethod;
import com.thesis.model.EditReservation;
import com.thesis.model.Reservation;
import com.thesis.model.ReservationPreLoad;
import com.thesis.model.Room;
import com.thesis.model.RoomReservation;
import com.thesis.service.ProccesReservationService;
@Service
public class ProccesReservationServiceImpl implements ProccesReservationService {


	@Autowired
	private CreditCardDao ccDao;
	@Autowired
	private RoomDao roomDao;
	@Autowired
	private ReservationDao reservationDao;
	@Autowired
	private BillingDao billingDao;
	@Autowired
	private RoomReservationDao rrDao;
	@Override
	@Transactional
	public String saveMethodCreditCard(ReservationPreLoad rpl) {
		boolean isConflict = false;
		System.out.println("print this one: "+rpl.getAr().getRoom_id());
		CreditCard cc = ccDao.getByNumberCreditCard(rpl.getCcBillingReservation().getCc().getNumber());
		Billing billing = new Billing();
		String result = null;
		if(cc!=null)
		{
			if(cc.getBalance().compareTo(rpl.getCcBillingReservation().getAmount_pay())>=0)
			{
				for(long id: rpl.getAr().getRoom_id()){
					if(roomDao.checkIfAvailable(rpl.getCheck_in(), rpl.getCheck_out(), id)==1)
					{
						isConflict=false;
					}
					else
					{
						isConflict=true;
						System.out.println("conflict happen");
						result = "conflict";
						break;
					}
				
						
					
				
				}
				if(!isConflict)
				{
				Reservation reservation = new Reservation();
				List<RoomReservation> rr = new ArrayList<RoomReservation>();
				
				for(long id: rpl.getAr().getRoom_id()){
					
					Room r = roomDao.getRoom(id);
					RoomReservation rr2 = new RoomReservation();
					rr2.setRoom(r);
					rr2.setReserve(reservation);
					rr2.setFrom(rpl.getCheck_in());
					rr2.setTo(rpl.getCheck_out());
					rr.add(rr2);
					
					
				}
				reservation.setRoomReservation(rr);
				reservation.setClient(rpl.getCcBillingReservation().getReservation().getClient());
				reservation.setPayable(rpl.getCcBillingReservation().getAmount_pay());
				reservation.setReserveDate(new Date());
				reservation.setRoomReservation(rr);
				reservation.setReference(rpl.getCcBillingReservation().getReservation().getReference());
				reservationDao.save(reservation);
				billing.setAmount(rpl.getCcBillingReservation().getAmount_pay());
				billing.setDate(new Date());
				billing.setId_came("R");
				billing.setId_recieve(reservation.getId());
				billing.setMethod(BillingMethod.CREDIT_CARD);
				billingDao.saveBilling(billing);
				cc.setBalance(cc.getBalance().subtract(rpl.getCcBillingReservation().getAmount_pay()));
				ccDao.save(cc);
				result = "success";
			}
			}
			
			else
			{
				result =  "insuficient";
				
			}
		}
		else
		{
			result =  "notfound";
		}
		
		return result;
	}
	@Override
	@Transactional
	public String saveMethodCash(ReservationPreLoad rpl) {
		boolean isConflict = false;
		Billing billing = new Billing();
		String result = null;
		for(long id: rpl.getAr().getRoom_id()){
			if(roomDao.checkIfAvailable(rpl.getCheck_in(), rpl.getCheck_out(), id)==1)
			{
				isConflict=false;
			}
			else
			{
				isConflict=true;
				System.out.println("conflict happen");
				result = "conflict";
				break;
			}
		
				
			
		
		}
			if(!isConflict)
			{
			Reservation reservation = new Reservation();
			List<RoomReservation> rr = new ArrayList<RoomReservation>();
			
			for(long id: rpl.getAr().getRoom_id()){
				
				Room r = roomDao.getRoom(id);
				RoomReservation rr2 = new RoomReservation();
				rr2.setRoom(r);
				rr2.setReserve(reservation);
				rr2.setFrom(rpl.getCheck_in());
				rr2.setTo(rpl.getCheck_out());
				rr.add(rr2);
				
				
			}
			reservation.setRoomReservation(rr);
			reservation.setClient(rpl.getCcBillingReservation().getReservation().getClient());
			reservation.setPayable(rpl.getCcBillingReservation().getAmount_pay());
			reservation.setReserveDate(new Date());
			reservation.setRoomReservation(rr);
			reservation.setReference(RandomStringUtils.randomAlphanumeric(12).toUpperCase());
			reservationDao.save(reservation);
			billing.setAmount(rpl.getCcBillingReservation().getAmount_pay());
			billing.setDate(new Date());
			billing.setId_came("R");
			billing.setId_recieve(reservation.getId());
			billing.setMethod(BillingMethod.CASH);
			billingDao.saveBilling(billing);
			result = "success";
		}
				
			
		

	

		
		return result;
	}
	@Transactional
	public String editDaysSaveCreditCard(EditReservation toBeEdit)
	{
		boolean isConflict = false;
		Reservation reservation = reservationDao.getReservation(toBeEdit.getReserve_id());
		CreditCard cc = ccDao.getByNumberCreditCard(toBeEdit.getCc_number());
		BigDecimal newBal = new BigDecimal(0);
		long diff2 = Math.abs(toBeEdit.getEditTo().getTime() - toBeEdit.getEditFrom().getTime());
		long diffDays = diff2 / (24 * 60 * 60 * 1000);
		for(RoomReservation rr: reservation.getRoomReservation())
		{
			newBal = newBal.add(rr.getRoom().getRate().multiply(new BigDecimal(diffDays)));
		}
		toBeEdit.setNewPayable(newBal);
		for(RoomReservation rr: reservation.getRoomReservation())
		{
			if(roomDao.checkIfAvailableEdit(toBeEdit.getEditFrom(), toBeEdit.getEditTo(), rr.getRoom().getId(),rr.getId())==1)
			{
				isConflict = false;
				System.out.println("no conflict happen");
			}
			else
			{
				isConflict=true;
				System.out.println("conflict happen");
				return "conflict";

			}
		}
		if(!isConflict){
			System.out.println("no conflict happen procceed this part");
			if(cc!=null)
			{
				if(reservation.getPayable().compareTo(toBeEdit.getNewPayable())>=0)
				{
				//	rrDao.changeDate(toBeEdit.getEditFrom(), toBeEdit.getEditTo(), reservation.getId());
					System.out.println("no conflict happen procceed this part2");
					for(RoomReservation rr: reservation.getRoomReservation())
					{
						rr.setFrom(toBeEdit.getEditFrom());
						rr.setTo(toBeEdit.getEditTo());
						rrDao.save(rr);
					}
					return "success";
				}
				else
				{
					System.out.println("no conflict happen procceed this part3 how much"+ toBeEdit.getNewPayable().subtract(reservation.getPayable()));
					if(cc.getBalance().compareTo(toBeEdit.getNewPayable().subtract(reservation.getPayable()))>=0)
					{
						System.out.println("no conflict happen procceed this part4");
					BigDecimal diff = toBeEdit.getNewPayable().subtract(reservation.getPayable());
					BigDecimal newPayable = reservation.getPayable().add(diff);
					cc.setBalance(cc.getBalance().subtract(diff));
					ccDao.save(cc);
					Billing bill = new Billing();
					
					bill.setMethod(BillingMethod.CREDIT_CARD);
					bill.setId_came("R");
					bill.setId_recieve(reservation.getId());
					bill.setAmount(diff);
					bill.setDate(new Date());
					billingDao.saveBilling(bill);
					for(RoomReservation rr: reservation.getRoomReservation())
					{
						rr.setFrom(toBeEdit.getEditFrom());
						rr.setTo(toBeEdit.getEditTo());
						rrDao.save(rr);
					}
					
					reservation.setPayable(newPayable);
					reservationDao.save(reservation);
					return "success";
					}
					else
					{
						System.out.println("no conflict happen procceed this part5");
						return  "insuficient";
					}

				}
				
			}
			else
			{
				return "notfound";
			}
		}
		
		return  null;
	}
	
	@Transactional
	public String editDaysSaveCash(EditReservation toBeEdit)
	{
		boolean isConflict = false;
		Reservation reservation = reservationDao.getReservation(toBeEdit.getReserve_id());
		BigDecimal newBal = new BigDecimal(0);
		long diff2 = Math.abs(toBeEdit.getEditTo().getTime() - toBeEdit.getEditFrom().getTime());
		long diffDays = diff2 / (24 * 60 * 60 * 1000);
		for(RoomReservation rr: reservation.getRoomReservation())
		{
			newBal = newBal.add(rr.getRoom().getRate().multiply(new BigDecimal(diffDays)));
		}
		toBeEdit.setNewPayable(newBal);
		for(RoomReservation rr: reservation.getRoomReservation())
		{
			if(roomDao.checkIfAvailableEdit(toBeEdit.getEditFrom(), toBeEdit.getEditTo(), rr.getRoom().getId(),rr.getId())==1)
			{
				isConflict = false;
				System.out.println("no conflict happen");
			}
			else
			{
				isConflict=true;
				System.out.println("conflict happen");
				return "conflict";

			}
		}
		if(!isConflict){
			System.out.println("no conflict happen procceed this part");
			
				if(reservation.getPayable().compareTo(toBeEdit.getNewPayable())>=0)
				{
				//	rrDao.changeDate(toBeEdit.getEditFrom(), toBeEdit.getEditTo(), reservation.getId());
					System.out.println("no conflict happen procceed this part2");
					for(RoomReservation rr: reservation.getRoomReservation())
					{
						
						rr.setFrom(toBeEdit.getEditFrom());
						rr.setTo(toBeEdit.getEditTo());
						rrDao.save(rr);
						
					}
					return "success";
				}
				else
				{
					System.out.println("no conflict happen procceed this part3 how much"+ toBeEdit.getNewPayable().subtract(reservation.getPayable()));
						System.out.println("no conflict happen procceed this part4");
					BigDecimal diff = toBeEdit.getNewPayable().subtract(reservation.getPayable());
					BigDecimal newPayable = reservation.getPayable().add(diff);
					Billing bill = new Billing();
					
					bill.setMethod(BillingMethod.CASH);
					bill.setId_came("R");
					bill.setId_recieve(reservation.getId());
					bill.setAmount(diff);
					bill.setDate(new Date());
					billingDao.saveBilling(bill);
					for(RoomReservation rr: reservation.getRoomReservation())
					{
						rr.setFrom(toBeEdit.getEditFrom());
						rr.setTo(toBeEdit.getEditTo());
						rrDao.save(rr);
					}
					
					reservation.setPayable(newPayable);
					reservationDao.save(reservation);
					return "success";
					}
					

				
			
		}
		
		return  null;
	}

	
}
	