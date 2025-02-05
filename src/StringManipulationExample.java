

public class  StringManipulationExample  {
    public static void main(String[] args) {
        // ===================== 1. Length of a String =====================
        String str = "  Hello World! Java is fun!   ";
        System.out.println("Length of string: " + str.length());
        // Output: Length of string: 31

        // ===================== 2. CharAt (Get character at index) =====================
        str = "Java Programming!";
        System.out.println("Character at index 5: " + str.charAt(5));
        // Output: Character at index 5: P

        // ===================== 3. Substring =====================
        str = "Hello Universe!";
        System.out.println("Substring from index 6 to 15: " + str.substring(6, 15));
        // Output: Substring from index 6 to 15: Universe

        // ===================== 4. Convert to Uppercase =====================
        str = "good morning!";
        System.out.println("Uppercase: " + str.toUpperCase());
        // Output: Uppercase: GOOD MORNING!

        // ===================== 5. Convert to Lowercase =====================
        str = "JAVA PROGRAMMING!";
        System.out.println("Lowercase: " + str.toLowerCase());
        // Output: Lowercase: java programming!

        // ===================== 6. Trim (Remove leading/trailing spaces) =====================
        str = "   Trim me now!   ";
        System.out.println("Trimmed string: '" + str.trim() + "'");
        // Output: Trimmed string: 'Trim me now!'

        // ===================== 7. Replace a character =====================
        str = "I love programming.";
        System.out.println("Replace 'o' with '0': " + str.replace('o', '0'));
        // Output: Replace 'o' with '0': I l0ve pr0gramming.

        // ===================== 8. Replace All occurrences (Regex) =====================
        str = "Java is awesome!";
        System.out.println("Replace 'awesome' with 'great': " + str.replaceAll("awesome", "great"));
        // Output: Replace 'awesome' with 'great': Java is great!

        // ===================== 9. Check if String contains a substring =====================
        str = "The quick brown fox jumps over the lazy dog";
        System.out.println("Contains 'fox': " + str.contains("fox"));
        // Output: Contains 'fox': true

        // ===================== 10. Check if String starts with a prefix =====================
        str = "Starting with hello";
        System.out.println("Starts with 'Starting': " + str.startsWith("Starting"));
        // Output: Starts with 'Starting': true

        // ===================== 11. Check if String ends with a suffix =====================
        str = "hello world";
        System.out.println("Ends with 'world': " + str.endsWith("world"));
        // Output: Ends with 'world': true

        // ===================== 12. Split the String =====================
        str = "apple,banana,orange";
        String[] fruits = str.split(",");
        System.out.println("Splitting by comma:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        // Output:
        // Splitting by comma:
        // apple
        // banana
        // orange

        // ===================== 13. Index of a character =====================
        str = "Find the T letter T";
        System.out.println("Index of 'T': " + str.indexOf('T'));
        // Output: Index of 'T': 16

        // ===================== 14. Last Index of a character =====================
        str = "Repeat after me: T, T, T";
        System.out.println("Last index of 'T': " + str.lastIndexOf('T'));
        // Output: Last index of 'T': 23

        // ===================== 15. Check if String is empty =====================
        str = "";
        System.out.println("Is the string empty? " + str.isEmpty());
        // Output: Is the string empty? true

        // ===================== 16. Check if String is equal to another String =====================
        String str2 = "Hello World!";
        str = "Hello World!";
        System.out.println("Is 'str' equal to 'str2'? " + str.equals(str2));
        // Output: Is 'str' equal to 'str2'? true

        // ===================== 17. Check if String is equal ignoring case =====================
        str = "hello world!";
        str2 = "HELLO WORLD!";
        System.out.println("Is 'str' equal to 'str2' ignoring case? " + str.equalsIgnoreCase(str2));
        // Output: Is 'str' equal to 'str2' ignoring case? true

        // ===================== 18. String to Char Array =====================
        str = "String to char array";
        char[] charArray = str.toCharArray();
        System.out.print("String to CharArray: ");
        for (char c : charArray) {
            System.out.print(c + " ");
        }
        System.out.println();
        // Output: String to CharArray: S t r i n g   t o   c h a r   a r r a y 

        // ===================== 19. StringBuilder/StringBuffer to modify String =====================
        str = "Mutable StringBuilder!";
        StringBuilder sb = new StringBuilder(str);
        sb.append(" Let's add more text.");
        System.out.println("After appending: " + sb.toString());
        // Output: After appending: Mutable StringBuilder! Let's add more text.

        sb.insert(8, "modified "); // Insert text at specific index
        System.out.println("After inserting: " + sb.toString());
        // Output: After inserting: Mutable modified StringBuilder! Let's add more text.

        sb.delete(8, 18); // Delete text between indices
        System.out.println("After deleting: " + sb.toString());
        // Output: After deleting: Mutable StringBuilder! Let's add more text.

        sb.reverse(); // Reverse the string
        System.out.println("After reversing: " + sb.toString());
        // Output: After reversing: .txet erom s'teL !rebmuS gnirtuM

        // ===================== 20. String Comparison =====================
        System.out.println("Comparing 'Apple' with 'apple': " + "Apple".compareTo("apple"));
        // Output: Comparing 'Apple' with 'apple': -32

        // ===================== 21. String comparison ignoring case =====================
        System.out.println("Comparing 'Apple' with 'apple' ignoring case: " + "Apple".compareToIgnoreCase("apple"));
        // Output: Comparing 'Apple' with 'apple' ignoring case: 0

        // ===================== 22. String Formatting =====================
        str = "number: 45.6789";
        System.out.println("Formatted String: " + String.format("The number is %.2f", 45.6789));
        // Output: Formatted String: The number is 45.68

        // ===================== 23. String.valueOf() =====================
        int num = 100;
        System.out.println("String.valueOf(int): " + String.valueOf(num));
        // Output: String.valueOf(int): 100

        // ===================== 24. Check if String contains only digits =====================
        str = "123456";
        System.out.println("Is numeric string? " + str.matches("\\d+"));
        // Output: Is numeric string? true

        // ===================== 25. Convert String to Integer =====================
        str = "250";
        int numFromString = Integer.parseInt(str);
        System.out.println("String '250' to Integer: " + numFromString);
        // Output: String '250' to Integer: 250
    }
}
