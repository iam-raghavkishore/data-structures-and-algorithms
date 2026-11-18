import java.util.Arrays;

public class DSAav {
    static int minimumPlatforms(int[] arrivals, int[] departures) {
        if (arrivals.length != departures.length) {
            throw new IllegalArgumentException(
                "Each train must have an arrival and departure."
            );
        }

        int trainCount = arrivals.length;

        int[] sortedArrivals = arrivals.clone();
        int[] sortedDepartures = departures.clone();

        Arrays.sort(sortedArrivals);
        Arrays.sort(sortedDepartures);

        int arrivalIndex = 0;
        int departureIndex = 0;
        int occupied = 0;
        int maximum = 0;

        while (arrivalIndex < trainCount) {
            if (departureIndex == trainCount
                    || sortedArrivals[arrivalIndex]
                       <= sortedDepartures[departureIndex]) {

                occupied++;
                maximum = Math.max(maximum, occupied);
                arrivalIndex++;
            } else {
                occupied--;
                departureIndex++;
            }
        }

        return maximum;
    }

    public static void main(String[] args) {
        int[] arrivals = {900, 940, 950, 1100, 1500, 1800};
        int[] departures = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(minimumPlatforms(arrivals, departures));
    }
}