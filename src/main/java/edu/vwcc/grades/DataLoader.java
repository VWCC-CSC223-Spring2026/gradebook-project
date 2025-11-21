package edu.vwcc.grades;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DataLoader {

    /**
     * TODO: Implement this method.
     * Generates an array of 10 random grades between 50 and 100.
     */
    public static int[] generateGrades() {
        // TODO: Your implementation here
        return new int[10];
    }

    public static Set<LocalDate> generateAttendanceRecords() {
        Random random = new Random();
        Set<LocalDate> records = new HashSet<>();
        int numDays = random.nextInt(11) + 5; 
        for (int i = 0; i < numDays; ++i) {
            int dayOfYear = random.nextInt(365) + 1;
            LocalDate date = LocalDate.ofYearDay(2023, dayOfYear);
            records.add(date);
        }
        return records;
    }
}
