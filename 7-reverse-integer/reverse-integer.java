/**
 * Reverse digits of a 32-bit signed integer.
 *
 * @param x input integer (may be negative)
 * @return the reversed integer, or 0 if the reversed value would overflow
 *         Integer.MAX_VALUE / Integer.MIN_VALUE
 *
 * Approach: pop digits via % 10 and push onto {@code rev}. Before each push,
 * reject values that would overflow a 32-bit signed int (same checks as the
 * classic overflow-safe reverse).
 */
class Solution {
    public int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // Check positive overflow
            if (rev > Integer.MAX_VALUE / 10 ||
                (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            // Check negative overflow
            if (rev < Integer.MIN_VALUE / 10 ||
                (rev == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            rev = rev * 10 + digit;
        }

        return rev;
    }
}
