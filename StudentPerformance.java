import java.util.Scanner;

class Student {
    String name;
    int[] marks = new int[5];

    // Method to input student details
    void inputDetails(Scanner sc) {
        System.out.print("Enter student name: ");
        name = sc.nextLine();

        for (int i = 0; i < marks.length; i++) {
            while (true) {
                System.out.print("Enter marks for Subject "
                        + (i + 1) + " (0-100): ");

                if (sc.hasNextInt()) {
                    int mark = sc.nextInt();

                    if (mark >= 0 && mark <= 100) {
                        marks[i] = mark;
                        break;
                    } else {
                        System.out.println(
                                "Invalid marks! Enter between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid input! Enter an integer.");
                    sc.next();
                }
            }
        }
    }

    // Method to calculate total marks
    int calculateTotal() {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total;
    }

    // Method to calculate percentage
    double calculatePercentage() {
        return calculateTotal() / 5.0;
    }

    // Method to find highest marks
    int highestMarks() {
        int highest = marks[0];

        for (int mark : marks) {
            if (mark > highest) {
                highest = mark;
            }
        }

        return highest;
    }

    // Method to find lowest marks
    int lowestMarks() {
        int lowest = marks[0];

        for (int mark : marks) {
            if (mark < lowest) {
                lowest = mark;
            }
        }

        return lowest;
    }

    // Method to assign grade
    String calculateGrade(double percentage) {
        if (percentage >= 90)
            return "A+";
        else if (percentage >= 80)
            return "A";
        else if (percentage >= 70)
            return "B";
        else if (percentage >= 60)
            return "C";
        else if (percentage >= 50)
            return "D";
        else
            return "F";
    }

    // Method to check pass or fail
    boolean isPassed() {
        for (int mark : marks) {
            if (mark < 33) {
                return false;
            }
        }
        return true;
    }

    // Method to display performance report
    void displayReport() {
        int total = calculateTotal();
        double percentage = calculatePercentage();

        System.out.println("\n===== STUDENT PERFORMANCE REPORT =====");
        System.out.println("Student Name: " + name);

        for (int i = 0; i < marks.length; i++) {
            System.out.println("Subject " + (i + 1)
                    + " Marks: " + marks[i]);
        }

        System.out.println("Total Marks: " + total + " / 500");
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.println("Highest Marks: " + highestMarks());
        System.out.println("Lowest Marks: " + lowestMarks());
        System.out.println("Grade: " + calculateGrade(percentage));

        if (isPassed()) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }

        System.out.println("======================================");
    }
}

public class StudentPerformance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student student = new Student();

        student.inputDetails(sc);
        student.displayReport();

        sc.close();
    }
}
