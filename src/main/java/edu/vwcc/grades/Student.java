package edu.vwcc.grades;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Student {
    private String name;
    private final Map<String, Integer> grades;
    private final Set<LocalDate> attendance;
    public static final int NUM_IN_PERSON_CLASSES = 15;

    public Student(String name) {
        this.name = name;
        this.grades = new HashMap<>();
        // Initialize grades with null
        String[] keys = {"Homework1", "Quiz1", "Homework2", "Quiz2", "MidtermExam", 
                         "Homework3", "Quiz3", "Homework4", "Quiz4", "FinalExam"};
        for (String key : keys) {
            grades.put(key, null);
        }
        this.attendance = DataLoader.generateAttendanceRecords();
    }

    public Integer getStudentGrade(String key) {
        return grades.get(key);
    }

    public void setStudentGrade(String key, Integer value) {
        grades.put(key, value);
    }

    /**
     * TODO: Implement this method.
     * Sets all grades of a student at once.
     * The array order is: HW1, Q1, HW2, Q2, Midterm, HW3, Q3, HW4, Q4, Final
     */
    public void setGrades(int[] intArr) {
        // TODO: Your implementation here
    }

    public void markStudentPresent(LocalDate date) {
        attendance.add(date);
    }

    /**
     * TODO: Implement this method.
     * Returns the number of absences.
     */
    public int getAbsenceCount() {
        // TODO: Your implementation here
        return 0;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    public Set<LocalDate> getAttendance() {
        return attendance;
    }
}
