package edu.vwcc.grades;

import java.util.ArrayList;
import java.util.List;

public class Gradebook {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    /**
     * TODO: Implement this method.
     * Calculates the final grade as the average of all 10 grades.
     * Round UP to the nearest integer (Math.ceil).
     */
    public int calculateFinalGrade(Student student) {
        // TODO: Your implementation here
        return 0;
    }

    /**
     * TODO: Implement this method.
     * Returns a list of students with a final grade < 70.
     */
    public List<Student> getFailingStudents() {
        // TODO: Your implementation here
        return new ArrayList<>();
    }

    /**
     * TODO: Implement this method.
     * Applies extra credit based on attendance.
     * If absences <= 2, add 3 points to FinalExam.
     * If absences <= 4, add 1 point to FinalExam.
     * Cap at 100.
     */
    public void applyAttendanceExtraCredit() {
        // TODO: Your implementation here
    }
}
