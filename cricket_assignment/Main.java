import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("1.) Batting\n2.) Fielding");
            System.out.print("Enter Choice for Batting / Fielding :  ");
            String choiceInput = scanner.nextLine();

            if (choiceInput.matches("[12]")) {
                choice = Integer.parseInt(choiceInput);
                System.out.println((choice == 1) ? "You Choose to Bat first" : "You Choose to Ball first");
            } else {
                System.out.println("Invalid Input, Try Again!");
                choice = -1; // invalid input
            }

        } while(choice == -1);

        int over;
        do {
            System.out.print("Enter the Number of Overs (Must greater than 2 Overs Match) : ");
            String choiceInput;
            choiceInput = scanner.nextLine();
            if (choiceInput.matches("\\d+")) {
                over = Integer.parseInt(choiceInput);
                if (over >= 2) break;
                else System.out.println("Overs must be 2 or more, try again!");
            } else {
                System.out.println("Invalid input, enter only numbers!");
            }
        } while(true);

        System.out.println("The Match is of " + over + " Overs");

        System.out.println("\nMatch Starts");

        int currentOver=0;
        System.out.println("0 - Wicket");
        System.out.println("1 - 1 run");
        System.out.println("2 - 2 run");
        System.out.println("3 - 3 run");
        System.out.println("4 - 4 run");
        System.out.println("5 - 5 run");
        System.out.println("6 - 6 run");
        System.out.println("wd - wide ball (1 run)");
        System.out.println("nb - No ball (Ball Not counted)\n");

        int team_A_Score=0;
        int team_A_Wickets=0;
        while(currentOver != over){
            for(int i=1;i<=6;i++){
                if(team_A_Wickets == 10){
                    break;
                }
                System.out.println("Team A : " + team_A_Score + " / " + team_A_Wickets + "\t" + "Overs: " + currentOver + "." + (i-1));
                String choiceHit = scanner.nextLine();
                choiceHit=choiceHit.toLowerCase();
                switch (choiceHit) {
                    case "0":
                        team_A_Wickets++;
                        break;
                
                    case "1":
                        team_A_Score+=1;
                        break;
                
                    case "2":
                        team_A_Score+=2;
                        break;
                
                    case "3":
                        team_A_Score+=3;
                        break;
                
                    case "4":
                        team_A_Score+=4;
                        break;
                
                    case "5":
                        team_A_Score+=5;
                        break;
                
                    case "6":   
                        team_A_Score+=6;
                        break;
                
                    case "wd":
                        team_A_Score+=1;
                        i--;
                        break;
                
                    case "nb":
                        team_A_Score+=1;
                        i--;
                        break;
                
                    default:
                        System.out.println("Not a valid Input, Try Again !");
                        i--;
                        break;
                }
            }
            if(team_A_Wickets == 10){
                break;
            }
            System.out.println((currentOver + 1) + " Over Completed");
            currentOver++;
        }

        System.out.println("\nAfter First Innings: ");
        System.out.println("Team A Score : " + "\t" + team_A_Score + " / " + team_A_Wickets);
        System.out.println("Target of " + (team_A_Score + 1) + " runs for Team B\n");

        System.out.println("Second Innings Starts ");
        System.out.println("0 - Wicket");
        System.out.println("1 - 1 run");
        System.out.println("2 - 2 run");
        System.out.println("3 - 3 run");
        System.out.println("4 - 4 run");
        System.out.println("5 - 5 run");
        System.out.println("6 - 6 run");
        System.out.println("wd - wide ball (1 run)");
        System.out.println("nb - No ball (Ball Not counted)\n");

        int team_B_Score=0;
        int team_B_Wickets=0;
        currentOver = 0;

        while(currentOver != over){
            for(int i=1;i<=6;i++){
                if(team_B_Score > team_A_Score) {
                    break;
                }
                if(team_B_Wickets == 10){
                    break;
                }
                System.out.println("Team B : " + team_B_Score + " / " + team_B_Wickets + "\t" + "Overs: " + currentOver + "." + (i-1));
                String choiceHit = scanner.nextLine();
                choiceHit=choiceHit.toLowerCase();
                switch (choiceHit) {
                    case "0":
                        team_B_Wickets++;
                        break;
                
                    case "1":
                        team_B_Score+=1;
                        break;
                
                    case "2":
                        team_B_Score+=2;
                        break;
                
                    case "3":
                        team_B_Score+=3;
                        break;
                
                    case "4":
                        team_B_Score+=4;
                        break;
                
                    case "5":
                        team_B_Score+=5;
                        break;
                
                    case "6":   
                        team_B_Score+=6;
                        break;
                
                    case "wd":
                        team_B_Score+=1;
                        i--;
                        break;
                
                    case "nb":
                        team_B_Score+=1;
                        i--;
                        break;
                
                    default:
                        System.out.println("Not a valid Input, Try Again !");
                        i--;
                        break;
                }
            }
            if(team_B_Score > team_A_Score) {
                System.out.println("\nAfter Second Innings: ");
                System.out.println("Team B Score : " + "\t" + team_B_Score + " / " + team_B_Wickets + "\n ");
                System.out.println("Team B Wins by " + (10 - team_B_Wickets) + " " + ((10 - team_B_Wickets > 1) ? "Wickets" : "Wicket"));
                break;
            }
            if(team_B_Wickets == 10){
                break;
            }
            System.out.println((currentOver + 1) + " Over Completed");
            currentOver++;
        }

        if(team_A_Score == team_B_Score){
            System.out.println("Match Tied.");
        }

        if(team_A_Score > team_B_Score){
            System.out.println("Team A wins by " + (team_A_Score - team_B_Score) + " " + ((team_A_Score - team_B_Score > 1) ? "Runs" : "Run"));
        }

        scanner.close();
    }
}
