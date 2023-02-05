import java.util.*;

public class AirplaneSeatSelector {
    /*
        Write a program that helps seat audiences in a flight based on the following input and rules.

        Rules for seating

        • Always seat passengers starting from the front row to back, starting from the left to the right
        • Fill aisle seats first followed by window seats followed by center seats (any order in center seats)

        Input to the program will be

        • a 2D array that represents the rows and columns [ [3,4], [4,5], [2,3], [3,4] ]
        • Number of passengers waiting in queue.
    * */

    static ArrayList<Integer> AisleSeats = new ArrayList<>();
    static ArrayList<Integer> WindowSeats = new ArrayList<>();
    static ArrayList<Integer> MiddleSeats = new ArrayList<>();

    // return array of (passenger, seat) pairs
    public static ArrayList<int[]> Seat(int[][] seatsArray, int passengers) {
        if (passengers < 1 || seatsArray.length < 1) {
            return new ArrayList<>();
        }

        // build seats first
        BuildSeats(seatsArray);

        // assign each passenger a seat

        ArrayList<int[]> seatedPassengers = new ArrayList<>();

        Iterator<Integer> aisleIterator = AisleSeats.iterator();
        Iterator<Integer> windowIterator = WindowSeats.iterator();
        Iterator<Integer> middleIterator = MiddleSeats.iterator();

        for (int passenger = 1; passenger <= passengers; ++passenger) {
            int seat;

            // check aisle seat availability
            if (aisleIterator.hasNext()) {
                seat = aisleIterator.next();
            }
            // check window seat availability
            else if (windowIterator.hasNext()) {
                seat = windowIterator.next();
            }
            // check middle seat availability
            else if (middleIterator.hasNext()) {
                seat = middleIterator.next();
            }
            // no more empty seats on plane, the rest of people will not be seated
            else {
                return seatedPassengers;
            }

            // seat current person at the selected seat
            seatedPassengers.add(new int[]{passenger, seat});
        }

        // all people are seated
        return seatedPassengers;
    }

    // Seats are numbered front to back, left to right, starting from 1
    static void BuildSeats(int[][] seatsArray) {
        // the question provided this array of [columns, rows] of each block in plane: [ [3,2], [4,3], [2,3], [3,4] ]
        // which I translated to an array of columns with corresponding rows: new int[][]{{3, 4, 2, 3}, {2, 3, 3, 4}}

        // test data:
        /*AisleSeats = new ArrayList<>(Arrays.asList(3, 4, 7, 8, 9, 10, 15, 16, 19, 20, 21, 22, 25, 28, 29, 30, 31, 34));
        WindowSeats = new ArrayList<>(Arrays.asList(1, 12, 13, 24, 33, 36));
        MiddleSeats = new ArrayList<>(Arrays.asList(2, 5, 6, 11, 14, 17, 18, 23, 26, 27, 32, 35));*/

        int totalRows = 1;
        int currentRow = 1;
        int currentSeatNumber = 1;
        // iterate through columns
        while (currentRow <= totalRows) {
            // for each block of seats in this row
            for (int blockNumber = 0; blockNumber < seatsArray[0].length; ++blockNumber) {
                // if this block still has rows to add
                if (seatsArray[1][blockNumber] >= currentRow) {
                    // if number of rows is bigger, update totalRows
                    if (seatsArray[1][blockNumber] > totalRows) {
                        totalRows = seatsArray[1][blockNumber];
                    }

                    // add seats in this block
                    for (int blockIterator = 0; blockIterator < seatsArray[0][blockNumber]; ++blockIterator) {
                        if ((blockIterator == 0 && blockNumber == 0) || (blockIterator == seatsArray[0][blockNumber] - 1 && blockNumber == seatsArray[0].length - 1)) {
                            WindowSeats.add(currentSeatNumber++);
                        } else if (blockIterator == 0 || blockIterator == seatsArray[0][blockNumber] - 1) {
                            AisleSeats.add((currentSeatNumber++));
                        } else {
                            MiddleSeats.add(currentSeatNumber++);
                        }
                    }
                }
            }
            currentRow++;
        }
        System.out.println("Aisle seats "+Arrays.toString(AisleSeats.toArray()));
        System.out.println("Window seats "+Arrays.toString(WindowSeats.toArray()));
        System.out.println("Middle seats "+Arrays.toString(MiddleSeats.toArray()));
    }
}
