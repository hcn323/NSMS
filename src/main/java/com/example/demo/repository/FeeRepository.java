package com.example.demo.repository;

import com.example.demo.entity.Fee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeeRepository extends JpaRepository<Fee,Integer> {
}
