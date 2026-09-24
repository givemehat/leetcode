/**
 * Longest substring without repeating characters.
 *
 * @param s input string
 * @return length of the longest substring of {@code s} with all unique chars
 *
 * Typical approach: sliding window with a last-seen index map; advance the
 * left edge past duplicates and track the max window size.
 */
import java.util.HashSet;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // If duplicate exists, move left until duplicate is removed
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            // Current window length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}