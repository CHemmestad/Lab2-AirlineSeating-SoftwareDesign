import java.util.Scanner;
import java.io.IOException;

public class AirlineSeatingTester {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Boolean cont = true;
        Boolean quit = false;
        do {
            cont = true;
            System.out.println("Pick an option (Add, Show, Quit) : ");
            String option = input.next();
            switch(option){
                case "Add" :
                while (cont) {
                    Airplane.addPassenger();
                    cont = Airplane.quit();
                }
                break;
                case "Show" :
                Airplane.printSeating();
                break;
                case "Quit" :
                quit = true;
                break;
                default :
                System.out.println("Invalid");
            }
        } while (!quit);
        input.close();
    }
}