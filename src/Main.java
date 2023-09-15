import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner inputType = new Scanner(System.in);
        System.out.println("Which type of unit are you converting from?");
        System.out.println("Binary/Hex/Decimal");
        String input = inputType.nextLine().strip().toLowerCase();
        System.out.println("Mode: " + input + " to ");
        System.out.println();

        Scanner outputType = new Scanner(System.in);
        System.out.println("Which type of unit are you converting to?");
        System.out.println("Binary/Hex/Decimal");
        String output = outputType.nextLine().strip().toLowerCase();
        System.out.println("Mode: " + input + "to " + output);

        if (input.equals("binary")) {
            Scanner binaryInput = new Scanner(System.in);
            System.out.println("Insert a binary code (eight numbers)");
            String binary = binaryInput.nextLine();
            if (output.equals("decimal")) {

                binaryToDecimal(binary);
            }

        }
    }


    public static void binaryToDecimal(String input) {


        for (int i = input.length() - 1; i >= 0; i--) {
            int x = Integer.parseInt(input.substring(i, i+1));
            System.out.println(x);
        }
    }
}



