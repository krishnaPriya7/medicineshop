package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Meddetail;
import com.example.demo.repositories.MedUserRepository;
import com.example.demo.repositories.UserRepository;




@Service
public class  MedServiceImpl implements MedicineService {
    @Autowired
    private MedUserRepository userRepository;

    @Override
    public List<com.example.demo.Model.Meddetail> getAllMedicines() {
        return (List<Meddetail>) userRepository.findAll();
    }
}