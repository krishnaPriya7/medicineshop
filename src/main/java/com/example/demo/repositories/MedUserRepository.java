package com.example.demo.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.Meddetail;




public interface MedUserRepository extends CrudRepository<Meddetail, Integer> {

	List<Meddetail> findByMedicinenameStartingWith(String keyword);


	
	
}