
/**
 * @filename- Main.java
 * @description- Takes user input and calls the respective string/number operation functions from Operations class
 * @author- Kalp Mundra
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Operations object = new Operations(); // Object to access all operation methods
        int choice;

        do {
            // Display menu options
            System.out.println("\n===== STRING OPERATIONS MENU =====");
            System.out.println("1. Count Unique Palindrome");
            System.out.println("2. Fibonacci Sequence - Nth Number");
            System.out.println("3. Snake Case to Camel Case Conversion");
            System.out.println("4. Count Consonants in a String ");
            System.out.println("5. Binary to Decimal Conversion ");
            System.out.println("6. Expand Characters in a String");
            System.out.println("7. Compress String");
            System.out.println("8. Prime Number Checker");
            System.out.println("9. Number to Words Converter");
            System.out.println("10. Longest Substring Without Repeating Characters");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left by nextInt()

            switch (choice) {
                case 1:
                    // Count all unique palindromic substrings
                    System.out.print("Enter a String: ");
                    String input = scanner.nextLine();
                    System.out.println("Number of Unique Palindromes : " + object.countUniquePalindrome(input));
                    break;

                case 2:
                    // Compute Nth Fibonacci number
                    System.out.print("Enter a number: ");
                    int value = scanner.nextInt();
                    System.out.println("The Nth Fibonacci Number is : " + object.nthFinonacciNumber(value));
                    break;

                case 3:
                    // Convert snake_case to camelCase
                    System.out.print("Enter a String in Snake case: ");
                    String inputSnakeCase = scanner.nextLine();
                    System.out
                            .println("Updated string to camel case : " + object.conversionToCamelCase(inputSnakeCase));
                    break;

                case 4:
                    // Count consonants in the input string
                    System.out.print("Enter a String: ");
                    String string = scanner.nextLine();
                    System.out.println("Number of consonants in the given string : " + object.countConsonants(string));
                    break;

                case 5:
                    // Convert binary string to decimal number
                    System.out.println("Enter a number in String form:");
                    String number = scanner.nextLine();
                    System.out
                            .println("Decimal value corresponding to given number : " + object.binaryToDecimal(number));
                    break;

                case 6:
                    // Expand characters based on following digit in string
                    System.out.println("Enter a string to expand: ");
                    String value2 = scanner.nextLine();
                    System.out.println("Updated string: " + object.expandString(value2));
                    break;

                case 7:
                    // Compress string using character frequency
                    System.out.println("Enter a string to compress: ");
                    String value3 = scanner.nextLine();
                    System.out.println("Updated string: " + object.compressString(value3));
                    break;

                case 8:
                    // Check if the number is prime
                    System.out.print("Enter a number: ");
                    int number2 = scanner.nextInt();
                    if (object.isPrime(number2)) {
                        System.out.println("Prime Number");
                    } else {
                        System.out.println("Not a Prime Number");
                    }
                    break;

                case 9:
                    // Convert number to words
                    System.out.print("Enter a number: ");
                    int number3 = scanner.nextInt();
                    System.out.println(
                            "The word representation of the given number is : " + object.numberToWord(number3));
                    break;

                case 10:
                    // Find length of longest substring without repeating characters
                    System.out.println("Enter a string : ");
                    String value4 = scanner.nextLine();
                    System.out.println("Length of longest substring : " + object.lengthOfLongestSubstring(value4));
                    break;

                case 0:
                    System.out.println("Exiting the program. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 0);

        scanner.close(); // Close the scanner to free resources
    }
}
