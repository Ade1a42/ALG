package assignment3;

public class Search {

    public static boolean canShipWithCapacity(int[] weights, int capacity, int maxDays) {
        int daysNeeded = 1;
        int currentLoad = 0;

        for (int i = 0; i < weights.length; i++) {
            if (currentLoad + weights[i] > capacity) {
                daysNeeded++;
                currentLoad = weights[i];
            } else {
                currentLoad += weights[i];
            }
        }
        return daysNeeded <= maxDays;
    }


    public static int findMinimumCapacity(int[] weights, int days) {
        int low = weights[0];
        int high = 0;
        for (int w : weights) {
            if (w > low) low = w;
            high += w;
        }

        while (low < high) {
            int mid = (low + high) / 2;
            if (canShipWithCapacity(weights, mid, days)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}