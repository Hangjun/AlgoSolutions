/*
 * Given an unsorted array of integers, find the length of longest 
 * increasing subsequence.

 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore 
 * the length is 4. Note that there may be more than one LIS 
 * combination, it is only necessary for you to return the length.

 * Your algorithm should run in O(n^2) complexity.

 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int result = 0;
        for (int value : dp) {
            result = Math.max(result, value);
        }
        return result;
    }

}
