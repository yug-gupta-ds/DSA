class TreeAncestor {
    int[][] up;
    int LOG;

    public TreeAncestor(int n, int[] parent) {
        LOG = 16; // Since n <= 50000
        up = new int[n][LOG];

        for (int i = 0; i < n; i++)
            up[i][0] = parent[i];

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                int p = up[i][j - 1];
                up[i][j] = (p == -1) ? -1 : up[p][j - 1];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < LOG; j++) {
            if ((k & (1 << j)) != 0) {
                node = up[node][j];

                if (node == -1)
                    return -1;
            }
        }

        return node;
    }
}