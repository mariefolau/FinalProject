package com.example.PlannerApp.repository;


import com.example.PlannerApp.model.Planner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlannerRepository extends JpaRepository<Planner, Long> {
}
