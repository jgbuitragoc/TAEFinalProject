import model.Entities.Lecture;

import java.util.ArrayList;
import java.util.List;

import static utils.inputs.*;

public class Main {


    public static void main(String[] args) {
        List<Lecture> globalLectures = new ArrayList<>();
        System.out.println(" Welcome to Globant college. what do you need today?");
        processUserTransaction(globalLectures);
    }

    public static void processUserTransaction(List<Lecture> globalLectures) {
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

                System.out.println("------------------");
                break;
            case 2:

                System.out.println("------------------");
                break;
            case 3:

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
            processUserTransaction(globalLectures);
        }
    }

}