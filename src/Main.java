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
        System.out.println("Mode: " + input + " to " + output);

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
        int total = 0;
        int j = 0;

        for (int i = 0; i < input.length(); i++) {
            String num = input.substring(i-i, i-);

            int x = Integer.parseInt(num);
            System.out.print(x);





            if (x == 1) {
                total += Math.pow(x, j);
                System.out.println(total);
                j++;

            }
            else {
                j++;
            }

        }
        System.out.println("Result: " + total);
    }
}



