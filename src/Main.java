import java.util.*;

public class Main {
    public static String output;

    public static void main(String[] args) {
        ask();
    }

    public static void ask(){
        Scanner inputType = new Scanner(System.in);
        System.out.println("Which type of unit are you converting from?");
        System.out.println("Binary/Hex/Decimal");
        String input = inputType.nextLine().strip().toLowerCase();
        System.out.println("Mode: " + input + " to ");
        System.out.println();

        Scanner outputType = new Scanner(System.in);
        System.out.println("Which type of unit are you converting to?");
        System.out.println("Binary/Hex/Decimal");
        output = outputType.nextLine().strip().toLowerCase();
        System.out.println("Mode: " + input + " to " + output);

        if (input.equals("binary")) {
            binaryAsk();



        }
    }

    public static void binaryAsk(){
        Scanner binaryInput = new Scanner(System.in);
        System.out.println("Insert a binary code (eight numbers)");
        String binary = binaryInput.nextLine();

        if (binary.length() == 8) {
            if (output.equals("decimal")) {

                System.out.println("Total is: " + binaryToDecimal(binary));
                ask();

            }
            else if (output.equals("hex")){

                int decimal = binaryToDecimal(binary);
                binaryToHex(decimal);
            }
        }
        else {
            System.out.println("You did not enter eight digits.");
            binaryAsk();

        }
    }


    public static int binaryToDecimal(String input) {
        int total = 0;
        int j = 0;



        for (int i = input.length()-1; i >= 0; i--) {
            String num = input.substring(i, i+1);

            int x = Integer.parseInt(num);


            if (x == 1) {
                total += Math.pow(2, j);

                j++;

            }
            else {
                j++;
            }

        }

        return total;
    }
    public static String binaryToHex(int input){

    }
}



