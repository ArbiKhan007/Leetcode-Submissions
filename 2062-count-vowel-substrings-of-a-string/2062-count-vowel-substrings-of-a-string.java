class Solution {
    public static int countVowelSubstrings(String str) {
        // Map to keep track of the count of each vowel in the current window
        Map<Character, Integer> freq = new HashMap<>();
        int n = str.length();
        int ans = 0; // Result: total number of valid substrings
        int j = 0;   // Left pointer of the sliding window
        int vowelCount = 0; // Counts how many different vowels are in the current window
        int pref = 0; // Tracks how far we've moved the start of the window to avoid duplicates
    
        // Loop through each character in the string
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
    
            // Check if the current character is a vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                // Add or update the count of the vowel in the current window
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
    
                // If this is the first occurrence of this vowel in the window
                if (freq.get(ch) == 1) {
                    vowelCount++; // Increment count of unique vowels
                }
    
                // Remove duplicates from the start of the window to ensure each vowel appears only once
                while (freq.get(str.charAt(j)) != null && freq.get(str.charAt(j)) > 1) {
                    // Reduce the count of the character at the start
                    freq.put(str.charAt(j), freq.get(str.charAt(j)) - 1);
                    pref++; // Move the start forward
                    j++;    // Increment the left pointer
                }
    
                // If all five vowels are present in the current window
                if (vowelCount == 5) {
                    // All substrings ending at 'i' that include all vowels
                    // can be counted by adding (1 + pref)
                    ans += (1 + pref);
                }
            } else {
                // Reset the window if a non-vowel character is encountered
                freq.clear(); // Clear the vowel counts
                vowelCount = 0; // Reset the count of unique vowels
                pref = 0; // Reset the offset
                j = i + 1; // Move the start pointer to the next position
            }
        }
    
        return ans; // Return total count of valid vowel substrings
    }
}