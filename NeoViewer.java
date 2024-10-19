import java.util.Scanner;

import javax.swing.JTable.PrintMode;

/**
 * This class allows a user to view datasets obtained from the NASA NeoW API.
*/

public class NeoViewer {
    /**
     * The main method runs a menu driven application which creates a NeoDatabase instance and then prompts the user for a menu command selecting the operation. 
     * The required information is then requested from the user based on the selected operation.
     * @param args
     */
    public static void main(String[] args){
        NeoDatabase neoDatabase = new NeoDatabase();
        Scanner scan = new Scanner(System.in);
        System.out.println("  Welcome to NEO Viewer!");
        printMenu();
        System.out.print("  Select a menu option: ");
        String userInput = scan.nextLine().trim().toUpperCase();
        while(!userInput.equals("Q")){
            switch(userInput){
                case "A":
                    System.out.print("\n  Enter the page to load: ");
                    int page = scan.nextInt();
                    scan.nextLine();
                    try{
                        neoDatabase.addAll(neoDatabase.buildQueryURL(page));
                    }catch(IllegalArgumentException e){
                        System.out.println("Error: Invalid page number. Try again.");
                        break;
                    }
                    System.out.println("\n  Page loaded successfully!");
                    break;
                case "S":
                    System.out.println("\n  R) Sort by referenceID");
                    System.out.println("  D) Sort by diameter");
                    System.out.println("  A) Sort by approach date");
                    System.out.println("  M) Sort by miss distance\n");
                    System.out.print("  Select a menu option: ");
                    String input = scan.nextLine().trim().toUpperCase();
                    switch(input){
                        case "R":
                            if(input.equals("R")){
                                try{
                                    neoDatabase.sort(new ReferenceIDComparator());
                                }catch(IllegalArgumentException e){
                                    System.out.println("Comp is null.");
                                    break;
                                }
                                System.out.println("\n  Table sorted on referenceID");
                            }
                            break;
                        case "D":   
                            try{
                                neoDatabase.sort(new DiameterComparator());
                            }catch(IllegalArgumentException e){
                                System.out.println("Comp is null.");
                                break;
                            }
                            System.out.println("\n  Table sorted on diameter.");
                            break;
                        case "A":
                            try{
                                neoDatabase.sort(new ApproachDateComparator());
                            }catch(IllegalArgumentException e){
                                System.out.println("Comp is null.");
                                break;
                            }
                            System.out.println("\n  Table sorted on approach date.");
                            break;
                        case "M":
                            try{
                                neoDatabase.sort(new MissDistanceComparator());
                            }catch(IllegalArgumentException e){
                                System.out.println("Comp is null.");
                                break;
                            }
                            System.out.println("\n  Table sorted on miss distance.");
                            break;
                        default:
                            System.out.println("Invalid input: Please try again.");
                            break;
                    }
                    break;
                case "P":
                    neoDatabase.printTable();
                    break;
                default:
                    System.out.println("Error: Invalid input. Please try again.");
                    break;
            }
            printMenu();
            System.out.print("  Select a menu option: ");
            userInput = scan.nextLine().trim().toUpperCase();
        }
        System.out.println("\n  Program terminating normally...");
    }
    
    /**
     * This prints out the menu
     */
    public static void printMenu(){
        System.out.println();
        System.out.println("  Option Menu:");
        System.out.println("    A) Add a page to the database");
        System.out.println("    S) Sort the database ");
        System.out.println("    P) Print the database as a table.");
        System.out.println("    Q) Quit");
        System.out.println();
    }
}
