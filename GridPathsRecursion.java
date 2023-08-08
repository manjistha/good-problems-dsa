import java.util.Scanner;

public class GridPathsRecursion {
    public static int countPaths(int sx, int sy, int dx, int dy) {
        int m = dx - sx + 1;
        int n = dy - sy + 1;
        int[][] dp = new int[m][n];

        // Base case: there is only one way to reach the points in the first row and first column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill the DP table using the recurrence relation: dp[i][j] = dp[i-1][j] + dp[i][j-1]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1]; // The result will be at dp[m-1][n-1]
    }

    public static void showPaths(int sx, int sy, int dx, int dy) {
        int m = dx - sx + 1;
        int n = dy - sy + 1;
        int[][] dp = new int[m][n];

        // Base case: there is only one way to reach the points in the first row and first column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill the DP table using the recurrence relation: dp[i][j] = dp[i-1][j] + dp[i][j-1]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // Backtrack to print all paths
        showPathsHelper(sx, sy, dx, dy, dp, "");
    }

    public static void showPathsHelper(int i, int j, int dx, int dy, int[][] dp, String path) {
        if (i == dx && j == dy) {
            System.out.println(path);
            return;
        }

        if (i < dx) {
            showPathsHelper(i + 1, j, dx, dy, dp, path + "R");
        }

        if (j < dy) {
            showPathsHelper(i, j + 1, dx, dy, dp, path + "T");
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
            return;
        }

        int paths = countPaths(sx, sy, dx, dy);
        System.out.println("Number of possible paths: " + paths);

        System.out.println("All possible paths:");
        showPaths(sx, sy, dx, dy);

        sc.close();
    }
}
