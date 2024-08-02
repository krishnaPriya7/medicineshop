package com.example.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Meddetail;
import com.example.demo.Model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
	User findByEmail (String email);

	static List<Meddetail> findByMedicinenameContaining(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	
}