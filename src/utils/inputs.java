package utils;

import java.util.Scanner;

public class inputs {

    static Scanner reader = new Scanner(System.in);

    public static float getFloatFromInput() {
        float number;
        do {
            while (!reader.hasNextFloat()) {
                System.out.print("Ingrese un decimal válido: ");
                reader.next();
            }
            number = reader.nextFloat();
        } while (number < 0);
        return number;
    }

    public static int getIntFromInput() {
        int number;
        do {
            while (!reader.hasNextInt()) {
                System.out.print("Ingrese un entero válido:");
                reader.next();
            }
            number = reader.nextInt();
        } while (number < 0);
        return number;
    }

    public static String getStringFromInput() {
        String string;
        do {
            while (!reader.hasNextLine()) {
                System.out.print("Ingrese texto válido:");
                reader.next();
            }
            string = reader.nextLine();
        } while (string.isEmpty());
        return string;
    }
}
