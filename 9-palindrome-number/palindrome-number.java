class Solution {
    public boolean isPalindrome(int x) {

        // Negative number is not a palindrome
        if (x < 0) {
            return false;        }

        int rev = 0;
        int dup = x;

        while (x > 0) {
            int digit = x % 10;
            x = x / 10;
            rev = rev * 10 + digit;
        }

        return rev == dup;
    }
}