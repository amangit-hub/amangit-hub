// package for array lst
import java.util.ArrayList;
// package for exception handling
import java.util.InputMismatchException;
// package for user input
import java.util.Scanner;

public class StudentRegistrationSystem {

    public static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        // creating object

        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Welcome to the HARAMAYA UNIVERSITY Student Registration System!");
            System.out.println("Please select an option:");
            System.out.println("1. Register a new student or senior student");
            System.out.println("2. View all registered students");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    registerStudent(scanner);
                    break;
                case 2:
                    viewRegisteredStudents();
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void registerStudent(Scanner scanner) {
        try {
            System.out.println("Enter the student's first name:");
            String firstName = scanner.nextLine();

            System.out.println("Enter the student's last name:");
            String lastName = scanner.nextLine();

            System.out.println("Enter the student's mother name:");
            String motherName = scanner.nextLine();

            System.out.println("Please enter your gender (Male/Female)||(M/F):");
            String gender = scanner.nextLine();

            System.out.println("your Nationality:");
            String nationality = scanner.nextLine();

// to check you are either foreigner or not


            if (nationality.equalsIgnoreCase("ethiopia")) {
                // Handling for students from Ethiopia

            } else {
                // Handling for students from other countries
                System.out.println("Enter Continent:");
                String continent = scanner.nextLine();

                System.out.println("Enter Country:");
                String country = scanner.nextLine();


            }

            System.out.println("Enter Region:");
            String region = scanner.nextLine();

            System.out.println("Enter the student's phone number:");
            String phoneNumber = scanner.nextLine();

// when we insert email it must  contain both  @ and .com other ways return invalid email format
            System.out.print("Enter your Email: ");
            String email = scanner.nextLine();
            // Validate email format
            if (!email.contains("@") || !email.endsWith(".com")) {
                System.out.println("Invalid email format. Please enter a valid email address.");
                return;
            }

            System.out.println("Enter the student's department or stream:");
            String department = scanner.nextLine();

            System.out.println("Do you have a student ID? (yes/no)");
            String userInput = scanner.nextLine();
//new student may not have student id but for registering senior student may be need
            int studentId = 0;
            if (userInput.equalsIgnoreCase("yes")) {
                System.out.println("Please enter your ID:");
                studentId = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                System.out.println("ID entered: " + studentId);
                // Further processing with the ID can be done here
            } else if (userInput.equalsIgnoreCase("no")) {
                System.out.println("You have no ID.");
                // Handle the case when the user has no ID
            } else {
                System.out.println("Invalid input. Please enter either 'yes' or 'no'.");
            }

            Student student = new Student(firstName, lastName, motherName, gender, nationality, region, phoneNumber, email, studentId, department);
            students.add(student);

            System.out.println("Student registered successfully!");
            System.out.println();
        }catch (InputMismatchException e){
            System.out.println("you entered mismatched with expexted input");
        }
        catch (Exception e) {
            System.out.println("An error occurred during student registration: " + e.getMessage());
            e.printStackTrace();
        }

    }

    private static void viewRegisteredStudents() {
        if (students.isEmpty()) {
            System.out.println("No students are registered yet.");
        } else {
            System.out.println("Registered students:");
            for (Student student : students) {
                System.out.println(student);

            }
        }
        System.out.println();
        System.out.println("Thank you for using this system!" +
                " I appreciate your participation .");
    }

    private static class Student {
        private String firstName;
        private String lastName;
        private String motherName;
        private String gender;
        private String nationality;
        private String region;
        private String phoneNumber;
        private String email;
        private int studentId;
        private String department;

        public Student(String firstName, String lastName, String motherName, String gender, String nationality, String region, String phoneNumber, String email, int studentId, String department) {
            this.firstName = firstName;

            this.lastName = lastName;

            this.motherName = motherName;

            this.gender = gender;

            this.nationality = nationality;

            this.region = region;

            this.phoneNumber = phoneNumber;

            this.email = email;

            this.studentId = studentId;

            this.department = department;
        }

        @Override
        public String toString() {
            return "Name: " + firstName + " " + lastName + "\n" +
                    "Mother Name: " + motherName + "\n" +
                    "Gender: " + gender + "\n" +
                    "Nationality: " + nationality + "\n" +
                    "Region: " + region + "\n" +
                    "Phone Number: " + phoneNumber + "\n" +
                    "Email: " + email + "\n" +
                    "Student ID: " + studentId + "\n" +
                    "Department/Stream: " + department + "\n";
        }
    }
}