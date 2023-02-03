public class Class {
    private int seats;
    private int rows;
    private int seatsPerRow;
    private int[][] seating;

    public Class (int rows_, int seatsPerRow_){
        this.rows = rows_;
        this.seats = rows_*seatsPerRow_;
        this.seatsPerRow = seatsPerRow_;
        setArray(rows_, seatsPerRow_);
    }

    public void setArray(int rows_, int seatsPerRow_){
        seating = new int[rows_][seatsPerRow_+1];
        for (int y = 0; y < rows_; y++){
            int pos =- seatsPerRow_/2;
            for (int x = 0; x < seatsPerRow_+1; x++){
                if (pos < 0) {
                    seating[y][x] = pos*(-1);
                } else {
                    seating[y][x] = pos;
                }
                pos++;
            }
        }
    }

    public void addPassenger(int spot, int passengers){
        for (int y = 0; y < rows; y++){
            for (int x = 0; x < seatsPerRow+1; x++){
                if (seating[y][x] == spot){
                    spot = match(y,x,spot,passengers,seatsPerRow);
                }
            }
        }
        if (spot != -1) {
            System.out.println("No more spots available");
        }
    }

    public int match(int y, int x, int spot, int passengers, int seatsPerRow){
        if (passengers == 1) {
            seating[y][x] = 0;
            spot = -1;
            seats = seats - passengers;
            print();
        } else if (passengers == 2){
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
        return spot;
    }

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
