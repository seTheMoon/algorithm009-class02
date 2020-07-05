class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (M[i][j] == 1) {
                    uf.union(i,j);
                }
            }
        }
        return uf.count;
    }

    class UnionFind {
        private int count;
        private int[] parent;

        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int p,int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) return;
            if (rootP != rootQ) {
                parent[rootP] = rootQ;
            }
            this.count--;
        }

        private int find(int p) {

            while (p != this.parent[p]) {
                this.parent[p] = this.parent[this.parent[p]];
                p = this.parent[p];
            }
            return p;
        }

    }
}

// 第一次,并查集