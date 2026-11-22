class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];

        // Initially mark all numbers as prime
        for (int i = 2; i < n; i++) {
            prime[i] = true;
        }

        // Mark multiples of prime numbers as false
        for (int i = 2; i * i < n; i++) {
            if (prime[i]) {
                for (int j = i * i; j < n; j += i) {
                    prime[j] = false;
                }
            }
        }

        // Count prime numbers
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                count++;
            }
        }

        return count;
    }
}