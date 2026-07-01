import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("        STUDENT GRADE CALCULATOR");
        System.out.println("=========================================");

        System.out.print("Enter number of subjects: ");
        int numberOfSubjects = sc.nextInt();

        int[] marks = new int[numberOfSubjects];
        int totalMarks = 0;

        // input marks for each subject
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();

            // simple validation
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.print("Invalid marks! Please enter marks between 0 and 100: ");
                marks[i] = sc.nextInt();
            }

            totalMarks = totalMarks + marks[i];
        }

        // calculate average percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // grade calculation based on average percentage
        char grade;

        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 40) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        // display results
        System.out.println("\n----------- RESULT -----------");
        System.out.println("Total Marks: " + totalMarks + " out of " + (numberOfSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
        System.out.println("-------------------------------");

        if (grade == 'F') {
            System.out.println("Status: Fail");
        } else {
            System.out.println("Status: Pass");
        }

        sc.close();
    }
}
