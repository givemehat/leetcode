/**
 * Convert an integer to a Roman numeral string.
 *
 * @param num value in the standard LeetCode range (1..3999)
 * @return Roman numeral representation
 *
 * Greedy: repeatedly subtract the largest symbol value that fits,
 * including subtractive pairs (IV, IX, XL, ...).
 */
class Solution {
public:
    string intToRoman(int num) {
        vector<pair<int, string>> roman = {
            {1000, "M"},
            {900, "CM"},
            {500, "D"},
            {400, "CD"},
            {100, "C"},
            {90, "XC"},
            {50, "L"},
            {40, "XL"},
            {10, "X"},
            {9, "IX"},
            {5, "V"},
            {4, "IV"},
            {1, "I"}
        };

        string ans = "";

        for (auto &p : roman) {
            while (num >= p.first) {
                ans += p.second;
                num -= p.first;
            }
        }

        return ans;
    }
};