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
}
