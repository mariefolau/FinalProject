package com.example.PlannerApp.Service;

import com.example.PlannerApp.model.Planner;
import com.example.PlannerApp.repository.PlannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class   PlannerServiceImpl implements com.example.PlannerApp.Service.PlannerService {

    @Autowired
    private PlannerRepository plannerRepository;


    @Override
    public List<Planner> getAllPlanners() {
        return null;
    }

    @Override
    public void savePlanner(Planner task) {
        this.plannerRepository.save(task);
    }

    @Override
    public Planner getPlannerById(long id) {
        Optional< Planner > optional = plannerRepository.findById(id);
        Planner planner = null;
        if (optional.isPresent()) {
            planner = optional.get();
        } else {
            throw new RuntimeException(" Planner not found for id :: " + id);
        }
        return planner;
    }

    @Override
    public void deletePlannerById(long id) {
        this.plannerRepository.deleteById(id);
    }

    @Override
    public Page<Planner> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.plannerRepository.findAll(pageable);
    }

    @Override
    public void completePlannerById(long id) {
        Optional< Planner > optional = plannerRepository.findById(id);
        Planner planner = null;
        if (optional.isPresent()) {
            planner = optional.get();
            planner.setComplete(true);
            savePlanner(planner);
        } else {
            throw new RuntimeException(" Planner not found for id :: " + id);
        }
    }

}
