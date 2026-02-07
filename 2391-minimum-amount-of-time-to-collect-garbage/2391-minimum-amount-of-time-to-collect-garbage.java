class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
         int total = 0;

    int lastM = 0, lastG = 0, lastP = 0;

    // Count garbage & track last occurrence
    for (int i = 0; i < garbage.length; i++) {
        String g = garbage[i];
        total += g.length();

        if (g.contains("M")) lastM = i;
        if (g.contains("G")) lastG = i;
        if (g.contains("P")) lastP = i;
    }

    // Prefix sum for travel time
    for (int i = 1; i < travel.length; i++) {
        travel[i] += travel[i - 1];
    }

    // Add travel cost for each truck
    if (lastM > 0) total += travel[lastM - 1];
    if (lastG > 0) total += travel[lastG - 1];
    if (lastP > 0) total += travel[lastP - 1];

    return total;
    }
}