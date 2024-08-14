import model.Entities.Lecture;
import model.users.FullTimeTeacher;
import model.users.PartTimeTeacher;
import model.users.Student;
import model.users.Teacher;

import static utils.inputs.*;

public class Main {

    public static void main(String[] args) {
        College college = new College("Globant college");
        System.out.println(" Welcome to " + college.getName() + ". what do you need today?");
        processUserTransaction(college);
    }

    public static void processUserTransaction(College college) {
        System.out.println("Select an option:");
        System.out.println("1. Teacher options.");
        System.out.println("2. Class options.");
        System.out.println("3. Student options.");
        System.out.println("4. Exit.");
        System.out.print("Transaction #: ");
        int response = getIntFromInput();
        switch (response) {
            case 1:
                System.out.println("------------------");
                System.out.println(college.teachersMenu());
                System.out.println("------------------");
                break;
            case 2:
                System.out.println("------------------");
                System.out.println(college.getLecturesInfo());
                System.out.println(college.lecturesMenu());
                System.out.println("------------------");
                break;
            case 3:
                System.out.println("------------------");
                System.out.println(college.getStudentsInfo());
                System.out.println(college.studentsMenu());
                System.out.println("------------------");
            default:
                break;
        }

        if (response != 4) {
            processUserTransaction(college);
        }
    }
}