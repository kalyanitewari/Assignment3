import java.util.ArrayList;
import java.util.Scanner;

public class StudentFunctions {
    ArrayList<Student> studentList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    private boolean isFirstIteration = true;

    public void addStudent() {
        System.out.println("Enter number of students that you want to add");
        int noOfStudents = sc.nextInt();
        sc.nextLine(); // consume the newline character after nextInt()
        System.out.println("Enter Student/s");
        for (int i = 0; i < noOfStudents; i++) {
            System.out.println("Enter PRN");
            int prn = sc.nextInt();
            sc.nextLine(); // consume the newline character after nextInt()
            System.out.println("Enter Name");
            String name = sc.nextLine();
            System.out.println("Enter Date of Birth (DOB)");
            String dob = sc.nextLine();
            System.out.println("Enter Marks");
            double marks = sc.nextDouble();
            sc.nextLine(); // consume the newline character after nextDouble()
            Student student = new Student(prn, name, dob, marks);
            studentList.add(student);
        }
    }

    public void printStudentDetails() {
        System.out.println("--------- Student Information --------");

        for (int i = 0; i < studentList.size(); i++) {
            if (isFirstIteration) {
            	System.out.printf("%-15s %-20s %-15s %-10s%n", "PRN", "Name", "DOB", "Marks");
                isFirstIteration = false;
            }
            printStudent(i);
        }
    }

    public void printStudent(int i) {
        System.out.printf("%-15d %-20s %-15s %-10.2f%n",
                studentList.get(i).getPrn(),
                studentList.get(i).getName(),
                studentList.get(i).getDob(),
                studentList.get(i).getMarks());
    }

    public void deleteStudent() {
        System.out.println("Enter PRN for deleting the student");
        int prn = sc.nextInt();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getPrn() == prn) {
                System.out.println(studentList.get(i).getName() + " deleted from ArrayList");
                studentList.remove(i);
                return;
            }
        }
        System.out.println("Student not found");
    }
}
