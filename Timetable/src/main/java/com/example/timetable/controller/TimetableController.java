package com.example.timetable.controller;

import com.example.timetable.model.Timetable;
import com.example.timetable.service.TimetableService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200	")

public class TimetableController {
    @Autowired
    private TimetableService timetableService;

    @GetMapping("/tt")
    public List<Timetable> getAllTimetables() {
        return timetableService.getAllTimetables();
    }

    @PostMapping("/tt/{id}")
    public void createTimetable(@RequestBody Timetable timetable) {
        timetableService.saveTimetable(timetable);
    }

    @PostMapping("/tt")
    public void generateTimetables(@RequestParam int classroomCount, @RequestParam int days, @RequestParam int slotsPerDay) {
        timetableService.generateTimetables(classroomCount, days, slotsPerDay);
    }
}
