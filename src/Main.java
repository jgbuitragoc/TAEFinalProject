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
        System.out.println("1. Create a new class.");
        System.out.println("2. Create a new student.");
        System.out.println("3. Create a new teacher.");
        System.out.println("4. Get teacher's information.");
        System.out.println("5. Class options.");
        System.out.println("6. Student options.");
        System.out.println("7. Exit.");
        System.out.print("Transaction #: ");
        int response = getIntFromInput();
        switch (response) {
            case 1:
                System.out.println(college.createLecture());
                System.out.println("------------------");
                break;
            case 2:
                System.out.println(college.createStudent());
                System.out.println("------------------");
                break;
            case 3:
                System.out.println(college.createTeacher());
                System.out.println("------------------");
                break;
            case 4:
                System.out.println(college.getTeachersInfo());

                System.out.println("------------------");
                break;
            case 5:
                System.out.println(college.getLecturesInfo());
                System.out.println(college.lecturesMenu());
                System.out.println("------------------");
                break;
            case 6:
                System.out.println(college.getStudentsInfo());
                System.out.println(college.studentsMenu());
                System.out.println("------------------");
            default:
                break;
        }

        if (response != 7) {
            processUserTransaction(college);
        }
    }


}