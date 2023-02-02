import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8 or 10): ");
        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        while (!choice.equals("2") && !choice.equals("8") && !choice.equals("10") && !choice.equals("16")){
            System.out.print("Enter 2, 8, 10, or 16: ");
            choice = s.nextLine();
        }
        int base = Integer.parseInt(choice);
        System.out.print("Enter your number: ");
        String number = s.nextLine();
        if (base <= 10){
            while (isNum(number) == false){
                System.out.print("Enter an appropriate number according to your base: ");
                number = s.nextLine();
            }
            int[] numDigits = numAsDig(number);
            boolean correct = true;
            for (int digit : numDigits){
                if (digit >= base) {
                    correct = false;
                }
            }
            while (correct == false){
                System.out.print("Enter an fitting number according to your base: ");
                number = s.nextLine();
                numDigits = numAsDig(number);
                int correctCounter= 0;
                for (int digit : numDigits){
                    if (digit < base){
                        correctCounter++;
                    }
                }
                if (correctCounter == numDigits.length){
                    correct = true;
                }
            }
        }
        else if (base == 16){
            String[] digits = stringAsDig(number);
            boolean correct = true;
            for (int i = 0; i < digits.length; i++){
                if (NumberConverter.letterToNum(digits[i]) >= 16){
                    correct = false;
                }
            }
            while (correct == false){
                System.out.print("Enter an appropriate number according to your base: ");
                number = s.nextLine();
                digits = stringAsDig(number);
                int correctCounter = 0;
                for (String digit : digits){
                    if (NumberConverter.letterToNum(digit) < 16){
                        correctCounter++;
                    }
                }
                if (correctCounter == digits.length){
                    correct = true;
                }
            }
        }

        NumberConverter numCon = new NumberConverter(number, base);
        if (base == 16){
            String[] digits = numCon.getLetterDigits();
            System.out.println("\nDigit array: " + Arrays.toString(digits));
            System.out.println("Number: " + number);
        }
        else{
            int[] digits = numCon.getDigits();
            System.out.println("\nDigit array: " + Arrays.toString(digits));
            System.out.println("Number: " + numCon.displayOriginalNumber());
        }

        if (base == 10){
            System.out.println("Binary Number: " + numCon.displayAsNumber(numCon.convertToBinary()));
            System.out.println("Octal Number: " + numCon.displayAsNumber(numCon.convertToOctal()));
            System.out.println("Hexadecimal Number: " + numCon.displayAsNumber(numCon.convertToHexadec()));
        }
        if (base == 2){
            System.out.println("Octal Number: " + numCon.displayAsNumber(numCon.convertToOctal()));
            System.out.println("Decimal Number: " + numCon.displayAsNumber(numCon.convertToDecimal()));
            System.out.println("Hexadecimal Number: " + numCon.displayAsNumber(numCon.convertToHexadec()));
        }
        if (base == 8){
            System.out.println("Binary Number: " + numCon.displayAsNumber(numCon.convertToBinary()));
            System.out.println("Decimal Number: " + numCon.displayAsNumber(numCon.convertToDecimal()));
            System.out.println("Hexadecimal Number: " + numCon.displayAsNumber(numCon.convertToHexadec()));
        }
        if (base == 16){
            System.out.println("Binary Number: " + numCon.displayAsNumber(numCon.convertToBinary()));
            System.out.println("Octal Number: " + numCon.displayAsNumber(numCon.convertToOctal()));
            System.out.println("Decimal Number: " + numCon.displayAsNumber(numCon.convertToDecimal()));
        }

        System.out.print("\nEnter any number in base 10: ");
        number = s.nextLine();
        while (isNum(number) == false){
            System.out.print("Enter a base 10 number: ");
            number = s.nextLine();
        }
        int[] numberDigits = numAsDig(number);
        boolean correct = true;
        for (int digit : numberDigits){
            if (digit >= base) {
                correct = false;
            }
        }
        while (correct == false) {
            System.out.print("Enter a base 10 number: ");
            number = s.nextLine();
            numberDigits = numAsDig(number);
            int correctCounter = 0;
            for (int digit : numberDigits){
                if (digit < base){
                    correctCounter++;
                }
            }
            if (correctCounter == numberDigits.length){
                correct = true;
            }
        }
        int base10Num = Integer.parseInt(number);
        System.out.print("Enter any base from 1 to 64: ");
        String verify = s.nextLine();
        while (isNum(verify) == false){
            System.out.print("Please enter a number: ");
            verify = s.nextLine();
        }
        while (Integer.parseInt(verify) < 1 || Integer.parseInt(verify) > 64){
            System.out.print("Enter a number base 1-64: ");
            verify = s.nextLine();
        }
        base = Integer.parseInt(verify);
        System.out.println("Base " + base + " number: " + numCon.displayAsNumber(numCon.convertToAnyBase(base10Num, base)));
        s.close();
    }
    private static boolean isNum(String num){
        try{
            Integer.parseInt(num);
            return true;
        }
        catch (NumberFormatException ex){
            return false;
        }
    }

    private static int[] numAsDig(String num){
        int[] numberDigits = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            String single = num.substring(i,i+1);
            int d = Integer.parseInt(single);
            numberDigits[i] = d;
        }
        return numberDigits;
    }

    private static String[] stringAsDig(String num)
    {
        String[] numberDigits = new String[num.length()];
        for (int i = 0; i < num.length(); i++) {
            String single = num.substring(i,i+1);
            String d = single;
            numberDigits[i] = d;
        }
        return numberDigits;
    }
}
