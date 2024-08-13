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
        System.out.println("5. Get a class information.");
        System.out.println("6. Get classes by student identification.");
        System.out.println("7. Exit.");
        System.out.print("Transaction #: ");
        int response = getIntFromInput();
        switch (response) {
            case 1:
                System.out.print("Enter class name:");
                String name = getStringFromInput();
                System.out.println(" ");
                Lecture newLecture = new Lecture(name);
                college.getGlobalLectures().add(newLecture);
                System.out.println("Class created successfully");
                System.out.println("------------------");
                break;
            case 2:
                Student newStudent = college.createStudent();
                college.getGlobalStudents().add(newStudent);
                System.out.println("Student created successfully");
                System.out.println("------------------");
                break;
            case 3:
                System.out.println("Choose a type of teacher:");
                System.out.println("1. Full time teacher.");
                System.out.println("2. Part time teacher.");
                System.out.print("Type:");
                int teacherType = getIntFromInput();
                Teacher newTeacher = college.createTeacher(teacherType);
                college.getGlobalTeachers().add(newTeacher);
                System.out.println("Teacher created successfully");
                System.out.println("------------------");
                break;
            case 4:

                System.out.println("------------------");
                break;
            case 5:

                System.out.println("------------------");
                break;
            default:
                break;
        }

        if (response != 7) {
            processUserTransaction(college);
        }
    }


}