package com.curriculum.vitae.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curriculum.vitae.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	
}
