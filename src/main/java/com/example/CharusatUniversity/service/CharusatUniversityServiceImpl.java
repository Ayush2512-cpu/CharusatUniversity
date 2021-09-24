package com.example.CharusatUniversity.service;

import com.example.CharusatUniversity.entity.CharusatUniversity;
import com.example.CharusatUniversity.repository.CharusatUniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CharusatUniversityServiceImpl implements ICharusatUniversityService{

    @Autowired
    CharusatUniversityRepository charusatUniversityRepository;
    @Override
    public List<CharusatUniversity> getAllDetails() {
        return charusatUniversityRepository.findAll();
    }
    @Override
    public Optional<CharusatUniversity> findById(int id) {
        return charusatUniversityRepository.findById(id);
    }
    @Override
    public CharusatUniversity save(CharusatUniversity course) {
        return charusatUniversityRepository.save(course);
    }
    @Override
    public void delete(int id) {
        charusatUniversityRepository.deleteById(id);
    }
}