package com.dilli.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dilli.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{}
