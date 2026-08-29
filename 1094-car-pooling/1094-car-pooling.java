class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        int[] events = new int[1001];

        for (int[] trip : trips) {
            events[trip[1]] += trip[0];
            events[trip[2]] -= trip[0];
        }

        int passengers = 0;

        for (int event : events) {
            passengers += event;

            if (passengers > capacity) {
                return false;
            }
        }

        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna