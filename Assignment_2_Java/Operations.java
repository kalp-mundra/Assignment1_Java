
/**
 * @filename- Operations.java
 * @description- Provides basic operations on strings and numbers
 * @author- Kalp Mundra
 */

import java.util.ArrayList;
import java.util.HashSet;

public class Operations {

    // Check if a string is a palindrome
    boolean checkPalindrome(String value) {
        int leftPointer = 0, rightPointer = value.length() - 1;
        while (leftPointer < rightPointer) {
            if (value.charAt(leftPointer) != value.charAt(rightPointer)) {
                return false;
            }
            leftPointer++;
            rightPointer--;
        }
        return true;
    }

    // Count all unique palindromic substrings in the input
    int countUniquePalindrome(String input) {
        int countUniquePalindrome = 0;
        ArrayList<String> uniquePalindrome = new ArrayList<>();
        for (int i = 0; i < input.length() - 1; i++) {
            for (int j = i + 1; j < input.length(); j++) {
                String sub = input.substring(i, j + 1);
                if (checkPalindrome(sub) && !uniquePalindrome.contains(sub)) {
                    uniquePalindrome.add(sub);
                    countUniquePalindrome++;
                }
            }
        }
        return countUniquePalindrome;
    }

    // Recursive method to find Nth Fibonacci number
    int nthFinonacciNumber(int value) {
        if (value == 0 || value == 1) {
            return value;
        }
        return nthFinonacciNumber(value - 1) + nthFinonacciNumber(value - 2);
    }

    // Convert snake_case string to camelCase
    String conversionToCamelCase(String input) {
        String result = "";
        boolean toUpperCase = false;

        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);
            if (currentCharacter == '_') {
                toUpperCase = true; // Next character should be uppercase
            } else {
                result += toUpperCase ? Character.toUpperCase(currentCharacter) : currentCharacter;
                toUpperCase = false;
            }
        }
        return result;
    }

    // Count the number of consonants in a string
    int countConsonants(String input) {
        int countOfConsonants = 0;
        input = input.toLowerCase(); // make it case-insensitive

        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);
            // Only letters that are not vowels
            if (Character.isLetter(currentCharacter) && "aeiou".indexOf(currentCharacter) == -1) {
                countOfConsonants++;
            }
        }
        return countOfConsonants;
    }

    // Convert binary string to decimal value
    int binaryToDecimal(String binaryValue) {
        int decimalValue = 0;

        for (int i = 0; i < binaryValue.length(); i++) {
            char currentBit = binaryValue.charAt(i);

            // Validate input
            if (currentBit != '0' && currentBit != '1') {
                System.out.println("Invalid Binary input");
                return -1;
            }

            // Shift left (multiply by 2) and add current bit
            decimalValue = decimalValue * 2 + (currentBit - '0');
        }

        return decimalValue;
    }

    // Expand string where character is followed by a digit
    String expandString(String input) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);

            if (i + 1 < input.length() && Character.isDigit(input.charAt(i + 1))) {
                int characterCount = input.charAt(i + 1) - '0';

                for (int j = 0; j < characterCount; j++) {
                    result += currentCharacter;
                }

                i++; // Skip the digit after processing
            }
        }

        return result;
    }

    // Compress string by counting consecutive character frequency
    String compressString(String input) {
        String result = "";
        int countCharacter = 1;

        for (int i = 0; i < input.length(); i++) {
            if (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                countCharacter++;
            } else {
                result += input.charAt(i) + String.valueOf(countCharacter);
                countCharacter = 1; // Reset count
            }
        }

        return result;
    }

    // Check if a number is prime
    boolean isPrime(int num) {
        if (num <= 1) {
            return false; // 0 and 1 are not prime
        }

        // Check divisibility up to sqrt(num)
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false; // divisible → not prime
            }
        }

        return true; // no divisors found → prime
    }

    // Convert number to its English word representation (0–9999)
    String numberToWord(int number) {
        String[] units = {
                "", "One", "Two", "Three", "Four", "Five",
                "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };

        String[] tens = {
                "", "", "Twenty", "Thirty", "Forty", "Fifty",
                "Sixty", "Seventy", "Eighty", "Ninety"
        };

        if (number == 0)
            return "Zero";

        if (number < 20)
            return units[number];
        else if (number < 100)
            return tens[number / 10] + ((number % 10 != 0) ? " " + units[number % 10] : "");
        else if (number < 1000)
            return units[number / 100] + " Hundred" + ((number % 100 != 0) ? " " + numberToWord(number % 100) : "");
        else if (number < 10000)
            return units[number / 1000] + " Thousand" + ((number % 1000 != 0) ? " " + numberToWord(number % 1000) : "");
        else
            return "Number out of range (0–9999)";
    }

    // Find length of longest substring without repeating characters
    int lengthOfLongestSubstring(String input) {
        int maximumLength = 0;
        int leftPointer = 0; // start of window
        HashSet<Character> characterSet = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);

            // Remove duplicates from current window
            while (characterSet.contains(currentCharacter)) {
                characterSet.remove(input.charAt(leftPointer));
                leftPointer++;
            }

            characterSet.add(currentCharacter);
            maximumLength = Math.max(maximumLength, i - leftPointer + 1);
        }

        return maximumLength;
    }
}

