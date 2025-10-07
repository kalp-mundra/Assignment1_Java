// for user input
import java.util.Scanner;

class Mystring {
    private String str;  // Stores the actual string value

    // Constructor to initialize string
    Mystring(String str) {
        this.str = (str == null) ? "" : str;
    }

    // Appends another string 'a' to the current string and returns new result
    String append(String a) {
        return str + a;
    }

    // Counts total number of words in the string
    int countWords() {
        // Handle empty or null strings safely
        if (str == null || str.trim().isEmpty())
            return 0;
        int words = 0;
        char last = str.charAt(0);  // Track last character to handle consecutive spaces
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {        // Space found
                if (last != ' ')               // Count new word only after a non-space
                    words++;
            }
            last = str.charAt(i);
        }
        // Add one more if the last character was not a space
        return last == ' ' ? words : words + 1;
    }

    // Replaces all occurrences of character 'a' with 'b'
    String replace(char a, char b) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a)
                res += b;
            else
                res += str.charAt(i);
        }
        return res;

    }

    // Checks whether the string is a palindrome or not
    boolean isPalindrome() {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r))
                return false;  // Mismatch found
            l++;
            r--;
        }
        return true;
    }

    boolean isPalin(){
        String[] arr = split();
        int l = 0, r = arr.length - 1;

        while (l < r) {
            if (!arr[l].equals(arr[r])) {  // compare words properly
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    // Splits the string into words (based on spaces) and returns an array of words
    String[] split() {

        // Handle empty or null strings safely
        if (str == null || str.isEmpty()) {
            return new String[0];  // returns an empty array instead of crashing
        }

        String[] word = new String[countWords()];
        int idx = 0, l = 0;
        char last = str.charAt(0);

        // Skip initial spaces
        while (l<str.length() && str.charAt(l) == ' ')
            l++;

        int start = l;
        while (l < str.length()) {
            // New word start after a space
            if (l != 0 && str.charAt(l - 1) == ' ' && str.charAt(l) != ' ') {
                start = l;
            }
            // Word ends when space found
            else if (str.charAt(l) == ' ') {
                if (last != ' ') {
                    word[idx++] = str.substring(start, l);
                }
            }
            last = str.charAt(l);
            l++;
        }
        // Add last word if string doesn't end with a space
        if (last != ' ') {
            word[idx] = str.substring(start, l);
        }
        return word;
    }

    // Removes 'len' characters starting from index 'start' and returns new string
    String splice(int start, int len) {
        // prevents runtime errors on bad input
        if (start < 0 || start + len > str.length()) return str;

        String res = str.substring(0, start) + str.substring(start + len);
        return res;
    }

    // Finds and returns the character that appears most frequently in the string
    char maxRepeat() {
        int[] freq = new int[256];  // Frequency table for ASCII characters
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        int maxi = 0;
        char res = '0';  // Placeholder for result
        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] > maxi) {
                maxi = freq[str.charAt(i)];
                res = str.charAt(i);
            }
        }
        return res;  // If tie, returns the first character with max frequency
    }

    // Performs circular left shift by 'n' positions
    String shift(int n) {
        String res = str.substring(n) + str.substring(0, n);
        return res;
    }

    // Sorts all characters of the string in ascending order (bubble sort)
    String sort() {

        // Handle empty or null strings safely
        if (str == null || str.trim().isEmpty())
            return str;
        
        char[] arr = str.toCharArray();

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return new String(arr);
    }

    // Reverses the string and returns it
    String reverse() {

        // Handle empty or null strings safely
        if (str == null || str.trim().isEmpty())
            return str;
        
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }
}


public class Myprog{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        // Step 1: Input the initial string
        System.out.print("Enter a string: ");
        String str = s.nextLine();

        // Step 2: Create Mystring object
        Mystring obj = new Mystring(str);

        int choice;
        do {
            System.out.println("\n===== STRING OPERATIONS MENU =====");
            System.out.println("1. Append");
            System.out.println("2. Count Words");
            System.out.println("3. Replace Character");
            System.out.println("4. Check Palindrome");
            System.out.println("5. Split into Words");
            System.out.println("6. Splice (Remove substring)");
            System.out.println("7. Max Repeated Character");
            System.out.println("8. Shift Left");
            System.out.println("9. Sort Characters");
            System.out.println("10. Reverse String");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = s.nextInt();
            s.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter string to append: ");
                    String toAppend = s.nextLine();
                    System.out.println("Updated string: " + obj.append(toAppend));
                    break;

                case 2:
                    System.out.println("Word Count: " + obj.countWords());
                    break;

                case 3:
                    System.out.print("Enter character to replace: ");
                    char oldChar = s.next().charAt(0);
                    System.out.print("Enter new character: ");
                    char newChar = s.next().charAt(0);
                    System.out.println("Updated string: " + obj.replace(oldChar, newChar));
                    break;

                case 4:
                    if(obj.countWords()<=1){
                        if (obj.isPalindrome())
                            System.out.println("The string is a palindrome.");
                        else
                            System.out.println("The string is NOT a palindrome.");
                        break;
                    }
                    else{
                        System.out.println("CHECK PALINDROME BY CHARACTERS: ENTER 1");
                        System.out.println("CHECK PALINDROME BY WORDS: ENTER 2");
                        System.out.print("Enter your choice: ");
                        int n=s.nextInt();

                        if(n==1){
                            if(obj.isPalindrome())
                                System.out.println("The string is a palindrome.");
                            else
                                System.out.println("The string is NOT a palindrome.");
                            break;
                        }
                        else if(n==2){
                            if(obj.isPalin()){
                                System.out.println("The string is a palindrome.");
                            }
                            else{
                                System.out.println("The string is NOT a palindrome.");
                            }
                        }
                        else{
                            System.out.println("Not a valid choice");
                        }
                        break;
                    }

                case 5:
                    String[] parts = obj.split();
                    System.out.println("Words:");
                    for (String word : parts) {
                        System.out.println(word);
                    }
                    break;

                case 6:
                    System.out.print("Enter start index: ");
                    int start = s.nextInt();
                    System.out.print("Enter length to remove: ");
                    int len = s.nextInt();
                    System.out.println("Updated string: " + obj.splice(start, len));
                    break;

                case 7:
                    System.out.println("Max Repeated Character: " + obj.maxRepeat());
                    break;

                case 8:
                    System.out.print("Enter number of positions to shift: ");
                    int n = s.nextInt();
                    System.out.println("Updated string: " + obj.shift(n));
                    break;

                case 9:
                    System.out.println("Sorted string: " + obj.sort());
                    break;

                case 10:
                    System.out.println("Reversed string: " + obj.reverse());
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 0);

        s.close();
    }
}