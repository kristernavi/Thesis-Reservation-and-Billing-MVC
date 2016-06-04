package com.thesis.service;

import com.thesis.model.EditReservation;
import com.thesis.model.ReservationPreLoad;

public interface ProccesReservationService {
	public String saveMethodCreditCard(ReservationPreLoad rpl);
	public String saveMethodCash(ReservationPreLoad rpl);
	public String editDaysSaveCreditCard(EditReservation toBeEdit);
	public String editDaysSaveCash(EditReservation toBeEdit);
	

}
