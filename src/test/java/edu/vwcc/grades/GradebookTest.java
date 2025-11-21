package edu.vwcc.grades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class GradebookTest {

    private Gradebook gradebook;
    private Student student;

    @BeforeEach
    public void setUp() {
        gradebook = new Gradebook();
        student = new Student("Test Student");
        gradebook.addStudent(student);
    }

    @Test
    public void testCalculateFinalGrade() {
        // Set specific grades
        // 80, 80, 80, 80, 80, 80, 80, 80, 80, 85
        // Sum = 725. Average = 72.5. Ceil = 73.
        int[] grades = {80, 80, 80, 80, 80, 80, 80, 80, 80, 85};
        student.setGrades(grades);

        int finalGrade = gradebook.calculateFinalGrade(student);
        assertEquals(73, finalGrade, "Final grade should be 73 (72.5 rounded up)");
    }

    @Test
    public void testFailingStudents() {
        Student failingStudent = new Student("Failing Student");
        // Set grades to 50
        int[] failingGrades = {50, 50, 50, 50, 50, 50, 50, 50, 50, 50};
        failingStudent.setGrades(failingGrades);
        gradebook.addStudent(failingStudent);

        Student passingStudent = new Student("Passing Student");
        // Set grades to 80
        int[] passingGrades = {80, 80, 80, 80, 80, 80, 80, 80, 80, 80};
        passingStudent.setGrades(passingGrades);
        gradebook.addStudent(passingStudent);

        List<Student> failingList = gradebook.getFailingStudents();
        assertTrue(failingList.contains(failingStudent), "List should contain the failing student");
        assertFalse(failingList.contains(passingStudent), "List should not contain the passing student");
    }

    @Test
    public void testSetGrades() {
        int[] grades = {90, 91, 92, 93, 94, 95, 96, 97, 98, 99};
        student.setGrades(grades);
        
        assertEquals(90, student.getStudentGrade("Homework1"));
        assertEquals(99, student.getStudentGrade("FinalExam"));
    }

    @Test
    public void testAttendanceExtraCredit() {
        // Create a student with 0 absences (perfect attendance)
        Student perfectStudent = new Student("Perfect Student");
        // Manually clear attendance and add 15 days (assuming 15 total)
        // Actually, the skeleton generates random attendance. 
        // We need a way to force attendance for testing.
        // For this POC, let's assume we can add enough days to meet the threshold.
        // The skeleton `markStudentPresent` adds to the set.
        
        // Let's rely on the logic: 15 total classes.
        // We need <= 2 absences for +3 points.
        // So we need >= 13 days present.
        java.time.LocalDate start = java.time.LocalDate.of(2023, 1, 1);
        for (int i = 0; i < 14; i++) {
            perfectStudent.markStudentPresent(start.plusDays(i));
        }
        
        // Set a grade of 90 on FinalExam
        perfectStudent.setStudentGrade("FinalExam", 90);
        
        gradebook.addStudent(perfectStudent);
        gradebook.applyAttendanceExtraCredit();
        
        assertEquals(93, perfectStudent.getStudentGrade("FinalExam"), "Should receive +3 points for good attendance");
    }
}
