package com.example.CharusatUniversity.repository;

import com.example.CharusatUniversity.entity.CharusatUniversity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharusatUniversityRepository extends JpaRepository<CharusatUniversity, Integer> {
}
