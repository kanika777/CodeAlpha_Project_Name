import java.util.Scanner;

class Student {
    String name;
    double[] grades;
    double average;

    // Constructor to initialize the student's name and the number of grades
    public Student(String name, int numGrades) {
        this.name = name;
        this.grades = new double[numGrades];
        this.average = 0.0;
    }

    // Method to calculate the average grade
    public void calculateAverage() {
        double total = 0;
        for (double grade : grades) {
            total += grade;
        }
        average = total / grades.length;
    }

    // Method to display student information
    public void displayStudentInfo() {
        System.out.println("Student: " + name);
        System.out.print("Grades: ");
        for (double grade : grades) {
            System.out.print(grade + " ");
        }
        System.out.println("\nAverage: " + average);
        System.out.println("Result: " + (average >= 60 ? "Pass" : "Fail"));
    }
}

public class GradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for the number of students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();  // Consume the leftover newline character

        // Create an array to store the students
        Student[] students = new Student[numStudents];

        // Input data for each student
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();

            System.out.print("Enter the number of grades for " + name + ": ");
            int numGrades = scanner.nextInt();
            scanner.nextLine();  // Consume the leftover newline character

            // Create a new student object
            students[i] = new Student(name, numGrades);

            // Input grades
            System.out.println("Enter the grades for " + name + ": ");
            for (int j = 0; j < numGrades; j++) {
                System.out.print("Grade " + (j + 1) + ": ");
                students[i].grades[j] = scanner.nextDouble();
            }
            scanner.nextLine();  // Consume the leftover newline character

            // Calculate average for the student
            students[i].calculateAverage();
        }

        // Display all students' information
        System.out.println("\nStudent Report:");
        for (Student student : students) {
            student.displayStudentInfo();
            System.out.println("-----------------------------");
        }

        scanner.close();
    }
}
