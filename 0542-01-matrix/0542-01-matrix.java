class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] distances = new int[m][n];

        for (int i = 0; i < m; i++)
            Arrays.fill(distances[i], -1);

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    distances[i][j] = 0;
                    q.offer(new int[] { i, j });
                }
            }
        }

        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] curr = q.poll();
                int i = curr[0];
                int j = curr[1];

                for (int[] dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];

                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && distances[ni][nj] == -1) {
                        q.offer(new int[] { ni, nj });
                        distances[ni][nj] = distances[i][j] + 1;
                    }
                }
            }
        }

        return distances;
    }
}