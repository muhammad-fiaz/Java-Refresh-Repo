
public class NumberManipulationExample {
    public static void main(String[] args) {
        // ===================== 1. Basic Arithmetic Operations =====================
        int num1 = 10;
        int num2 = 5;
        System.out.println("Addition: " + (num1 + num2));  // Output: 15
        System.out.println("Subtraction: " + (num1 - num2));  // Output: 5
        System.out.println("Multiplication: " + (num1 * num2));  // Output: 50
        System.out.println("Division: " + (num1 / num2));  // Output: 2
        System.out.println("Modulus: " + (num1 % num2));  // Output: 0

        // ===================== 2. Floating-point Operations =====================
        double num3 = 15.7;
        double num4 = 2.5;
        System.out.println("Floating-point Addition: " + (num3 + num4));  // Output: 18.2
        System.out.println("Floating-point Subtraction: " + (num3 - num4));  // Output: 13.2
        System.out.println("Floating-point Multiplication: " + (num3 * num4));  // Output: 39.25
        System.out.println("Floating-point Division: " + (num3 / num4));  // Output: 6.28

        // ===================== 3. Math Class Functions =====================
        System.out.println("Square root of 25: " + Math.sqrt(25));  // Output: 5.0
        System.out.println("Power of 2^3: " + Math.pow(2, 3));  // Output: 8.0
        System.out.println("Absolute value of -45: " + Math.abs(-45));  // Output: 45
        System.out.println("Maximum of 10 and 20: " + Math.max(10, 20));  // Output: 20
        System.out.println("Minimum of 10 and 20: " + Math.min(10, 20));  // Output: 10
        System.out.println("Random number between 0 and 1: " + Math.random());  // Output: a random value between 0 and 1
        System.out.println("Round 4.6 to nearest integer: " + Math.round(4.6));  // Output: 5

        // ===================== 4. Type Conversion (Casting) =====================
        double doubleNum = 123.45;
        int intNum = (int) doubleNum;  // Convert double to int (loses fractional part)
        System.out.println("Double to Integer: " + intNum);  // Output: 123

        intNum = 100;
        doubleNum = (double) intNum;  // Convert int to double
        System.out.println("Integer to Double: " + doubleNum);  // Output: 100.0

        // ===================== 5. Decimal Formatting =====================
        double num5 = 123.456789;
        System.out.printf("Formatted to 2 decimal places: %.2f\n", num5);  // Output: 123.46
        System.out.printf("Formatted to 3 decimal places: %.3f\n", num5);  // Output: 123.457

        // ===================== 6. Comparison of Numbers =====================
        int a = 5;
        int b = 10;
        System.out.println("Is a greater than b? " + (a > b));  // Output: false
        System.out.println("Is a less than b? " + (a < b));  // Output: true
        System.out.println("Is a equal to b? " + (a == b));  // Output: false
        System.out.println("Is a not equal to b? " + (a != b));  // Output: true

        // ===================== 7. Converting String to Number =====================
        String numString = "250";
        int numFromString = Integer.parseInt(numString);  // Convert String to Integer
        System.out.println("String '250' to Integer: " + numFromString);  // Output: 250

        numString = "250.75";
        double numFromStringDouble = Double.parseDouble(numString);  // Convert String to Double
        System.out.println("String '250.75' to Double: " + numFromStringDouble);  // Output: 250.75

        // ===================== 8. Number to String =====================
        int intValue = 150;
        String strFromInt = String.valueOf(intValue);  // Convert Integer to String
        System.out.println("Integer to String: " + strFromInt);  // Output: 150

        double doubleValue = 123.45;
        String strFromDouble = String.valueOf(doubleValue);  // Convert Double to String
        System.out.println("Double to String: " + strFromDouble);  // Output: 123.45

        // ===================== 9. Number Range Check =====================
        int numToCheck = 45;
        if (numToCheck >= 10 && numToCheck <= 50) {
            System.out.println("Number is between 10 and 50");
        } else {
            System.out.println("Number is not in the range 10 to 50");
        }
        // Output: Number is between 10 and 50

        // ===================== 10. Parsing Integer/Double with Try-Catch =====================
        String invalidNum = "abc";
        try {
            int parsedNum = Integer.parseInt(invalidNum);  // Try to parse a non-numeric string
            System.out.println("Parsed number: " + parsedNum);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format!");
        }
        // Output: Error: Invalid number format!
    }
}
