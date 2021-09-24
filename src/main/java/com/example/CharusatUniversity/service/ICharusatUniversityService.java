package com.example.CharusatUniversity.service;


import com.example.CharusatUniversity.entity.CharusatUniversity;

import java.util.List;
import java.util.Optional;


public interface ICharusatUniversityService {
    List<CharusatUniversity> getAllDetails();
    Optional<CharusatUniversity> findById(int id);
    CharusatUniversity save(CharusatUniversity prd);
    void delete(int id);
}
