import java.util.Arrays;

public class AirplaneSeatSelectorTest {
    public static void main(String[] args) {
        var seatedPassengers = AirplaneSeatSelector.Seat(new int[][]{{3, 4, 2, 3}, {2, 3, 3, 4}}, 30);
        System.out.println("Person Number, Seat Number:");
        for (int[] seatPassengerPair : seatedPassengers) {
            System.out.println(Arrays.toString(seatPassengerPair));
        }
    }
}