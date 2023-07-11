package com.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dal.entity.LocalTour;

@Repository
public interface LocalTourRepository extends JpaRepository<LocalTour, Long>{

}