package com.example.timetable.service;

import com.example.timetable.model.Subject;
import com.example.timetable.model.Timetable;
import com.example.timetable.repository.SubjectRepository;
import com.example.timetable.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TimetableService {
    @Autowired
    private TimetableRepository timetableRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Timetable> getAllTimetables() {
        return timetableRepository.findAll();
    }

    public void saveTimetable(Timetable timetable) {
        timetableRepository.save(timetable);
    }

    public void generateTimetables(int classroomCount, int days, int slotsPerDay) {
        List<Subject> subjects = subjectRepository.findAll();
        List<String> subjectNames = subjects.stream().map(Subject::getName).collect(Collectors.toList());

        List<List<String>> timetables = new ArrayList<>();
        for (int i = 0; i < classroomCount; i++) {
            timetables.add(generateTimetable(subjectNames, days, slotsPerDay));
        }

        ensureNoCollision(timetables, days, slotsPerDay);

        for (int i = 0; i < classroomCount; i++) {
            saveGeneratedTimetable(timetables.get(i), "Classroom " + (i + 1), days, slotsPerDay, subjects);
        }
    }

    private List<String> generateTimetable(List<String> subjects, int days, int slotsPerDay) {
        List<String> timetable = new ArrayList<>();

        for (int i = 0; i < days * slotsPerDay; i++) {
            timetable.add(subjects.get(i % subjects.size()));
        }

        Collections.shuffle(timetable);

        return timetable;
    }

    private void ensureNoCollision(List<List<String>> timetables, int days, int slotsPerDay) {
        int classroomCount = timetables.size();
        for (int day = 0; day < days; day++) {
            for (int slot = 0; slot < slotsPerDay; slot++) {
                for (int i = 0; i < classroomCount - 1; i++) {
                    for (int j = i + 1; j < classroomCount; j++) {
                        int index1 = day * slotsPerDay + slot;
                        int index2 = day * slotsPerDay + slot;
                        if (timetables.get(i).get(index1).equals(timetables.get(j).get(index2))) {
                            for (int swapIndex = 0; swapIndex < days * slotsPerDay; swapIndex++) {
                                if (!timetables.get(i).get(index1).equals(timetables.get(j).get(swapIndex)) &&
                                    !timetables.get(j).get(index2).equals(timetables.get(i).get(swapIndex))) {
                                    Collections.swap(timetables.get(j), index2, swapIndex);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void saveGeneratedTimetable(List<String> timetable, String classroom, int days, int slotsPerDay, List<Subject> subjects) {
        Map<String, String> subjectTeacherMap = subjects.stream()
                .collect(Collectors.toMap(Subject::getName, Subject::getTeacher));

        for (int day = 0; day < days; day++) {
            for (int slot = 0; slot < slotsPerDay; slot++) {
                Timetable entry = new Timetable();
                entry.setClassroom(classroom);
                entry.setDay(day);
                entry.setSlot(slot);
                String subject = timetable.get(day * slotsPerDay + slot);
                entry.setSubject(subject + " (" + subjectTeacherMap.get(subject) + ")");
                saveTimetable(entry);
            }
        }
    }
}
