import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    // ArrayList to store student grades
    private ArrayList<Double> grades;

    // Constructor to initialize the ArrayList
    public StudentGradeTracker() {
        grades = new ArrayList<>();
    }

    // Method to add a grade to the list
    public void addGrade(double grade) {
        grades.add(grade);
    }

    // Method to calculate the average grade
    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    // Method to find the highest grade
    public double findHighest() {
        if (grades.isEmpty()) {
            return 0;
        }
        double highest = grades.get(0);
        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    // Method to find the lowest grade
    public double findLowest() {
        if (grades.isEmpty()) {
            return 0;
        }
        double lowest = grades.get(0);
        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradeTracker gradeTracker = new StudentGradeTracker();

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Add a grade");
            System.out.println("2. Calculate average");
            System.out.println("3. Find highest grade");
            System.out.println("4. Find lowest grade");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    // Input loop to collect grades
                    while (true) {
                        System.out.print("Enter grade (or type 'done' to finish): ");
                        String input = scanner.nextLine();

                        if (input.equalsIgnoreCase("done")) {
                            break;
                        }

                        try {
                            double grade = Double.parseDouble(input);
                            if (grade < 0 || grade > 100) {
                                System.out.println("Please enter a grade between 0 and 100.");
                            } else {
                                gradeTracker.addGrade(grade);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid grade or type 'done' to finish.");
                        }
                    }
                    break;

                case "2":
                    // Calculate and display the average grade
                    if (gradeTracker.grades.isEmpty()) {
                        System.out.println("No grades entered.");
                    } else {
                        double average = gradeTracker.calculateAverage();
                        System.out.printf("Average grade: %.2f%n", average);
                    }
                    break;

                case "3":
                    // Find and display the highest grade
                    if (gradeTracker.grades.isEmpty()) {
                        System.out.println("No grades entered.");
                    } else {
                        double highest = gradeTracker.findHighest();
                        System.out.printf("Highest grade: %.2f%n", highest);
                    }
                    break;

                case "4":
                    // Find and display the lowest grade
                    if (gradeTracker.grades.isEmpty()) {
                        System.out.println("No grades entered.");
                    } else {
                        double lowest = gradeTracker.findLowest();
                        System.out.printf("Lowest grade: %.2f%n", lowest);
                    }
                    break;

                case "5":
                    // Exit the program
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
        }
    }
}
