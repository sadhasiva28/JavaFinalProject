package com.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dal.entity.ForeignTour;

@Repository
public interface ForeignTourRepository extends JpaRepository<ForeignTour, Long>{

}
