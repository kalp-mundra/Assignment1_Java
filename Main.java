import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        myArray array = new myArray();
        String inputChoice;
        int choice;

        do {
            System.out.println("\n1.) The Efficient Traveler");
            System.out.println("2.) The Sum that Stands Out");
            System.out.println("3.) Flip the Switch");
            System.out.println("4.) The Odd One Out");
            System.out.println("5.) Smart Pair Finder");
            System.out.println("6.) The Minimalist Painter");
            System.out.println("7.) The Geometry Hierarchy");
            System.out.println("0.) Exit");
            System.out.print("Enter your choice: ");

            inputChoice = scanner.nextLine();

            // Safe numeric check
            if (inputChoice.matches("\\d+")) {
                choice = Integer.parseInt(inputChoice);
            } else {
                choice = -1; // invalid input
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter the size of the array: ");
                    int size = scanner.nextInt();
                    scanner.nextLine();

                    if (size == 0) {
                        System.out.println("Not Valid !");
                        break;
                    }

                    int[] inputArray = new int[size];

                    System.out.println("Enter " + size + " elements:");
                    for (int i = 0; i < size; i++) {
                        inputArray[i] = scanner.nextInt();
                    }
                    scanner.nextLine();

                    array.setArray(inputArray);

                    System.out.print("Enter the value of Initial Energy: ");
                    int initialEnergy = scanner.nextInt();
                    if (initialEnergy <= 0) {
                        System.out.println("Not a valid Initial Energy");
                        break;
                    }
                    scanner.nextLine();
                    System.out.println("The Farthest Positions using the Initial Energy : "
                            + array.getFarthestCity(initialEnergy));
                    break;

                case 2:
                    System.out.print("Enter the size of the array: ");
                    size = scanner.nextInt();
                    scanner.nextLine();

                    if (size == 0) {
                        System.out.println("Not Valid !");
                        break;
                    }

                    int[] inputArray2 = new int[size];

                    System.out.println("Enter " + size + " elements:");
                    for (int i = 0; i < size; i++) {
                        inputArray2[i] = scanner.nextInt();
                    }
                    scanner.nextLine();

                    array.setArray(inputArray2);
                    System.out.println("At index : " + array.findEqualSumIndex());
                    break;

                case 3:
                    System.out.print("Enter the size of the array: ");
                    size = scanner.nextInt();
                    scanner.nextLine();

                    if (size == 0) {
                        System.out.println("Not Valid !");
                        break;
                    }

                    int[] inputArray3 = new int[size];

                    System.out.println("Enter " + size + " elements:");
                    for (int i = 0; i < size; i++) {
                        inputArray3[i] = scanner.nextInt();
                    }
                    scanner.nextLine();

                    array.setArray(inputArray3);
                    System.out.println("It requires " + array.minimumFlipsToEqualize() + " flip to become same");
                    break;

                case 4:
                    System.out.print("Enter the size of the array: ");
                    size = scanner.nextInt();
                    scanner.nextLine();

                    if (size == 0 || size % 2 != 1) {
                        System.out.println("Not Valid !");
                        break;
                    }

                    int[] inputArray4 = new int[size];

                    System.out.println("Enter " + size + " elements:");
                    for (int i = 0; i < size; i++) {
                        inputArray4[i] = scanner.nextInt();
                    }
                    scanner.nextLine();

                    array.setArray(inputArray4);
                    System.out.println("The single element in the array is : " + array.getSingleElement());
                    break;

                case 5:
                    System.out.print("Enter the size of the array: ");
                    size = scanner.nextInt();
                    scanner.nextLine();

                    if (size == 0) {
                        System.out.println("Not Valid !");
                        break;
                    }

                    int[] inputArray5 = new int[size];

                    System.out.println("Enter " + size + " elements:");
                    for (int i = 0; i < size; i++) {
                        inputArray5[i] = scanner.nextInt();
                    }
                    scanner.nextLine();

                    array.setArray(inputArray5);
                    System.out.print("Enter the target sum value: ");
                    int targetPair = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Result: " + array.checkPairSum(targetPair));
                    break;

                case 6:
                    System.out.print("Enter the size of the array: ");
                    size = scanner.nextInt();
                    scanner.nextLine();

                    if (size == 0) {
                        System.out.println("Not Valid !");
                        break;
                    }

                    int[] inputArray6 = new int[size];

                    System.out.println("Enter " + size + " elements:");
                    for (int i = 0; i < size; i++) {
                        inputArray6[i] = scanner.nextInt();
                    }
                    scanner.nextLine();

                    array.setArray(inputArray6);
                    System.out.println("Minimum Painting time: " + array.findMinimumPaintingTime());
                    break;

                case 7:
                    System.out.println("Enter the Initial and Final Points: ");
                    int[] inputArray7 = new int[4];
                    for (int i = 0; i < 4; i++) {
                        inputArray7[i] = scanner.nextInt();
                    }
                    scanner.nextLine();

                    Point point1 = new Point(inputArray7[0], inputArray7[1]);

                    Point point2 = new Point(inputArray7[2], inputArray7[3]);

                    System.out.println("Enter the radius of the circle: ");
                    int radius = scanner.nextInt();
                    scanner.nextLine();
                    Circle shape1 = new Circle(radius);

                    System.out.println("Enter the side of the square: ");
                    int side = scanner.nextInt();
                    scanner.nextLine();
                    Square shape2 = new Square(side);

                    System.out.println("Enter the points to shift : ");
                    int dx = scanner.nextInt();
                    int dy = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("\nDistance : " + point1.getDistance(point2));
                    System.out.println("Circle Area : " + shape1.get_area());
                    System.out.println("Sqaure Area : " + shape2.get_area());
                    System.out.print("Translated Point1 : " + point1.translate(dx, dy));

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
