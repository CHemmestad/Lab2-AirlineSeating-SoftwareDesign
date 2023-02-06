import java.util.Scanner;
import java.io.IOException;

public class AirlineSeatingTester {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Boolean cont = true;
        Boolean quit = false;
        
        // Loops the program until the user decides to quit
        do {
            cont = true;
            System.out.println("Pick an option (Add, Show, Quit) : "); // Gives you the options to choose from
            String option = input.next();
            switch(option){
                case "Add" : // Adds a passenger to the airplane
                while (cont) {
                    Airplane.addPassenger(); // Algorythm for adding a passenger
                    cont = Airplane.quit(); // Returns bool for exiting the loop for adding passengers
                }
                break;
                case "Show" : // Shows the current seating of the airplane
                Airplane.printSeating();
                break;
                case "Quit" : // Quits the program
                quit = true;
                break;
                default :
                System.out.println("Invalid");
            }
        } while (!quit);
        input.close();
    }
}
