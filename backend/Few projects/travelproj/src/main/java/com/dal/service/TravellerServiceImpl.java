package com.dal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dal.entity.ForeignTour;
import com.dal.entity.LocalTour;
import com.dal.entity.Traveller;
import com.dal.repository.ForeignTourRepository;
import com.dal.repository.LocalTourRepository;
import com.dal.repository.TravellerRepository;

@Service
public class TravellerServiceImpl implements TravellerService{

	@Autowired
	TravellerRepository travellerRepository;
	
	@Autowired
	private LocalTourRepository localTourRepository;
	@Autowired
	private ForeignTourRepository foreignTourRepository;
	
	@Override
	public Traveller addTraveller(Traveller traveller) {
	
		return travellerRepository.save(traveller);
	}

	@Override
	public List<Traveller> listAllTravellers() {
		
		return (List<Traveller>) travellerRepository.findAll();
	}

	@Override
	public LocalTour saveLocalTourRequest(LocalTour localTour) {
		Traveller traveller = localTour.getTrtourist();
		localTour.setTrtourist(traveller);
		return localTourRepository.save(localTour);
	}

	@Override
	public ForeignTour saveForeignTourRequest(ForeignTour foreignTour) {
		Traveller traveller = foreignTour.getTrtourist();
		foreignTour.setTrtourist(traveller);
		return foreignTourRepository.save(foreignTour);
	}

	@Override
	public Traveller findByTravellerId(Long travelcode) {
		// TODO Auto-generated method stub
		return null;
	}

}
