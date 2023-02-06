public class Class {
    // Creating vaariables for the class instances to store information
    private int seats; // Displays how many seats are left in each class instance
    private int rows; // Rows times seatsPerRow equals seats available
    private int seatsPerRow;
    private int[][] seating; // Array for printing

    public Class (int rows_, int seatsPerRow_){
        // Filling in all the information for each class instance created depending on the new conditions provided
        this.rows = rows_;
        this.seats = rows_*seatsPerRow_;
        this.seatsPerRow = seatsPerRow_;
        setArray(rows_, seatsPerRow_);
    }
    
    //Precondition : The array is empty and we dont know which seats are windows or aisles
    //Postcondition : Initializes array and numbers the seating positions for algorythm later
    public void setArray(int rows_, int seatsPerRow_){ // Uses rows and seatsperrow for numbering and loop conditions
        seating = new int[rows_][seatsPerRow_+1];
        for (int y = 0; y < rows_; y++){
            int pos =- seatsPerRow_/2; // Finding the right number to start with for numbering the seating positions
            for (int x = 0; x < seatsPerRow_+1; x++){
                if (pos < 0) {
                    seating[y][x] = pos*(-1); // Multiplies negative numbers by negative one to keep all numbers positive
                } else {
                    seating[y][x] = pos;
                }
                pos++;
            }
        }
    }
    
    //Precondition : Need to add the passengers to the array
    //Postcondition : Adds passengers to the array if an open spot with the right conditions is found
    public void addPassenger(int spot, int passengers){
        for (int y = 0; y < rows; y++){
            for (int x = 0; x < seatsPerRow+1; x++){
                if (seating[y][x] == spot){
                    spot = match(y,x,spot,passengers,seatsPerRow); // Function for finding an open spot the meets the conditions
                }
            }
        }
        if (spot != -1) {
            System.out.println("No more spots available"); // -1 is the default condition for if a spot is found
            // If a spot is found then it changes the value to -1 so that other values arent changed as the loop keeps going
            // So if spot does not equal -1 then that means an open spot was never found
        }
    }
    
    //Precondition : Dont know if there is an open spot that meets the conditions
    //Postcondition : Searches for an open spot that meets the conditions
    public int match(int y, int x, int spot, int passengers, int seatsPerRow){
        if (passengers == 1) {
            seating[y][x] = 0; // Sets the open spot equal to zero to signal that the spot is no longer available
            spot = -1; // Sets to negative one so that other elements in the array arent changed as the loop continues
            seats = seats - passengers; // subtracts from the seating count for seats available
            print(); // Prints the current seating the class instance and the number of available seats left
        } else if (passengers == 2){
            // Checking to make sure more than one seat is open by the preferred seating option before changing values
            if (((x-1) >= 0)&&(seating[y][x-1] != 0)) {
                seating[y][x] = 0;
                seating[y][x-1] = 0;
                spot = -1;
                seats = seats - passengers;
                print();
            } else if (((x+1) <= seatsPerRow)&&(seating[y][x+1] != 0)){
                seating[y][x] = 0;
                seating[y][x+1] = 0;
                spot = -1;
                seats = seats - passengers;
                print();
            }
        } else if (passengers == 3) {
            // Checking to makwe sure more than one seat is open to fit the amount of passengers before changing values
            if (((x-2) >= 0)&&(seating[y][x-2] != 0)&&(seating[y][x-1] != 0)){
                seating[y][x] = 0;
                seating[y][x-1] = 0;
                seating[y][x-2] = 0;
                spot = -1;
                seats = seats - passengers;
                print();
            } else if (((x+2) <= seatsPerRow)&&(seating[y][x+2] != 0)&&(seating[y][x+1] != 0)) {
                seating[y][x] = 0;
                seating[y][x+1] = 0;
                seating[y][x+2] = 0;
                spot = -1;
                seats = seats - passengers;
                print();
            } else if (((x-1) >= 0)&&((x+1) <= seatsPerRow)&&(seating[y][x-1] != 0)&&(seating[y][x+1] != 0)) {
                seating[y][x] = 0;
                seating[y][x-1] = 0;
                seating[y][x+1] = 0;
                spot = -1;
                seats = seats - passengers;
                print();
            }
        } 
        return spot; // Returns spot for the loop so things arent changed if a spot is found
    }
    
    //Precondition : Cant see the current seating of the class instances
    //Postcondition : Prints the seating of the specific class and also prints the number of seats still available
    public void print(){
        for (int y = 0; y < rows; y++){
            for (int x = 0; x < seatsPerRow+1; x++){
                System.out.print(seating[y][x]);
            }
            System.out.println();
        }
        System.out.println(seats + " more seats available.");
    }
}
