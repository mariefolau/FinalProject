package com.example.PlannerApp.model;


import javax.persistence.*;

@Entity
@Table(name = "planner")
public class Planner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task")
    private String task;

    @Column(name = "date")
    private String date;

    @Column(name = "notes")
    private String notes;

    @Column(name = "complete")
    private boolean complete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public boolean isComplete() { return complete; }

    public void setComplete(boolean complete) { this.complete = complete; }
}

