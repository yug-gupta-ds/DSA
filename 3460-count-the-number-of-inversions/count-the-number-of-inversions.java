class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfPermutations(int n, int[][] requirements) {
        int maxInv = 400;

        int[] need = new int[n];
        Arrays.fill(need, -1);

        for (int[] r : requirements) {
            need[r[0]] = r[1];
        }

        int[][] dp = new int[n + 1][maxInv + 1];
        dp[0][0] = 1;

        for (int len = 1; len <= n; len++) {

            for (int inv = 0; inv <= maxInv; inv++) {

                long ways = 0;

                for (int add = 0; add <= Math.min(inv, len - 1); add++) {
                    ways += dp[len - 1][inv - add];
                }

                dp[len][inv] = (int) (ways % MOD);
            }

            int req = need[len - 1];
            if (req != -1) {
                for (int inv = 0; inv <= maxInv; inv++) {
                    if (inv != req) {
                        dp[len][inv] = 0;
                    }
                }
            }
        }

        long ans = 0;
        for (int inv = 0; inv <= maxInv; inv++) {
            ans = (ans + dp[n][inv]) % MOD;
        }

        return (int) ans;
    }
}