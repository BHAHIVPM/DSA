class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        TreeMap<Integer, Integer> changes = new TreeMap<>();

        for (int[] trip : trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            changes.put(from, changes.getOrDefault(from, 0) + passengers);
            changes.put(to, changes.getOrDefault(to, 0) - passengers);
        }

        int total = 0;

        for (int change : changes.values()) {
            total += change;

            if (total > capacity) {
                return false;
            }
        }

        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna