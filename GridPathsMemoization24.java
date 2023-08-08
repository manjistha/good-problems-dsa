import java.util.*;

public class GridPathsMemoization24 {
    public static void findPaths(int m, int n, int sx, int sy, int dx, int dy) {
        int[][] dp = new int[m][n];
        List<String>[][] paths = new ArrayList[m][n];

        dp[dx][dy] = 1;
        paths[dx][dy] = new ArrayList<>(Arrays.asList(""));

        for (int i = dx; i >= sx; i--) {
            for (int j = dy; j >= sy; j--) {
                if (i == dx && j == dy) continue;

                int rightPaths = (i + 1 <= dx) ? dp[i + 1][j] : 0;
                int upPaths = (j + 1 <= dy) ? dp[i][j + 1] : 0;

                dp[i][j] = rightPaths + upPaths;

                paths[i][j] = new ArrayList<>();
                if (rightPaths > 0) {
                    for (String path : paths[i + 1][j]) {
                        paths[i][j].add("T" + path);//T for bottom towards up
                    }
                }
                if (upPaths > 0) {
                    for (String path : paths[i][j + 1]) {
                        paths[i][j].add("R" + path);//R for left to right
                    }
                }
            }
        }

        System.out.println("Number of possible paths: " + dp[sx][sy]);
        System.out.println("All possible paths:");

        for (String path : paths[sx][sy]) {
            System.out.println(path);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows (m): ");
        int m = sc.nextInt();
        System.out.print("Enter the number of columns (n): ");
        int n = sc.nextInt();

        System.out.print("Enter the starting point (sx sy): ");
        int sx = sc.nextInt();
        int sy = sc.nextInt();

        System.out.print("Enter the destination point (dx dy): ");
        int dx = sc.nextInt();
        int dy = sc.nextInt();

        if (sx > dx || sy > dy || sx < 0 || sy < 0 || dx >= m || dy >= n) {
            System.out.println("Invalid starting or destination point.");
        } else {
            findPaths(m, n, sx, sy, dx, dy);
        }

        sc.close();
    }
}
