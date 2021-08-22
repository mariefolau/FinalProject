package com.example.PlannerApp.controller;

import com.example.PlannerApp.model.Planner;
import com.example.PlannerApp.Service.PlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.swing.*;
import java.util.List;

@Controller
public class PlannerController {

    @Autowired
    private PlannerService plannerService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(1, "task", "asc", model);
    }

    @GetMapping("/showNewTaskForm")
    public String showNewTaskForm(Model model) {
        Planner task = new Planner();
        model.addAttribute("task", task);
        return "new_task";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        Planner task = plannerService.getPlannerById(id);

        model.addAttribute("planner", task);
        return "update_task";
    }
    @PostMapping("/savePlanner")
    public String savePlanner(Planner planner) {
        plannerService.savePlanner(planner);
        return "redirect:/";
    }

    @GetMapping("/deleteTasks/{id}")
    public String deleteTasks(@PathVariable(value = "id") long id) {

        this.plannerService.deletePlannerById(id);
        return "redirect:/";
    }


    @GetMapping("/completeTasks/{id}")
    public String completeTasks(@PathVariable(value = "id") long id) {

        this.plannerService.deletePlannerById(id);
        return "redirect:/";
    }


    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page< Planner > page = plannerService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List< Planner > listTasks = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listTasks", listTasks);
        return "index";
    }
}
