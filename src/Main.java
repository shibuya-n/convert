import java.util.*;

public class Main {
    public static String output;

    public static void main(String[] args) {
        ask();
    }

    public static void ask() {
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
            switch (output){
                case "binary", "decimal", "hex":
                    break;
                default:
                    System.out.println("Invalid response. Try again.");
                    ask();
        }
        System.out.println("Mode: " + input + " to " + output);

        if (input.equals("binary")) {
            binaryAsk();
        }
        else if (input.equals("hex")) {
            hexAsk();
        }
        else if (input.equals("decimal")){
            decimalAsk();
        }
        else {
            System.out.println("Invalid response. Try again.");
            ask();
        }
    }

    public static void binaryAsk() {
        Scanner binaryInput = new Scanner(System.in);
        System.out.println("Insert a binary code (eight numbers)");
        String binary = binaryInput.nextLine();

        if (binary.length() == 8) {
            if (output.equals("decimal")) {

                System.out.println("Decimal conversion is: " + binaryToDecimal(binary));
                ask();

            } else if (output.equals("hex")) {


                System.out.println("Hex conversion is: " + binaryToHex(binary));
                ask();
            }
        } else {
            System.out.println("You did not enter eight digits.");
            binaryAsk();

        }
    }


    public static int binaryToDecimal(String input) {
        int total = 0;
        int j = 0;


        for (int i = input.length() - 1; i >= 0; i--) {
            String num = input.substring(i, i + 1);

            int x = Integer.parseInt(num);


            if (x == 1) {
                total += Math.pow(2, j);

                j++;

            } else {
                j++;
            }

        }

        return total;
    }

    public static String binaryToHex(String input) {
        String first = input.substring(0, 4);
        String last = input.substring(4, input.length());

        String[] binaryCode = {first, last};

        StringBuilder hex = new StringBuilder();

        for (int i = 0; i < binaryCode.length; i++) {
            switch (binaryCode[i]) {
                case "0000":
                    hex.append("0");
                    break;
                case "0001":
                    hex.append("1");
                    break;
                case "0010":
                    hex.append("2");
                    break;
                case "0011":
                    hex.append("3");
                    break;
                case "0100":
                    hex.append("4");
                    break;
                case "0101":
                    hex.append("5");
                    break;
                case "0110":
                    hex.append("6");
                    break;
                case "0111":
                    hex.append("7");
                    break;
                case "1000":
                    hex.append("8");
                    break;
                case "1001":
                    hex.append("9");
                    break;
                case "1010":
                    hex.append("A");
                    break;
                case "1011":
                    hex.append("B");
                    break;
                case "1100":
                    hex.append("C");
                    break;
                case "1101":
                    hex.append("D");
                    break;
                case "1110":
                    hex.append("E");
                    break;
                case "1111":
                    hex.append("F");
                    break;
            }


        }

        return hex.toString();
    }

    public static void hexAsk() {
        Scanner hexInput = new Scanner(System.in);
        System.out.println("Insert a hex code");
        String hex = hexInput.nextLine().toUpperCase();

        if (output.equals("decimal")) {

            System.out.println("Decimal conversion is: " + hexToDecimal(hex));
            ask();

        } else if (output.equals("binary")) {

            System.out.println("Binary conversion is is: " + decimalToBinary(hexToDecimal(hex)));
            ask();
        } else {
            System.out.println("Wrong input. Try again.");
            hexAsk();
        }
    }

    public static int hexToDecimal(String input) {
        int total = 0;
        int j = 0;

        ArrayList<Integer> individualHex = new ArrayList<>();


        for (int i = input.length() - 1; i >= 0; i--) {
            String num = input.substring(i, i + 1);
            switch (num) {
                case "A":
                    individualHex.add(10);
                    break;
                case "B":
                    individualHex.add(11);
                    break;
                case "C":
                    individualHex.add(12);
                    break;
                case "D":
                    individualHex.add(13);
                    break;
                case "E":
                    individualHex.add(14);
                    break;
                case "F":
                    individualHex.add(15);
                    break;

                default:
                     individualHex.add(Integer.parseInt(num));

            }

        }
        for (int i = 0; i < individualHex.size(); i++){
            total += individualHex.get(i) * Math.pow(16, j);

            j++;
        }
        return total;
        }

    public static void decimalAsk() {
        Scanner decInput = new Scanner(System.in);
        System.out.println("Insert a decimal code");
        int decimal = decInput.nextInt();

        if (output.equals("binary")) {

            System.out.println("Decimal conversion is: " + decimalToBinary(decimal));
            ask();

        } else if (output.equals("hex")) {





            System.out.println("Hex conversion is: " + binaryToHex(decimalToBinary(decimal)));
            ask();
        } else {
            System.out.println("Wrong input. Try again.");
            decimalAsk();
        }
    }
    public static String decimalToBinary(int input){
        ArrayList<String> binaryCode = new ArrayList<>();
        String binary = "";

        int temp = input;
        while (temp > 0) {
            int x = temp/2;
            binaryCode.add(String.valueOf(temp % 2));
            temp = x;
        }
        for (int i = binaryCode.size()-1; i >= 0; i--){
            binary += binaryCode.get(i);
        }
        if (binary.length() == 8){
            return binary;
        }
        else {
            int runTime = 8 - binary.length();
            for (int i = 0; i < runTime; i++){
                binary = "0" + binary;
            }
        }

        return binary;
    }
}




