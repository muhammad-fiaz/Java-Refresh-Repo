public class ConversionExample {

    public static void main(String[] args) {
        // ===================== 1. Array to String =====================
        int[] intArray = {1, 2, 3, 4, 5};
        String intArrayToString = arrayToString(intArray);
        System.out.println("Array to String: " + intArrayToString);

        // ===================== 2. String to Array =====================
        String str = "Hello, World!";
        char[] stringToArray = stringToCharArray(str);
        System.out.println("String to Char Array: " + new String(stringToArray));

        // ===================== 3. Int to String =====================
        int num = 100;
        String intToString = intToString(num);
        System.out.println("Int to String: " + intToString);

        // ===================== 4. String to Int =====================
        String numStr = "200";
        int stringToInt = stringToInt(numStr);
        System.out.println("String to Int: " + stringToInt);

        // ===================== 5. Char to Array =====================
        char character = 'A';
        char[] charToArray = charToArray(character);
        System.out.println("Char to Array: " + new String(charToArray));

        // ===================== 6. Array to Char =====================
        char[] charArray = {'J', 'a', 'v', 'a'};
        char charFromArray = arrayToChar(charArray);
        System.out.println("Array to Char: " + charFromArray);

        // ===================== 7. String to Char Array =====================
        String strForCharArray = "Java Programming";
        char[] strToCharArray = stringToCharArray(strForCharArray);
        System.out.println("String to Char Array: " + new String(strToCharArray));

        // ===================== 8. Char Array to String =====================
        char[] charArr = {'C', 'o', 'd', 'e'};
        String charArrayToStr = charArrayToString(charArr);
        System.out.println("Char Array to String: " + charArrayToStr);

        // ===================== 9. String to Byte Array =====================
        String byteStr = "Hello Byte Array";
        byte[] stringToByteArray = stringToByteArray(byteStr);
        System.out.println("String to Byte Array: " + new String(stringToByteArray));

        // ===================== 10. Byte Array to String =====================
        byte[] byteArray = {72, 101, 108, 108, 111};
        String byteArrayToStr = byteArrayToString(byteArray);
        System.out.println("Byte Array to String: " + byteArrayToStr);

        // ===================== 11. Array of Strings to Single String =====================
        String[] stringArray = {"Java", "is", "fun"};
        String arrayToSingleString = arrayToSingleString(stringArray);
        System.out.println("Array of Strings to Single String: " + arrayToSingleString);

        // ===================== 12. Single String to Array of Strings =====================
        String singleString = "Java is fun";
        String[] singleStringToArray = stringToArray(singleString);
        System.out.print("Single String to Array of Strings: ");
        for (String s : singleStringToArray) {
            System.out.print(s + " ");  // Output: Java is fun
        }
        System.out.println();

        // ===================== 13. String to Char Sequence =====================
        CharSequence charSequence = stringToCharSequence(str);
        System.out.println("String to CharSequence: " + charSequence);

        // ===================== 14. Char Sequence to String =====================
        String charSeqToStr = charSequenceToString(charSequence);
        System.out.println("CharSequence to String: " + charSeqToStr);
    }

    // ===================== 1. Array to String =====================
    public static String arrayToString(int[] array) {
        return java.util.Arrays.toString(array); // Converts int array to string representation
    }

    // ===================== 2. String to Array =====================
    public static char[] stringToCharArray(String str) {
        return str.toCharArray(); // Converts String to char array
    }

    // ===================== 3. Int to String =====================
    public static String intToString(int num) {
        return Integer.toString(num); // Converts int to String
    }

    // ===================== 4. String to Int =====================
    public static int stringToInt(String str) {
        return Integer.parseInt(str); // Converts String to int
    }

    // ===================== 5. Char to Array =====================
    public static char[] charToArray(char c) {
        return new char[]{c}; // Converts char to a single-element char array
    }

    // ===================== 6. Array to Char =====================
    public static char arrayToChar(char[] array) {
        return array.length > 0 ? array[0] : '\0'; // Returns first char from char array
    }

    // ===================== 7. String to Char Array =====================
// Example of renaming the method to prevent conflicts
    public static char[] stringToCharArrayWithSpace(String str) {
        return str.toCharArray(); // Converts String to char array
    }


    // ===================== 8. Char Array to String =====================
    public static String charArrayToString(char[] array) {
        return new String(array); // Converts char array to String
    }

    // ===================== 9. String to Byte Array =====================
    public static byte[] stringToByteArray(String str) {
        return str.getBytes(); // Converts String to byte array
    }

    // ===================== 10. Byte Array to String =====================
    public static String byteArrayToString(byte[] array) {
        return new String(array); // Converts byte array to String
    }

    // ===================== 11. Array of Strings to Single String =====================
    public static String arrayToSingleString(String[] array) {
        return String.join(" ", array); // Joins array of strings into a single string
    }

    // ===================== 12. Single String to Array of Strings =====================
    public static String[] stringToArray(String str) {
        return str.split(" "); // Splits single string into an array of strings
    }

    // ===================== 13. String to Char Sequence =====================
    public static CharSequence stringToCharSequence(String str) {
        return new StringBuilder(str); // Converts String to CharSequence
    }

    // ===================== 14. Char Sequence to String =====================
    public static String charSequenceToString(CharSequence charSequence) {
        return charSequence.toString(); // Converts CharSequence to String
    }
}