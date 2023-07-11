package com.dal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dal.entity.Traveller;

@Repository
public interface TravellerRepository extends CrudRepository<Traveller, Long>{

	Traveller findByTravellerName(String username);

}
