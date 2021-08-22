package com.example.PlannerApp.Service;

import com.example.PlannerApp.model.Planner;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PlannerService {
    List< Planner > getAllPlanners();
    void savePlanner(Planner task);
    Planner getPlannerById(long id);
    void deletePlannerById(long id);
    Page< Planner > findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
    void completePlannerById(long id);
}
