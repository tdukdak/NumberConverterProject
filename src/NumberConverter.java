public class NumberConverter {
    private int[] digits;
    private String[] letterDigits;
    private int base;
    public static final String[] VALUES = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "+", "/"};

    public NumberConverter(String number, int base) {
        digits = new int[number.length()];
        for (int i = 0; i < number.length(); i++){
            String single = number.substring(i,i+1);
            int d = letterToNum(single);
            digits[i] = d;
        }
        this.base = base;
        if (base == 16){
            letterDigits = new String[number.length()];
            for (int i = 0; i < number.length(); i++){
                String single = number.substring(i,i+1);
                String digit = single;
                letterDigits[i] = digit;
            }
        }
    }

    public String displayOriginalNumber(){
        String blank = "";
        for (int i = 0; i < digits.length; i++){
            blank = blank + digits[i];
        }
        blank = blank + "\n";
        return blank;
    }

    public String displayAsNumber(int[] newDigits) {
        String blank = "";
        for (int i = 0; i < newDigits.length; i++) {
            blank = blank + newDigits[i];
        }
        blank = blank;
        return blank;
    }

    public String displayAsNumber(String[] newDigits){
        String blank = "";
        for (int i = 0; i < newDigits.length; i++){
            blank = blank + newDigits[i];
        }
        blank = blank;
        return blank;
    }

    public int[] getDigits(){
        return digits;
    }
    public String[] getLetterDigits(){
        return letterDigits;
    }
    public int[] convertToBinary(){
        String binary = "";
        String display = displayAsNumber(convertToDecimal());
        int num = Integer.parseInt(display);
        while ((num / 2) != 0){
            binary = num % 2 + binary;
            num = num/2;
        }
        binary = num%2 + binary;
        String numberAsString = binary;
        int[] toBinary = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++){
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            toBinary[i] = d;
        }
        return toBinary;
    }

    public int[] convertToDecimal(){
        int decimal = 0;
        for (int i = 0; i < digits.length; i++){
            decimal += ((digits[digits.length - 1 - i]) * (int)Math.pow(base, i));
        }

        String numberAsString = Integer.toString(decimal);
        int[] toDecimal = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++){
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            toDecimal[i] = d;
        }
        return toDecimal;
    }

     public int[] convertToOctal() {
        String octal = "";
        String display = displayAsNumber(convertToDecimal());
        int num = Integer.parseInt(display);
        while ((num / 8) != 0){
            octal = num % 8 + octal;
            num = num / 8;
        }
        octal = num % 8 + octal;
        String numberAsString = octal;
        int[] toOct = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++){
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            toOct[i] = d;
        }
        return toOct;
    }

    public String[] convertToHexadec() {
        String hex = "";
        String display = displayAsNumber(convertToDecimal());
        int num = Integer.parseInt(display);
        while ((num / 16) != 0){
            if (num % 16 > 9){
                hex = numGreater9(num % 16) + hex;
            }
            else{
                hex = num % 16 + hex;
            }
            num = num/16;
        }
        if (num % 16 > 9){
            hex = numGreater9(num%16) + hex;
        }
        else{
            hex = num % 16 + hex;
        }
        String numberAsString = hex;
        String[] toHex = new String[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++){
            String single = numberAsString.substring(i,i+1);
            String d = single;
            toHex[i] = d;
        }
        return toHex;
    }

    public String[] convertToAnyBase(int base10Num, int newBase) {
        String anyBase = "";
        int num = base10Num;
        while ((num / newBase) != 0){
            if (num % newBase > 9){
                anyBase = numGreater9(num % newBase) + anyBase;
            }
            else{
                anyBase = num % newBase + anyBase;
            }
            num = num / newBase;
        }
        if (num%newBase > 9){
            anyBase = numGreater9(num % newBase) + anyBase;
        }
        else{
            anyBase = num % newBase + anyBase;
        }
        String numberAsString = anyBase;
        String[] toAB = new String[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++){
            String single = numberAsString.substring(i,i+1);
            String d = single;
            toAB[i] = d;
        }
        return toAB;
    }
    public static int letterToNum(String letter)
    {
        for (int i = 0; i < VALUES.length; i++){
            if (letter.equals(VALUES[i])){
                return i;
            }
        }
        return -1;
    }
    private String numGreater9(int num){
        return VALUES[num];
    }
}