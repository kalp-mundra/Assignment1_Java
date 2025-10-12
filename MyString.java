import java.util.ArrayList;

/**
 * @filename - Mystring.java
 * @description - This will perform most of the string operation
 * @author - Kalp Mundra
 */

public class MyString {

    private String value;

    @Override
    public String toString() {
        return this.value;
    }

    MyString(String value) {
        this.value = value == null ? "" : value;
    }

    // Appends another string to the current string and returns new result
    String append(String toAppend) {
        value += toAppend;
        return value;
    }

    // Counts total number of words in the string
    int getWordsCount() {
        // Handle empty or null strings safely
        if (value == null || value.trim().isEmpty())
            return 0;
        char lastCharacter=value.charAt(0);
        int words=0;
        for(int i=0;i<value.length();i++){
            char currentCharacter = value.charAt(i);
            if(Character.isLetterOrDigit(currentCharacter)){
                if(!Character.isLetterOrDigit(lastCharacter)){
                    words++;
                }
            }
            lastCharacter=value.charAt(i);
        }
        // Add one more if the last character was not a space
        return Character.isLetterOrDigit(lastCharacter) ? words + 1 : words;
    }

    // Replaces all occurrences of a character with another
    String replaceCharacters(char replace, char replaceWith) {
        String result = "";
        for (int i = 0; i < value.length(); i++) {
            result += value.charAt(i) == replace ? replaceWith : value.charAt(i);
        }
        return value = result;
    }

    // Checks whether the string is a palindrome or not by each character
    boolean isPalindromeByCharacter() {
        int leftPointer = 0, rightPointer = value.length() - 1;
        while (leftPointer < rightPointer) {
            if (value.charAt(leftPointer) != value.charAt(rightPointer))
                return false; // Mismatch found
            leftPointer++;
            rightPointer--;
        }
        return true;
    }

    // Checks whether the string is a palindrome or not by each word
    boolean isPalindromeByWords() {
        String[] arr = splitStringIntoArray();
        int leftPointer = 0, rightPointer = arr.length - 1;

        while (leftPointer < rightPointer) {
            if (!arr[leftPointer].equals(arr[rightPointer])) { // compare words properly
                return false;
            }
            leftPointer++;
            rightPointer--;
        }
        return true;
    }

    // Splits the string into words (based on spaces) and returns an array of words
    String[] splitStringIntoArray() {
        // Handle empty or null strings safely
        if (value == null || value.isEmpty()) {
            return new String[0];
        }

        // Use a dynamic list to handle words flexibly
        ArrayList<String> wordsList = new ArrayList<>();

        int start = -1; // to mark start of a word

        for (int i = 0; i < value.length(); i++) {
            char currentCharacter = value.charAt(i);

            if (Character.isLetterOrDigit(currentCharacter)) {
                // Start of a new word
                if (start == -1) {
                    start = i;
                }
            } else {
                // Non-alphanumeric found → word boundary
                if (start != -1) {
                    wordsList.add(value.substring(start, i));
                    start = -1;
                }
            }
        }

        // Add the last word if the string ends with an alphanumeric character
        if (start != -1) {
            wordsList.add(value.substring(start));
        }

        // Convert ArrayList to array
        return wordsList.toArray(new String[0]);
}

    // Removes a particular 'length' characters starting from index 'start' and returns new string
    String splice(int start, int length) {
        // prevents runtime errors on bad input
        if (value == null || start < 0 || start >= value.length() || length < 0 || start + length > value.length())
            return value;

        String result = value.substring(0, start) + value.substring(start + length);
        value = result;
        return value;
    }

    // Finds and returns the character that appears most frequently in the string
    int getMaxRepeatCharacter() {
        int[] frequency = new int[256]; // Frequency table for ASCII characters
        for (int i = 0; i < value.length(); i++) {
            frequency[value.charAt(i)]++;
        }

        int maximumFrequency = 0;
        char result = '0'; // Placeholder for result
        for (int i = 0; i < value.length(); i++) {
            if (frequency[value.charAt(i)] > maximumFrequency) {
                maximumFrequency = frequency[value.charAt(i)];
                result = value.charAt(i);
            }
        }
        System.out.println("Maximum repeated Character: " + result);
        return maximumFrequency; // If tie, returns the first character with max frequency
    }

    // Performs circular left shift by 'n' positions
    String shiftElements(int shift) {
        shift = shift % value.length();
        String result = value.substring(shift) + value.substring(0, shift);
        value = result;
        return value;
    }

    // Sorts all characters of the string in ascending order (bubble sort)
    String sortString() {

        // Handle empty or null strings safely
        if (value == null || value.trim().isEmpty())
            return value;

        char[] arr = value.toCharArray();

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        value = new String(arr);
        return value;
    }

    // Reverses the string and returns it
    String reverseString() {

        // Handle empty or null strings safely
        if (value == null || value.trim().isEmpty())
            return value;

        String reversed = "";
        for (int i = value.length() - 1; i >= 0; i--) {
            reversed += value.charAt(i);
        }
        value = reversed;
        return value;
    }
}