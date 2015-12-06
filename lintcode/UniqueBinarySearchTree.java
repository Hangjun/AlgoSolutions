/*
 * Given n, how many structurally unique BSTs (binary 
 * search trees) that store values 1...n?

Example
Given n = 3, there are a total of 5 unique BST's.

1           3    3       2      1
 \         /    /       / \      \
  3      2     1       1   3      2
 /      /       \                  \
2     1          2                  3
 */
public class UniqueBinarySearchTree {

    /**
     * @paramn n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }

    public int numTrees(int n) {
        int result = 1;
        for (int i = 0; i < n; ++i) {
            result = result * (n + 1 + i) / (i + 1);
        }
        result /= n + 1;
        return result;
    }

/*********************************************************/
    // TLE
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < n; ++i) {
            result += numTrees(i) * numTrees(n - 1 - i);
        }
        return result;
    }

}