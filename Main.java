/**
 * @filename - CustomString.java
 * @description - This is the main function and will use the String Function 
 * @author - Kalp Mundra
 */

// for user input 
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Input the initial string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Step 2: Create Mystring object
        MyString obj = new MyString(inputString);

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
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter string to append: ");
                    String toAppend = scanner.nextLine();
                    System.out.println("Updated string: " + obj.append(toAppend));
                    break;

                case 2:
                    System.out.println("Word Count: " + obj.getWordsCount());
                    break;

                case 3:
                    System.out.print("Enter character to replace: ");
                    char oldChar = scanner.next().charAt(0);
                    System.out.print("Enter new character: ");
                    char newChar = scanner.next().charAt(0);
                    System.out.println("Updated string: " + obj.replaceCharacters(oldChar, newChar));
                    break;

                case 4:
                    if (obj.getWordsCount() <= 1) {
                        if (obj.isPalindromeByCharacter())
                            System.out.println("The string is a palindrome.");
                        else
                            System.out.println("The string is NOT a palindrome.");
                        break;
                    } else {
                        System.out.println("CHECK PALINDROME BY CHARACTERS: ENTER 1");
                        System.out.println("CHECK PALINDROME BY WORDS: ENTER 2");
                        System.out.print("Enter your choice: ");
                        int select = scanner.nextInt();

                        if (select == 1) {
                            if (obj.isPalindromeByCharacter())
                                System.out.println("The string is a palindrome.");
                            else
                                System.out.println("The string is NOT a palindrome.");
                            break;
                        } else if (select == 2) {
                            if (obj.isPalindromeByWords()) {
                                System.out.println("The string is a palindrome.");
                            } else {
                                System.out.println("The string is NOT a palindrome.");
                            }
                        } else {
                            System.out.println("Not a valid choice");
                        }
                        break;
                    }

                case 5:
                    String[] parts = obj.splitStringIntoArray();
                    System.out.println("Words:");
                    for (String word : parts) {
                        System.out.println(word);
                    }
                    break;

                case 6:
                    System.out.print("Enter start index: ");
                    int start = scanner.nextInt();
                    System.out.print("Enter length to remove: ");
                    int length = scanner.nextInt();
                    System.out.println("Updated string: " + obj.splice(start, length));
                    break;

                case 7:
                    System.out.println("Max Repeated Character: " + obj.getMaxRepeatCharacter());
                    break;

                case 8:
                    System.out.print("Enter number of positions to shift: ");
                    int shift = scanner.nextInt();
                    System.out.println("Updated string: " + obj.shiftElements(shift));
                    break;

                case 9:
                    System.out.println("Sorted string: " + obj.sortString());
                    break;

                case 10:
                    System.out.println("Reversed string: " + obj.reverseString());
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}