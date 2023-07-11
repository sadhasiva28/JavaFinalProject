package com.dal.service;

import java.util.List;

import com.dal.entity.ForeignTour;
import com.dal.entity.LocalTour;
import com.dal.entity.Traveller;

public interface TravellerService {
	public Traveller addTraveller(Traveller traveller);
	public List<Traveller> listAllTravellers();
	public LocalTour saveLocalTourRequest(LocalTour localTour);
	public ForeignTour saveForeignTourRequest(ForeignTour foreignTour);
	
	public Traveller findByTravellerId(Long travelcode);
}
