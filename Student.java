import java.util.*;

public class Student {
    private String studentName;
    private String studentID;
    private String studentMajor;
    private int year;
    private List<String> subjects;
    private List<Integer> creditHours;

    public Student(String name) {
        this.studentName = name;
        this.subjects = new ArrayList<>();
        this.creditHours = new ArrayList<>();
    }

    public void registerSubject(String subjectName, int hours) {
        subjects.add(subjectName);
        creditHours.add(hours);
    }

    public int getTotalHours() {
        int total = 0;
        for (int h : creditHours) {
            total += h;
        }
        return total;
    }

    public void displayInfo() {
        System.out.println("\n--- Student Info ---");
        System.out.println("Name: " + studentName);
        System.out.println("Major: " + studentMajor);
        System.out.println("ID: " + studentID);
        System.out.println("Registered Subjects & Hours:");
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println("- " + subjects.get(i) + ": " + creditHours.get(i) + " Hours");
        }
        System.out.println("Total Registered Hours: " + getTotalHours());
    }

    public void calcGPA() {
        Scanner scanner = new Scanner(System.in);
        double totalGradePoints = 0;
        double totalCreditHours = 0;

        System.out.print("How many courses for GPA calculation? ");
        int numCourses = scanner.nextInt();

        for (int i = 1; i <= numCourses; i++) {
            System.out.println("\nCourse " + i + ":");
            System.out.print("Enter credit hours: ");
            int hours = scanner.nextInt();
            System.out.print("Enter grade (A, B, C, D, F): ");
            String grade = scanner.next().toUpperCase();
            double gradeValue = getGradeValue(grade);
            if (gradeValue == -1) {
                System.out.println("Invalid grade entered. Please try again.");
                i--;
                continue;
            }
            totalGradePoints += gradeValue * hours;
            totalCreditHours += hours;
        }

        if (totalCreditHours > 0) {
            double gpa = totalGradePoints / totalCreditHours;
            System.out.printf("Your GPA is: %.2f\n", gpa);
            if (gpa >= 3.5) {
                System.out.println("Excellent performance!");
            } else if (gpa >= 2.5) {
                System.out.println("Good performance.");
            } else {
                System.out.println("Consider improving your grades.");
            }
        } else {
            System.out.println("No valid courses entered.");
        }
    }

    private double getGradeValue(String grade) {
        switch (grade) {
            case "A":
                return 4.0;
            case "B":
                return 3.0;
            case "C":
                return 2.0;
            case "D":
                return 1.0;
            case "F":
                return 0.0;
            default:
                return -1;
        }
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getMajor() {
        return studentMajor;
    }

    public int getYear() {
        return year;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setMajor(String major) {
        this.studentMajor = major;
    }

    public void setYear(int year) {
        this.year = year;
    }
}