package personal.leetcode.problems.rotate_array;

public class Solution {
    public void rotate(int[] nums, int k) {

        if (nums.length < 2 || k==0 || k==nums.length) return;
        if(nums.length < k) {
            k = k % nums.length;
        }

        int[] result = new int[nums.length];
        int p = nums.length - k;
        for (int i=0;i<nums.length;i++) {
            if(p > nums.length-1) {
                p = 0;
            }
            result[i] = nums[p++];
        }
        for (int i=0; i<result.length;i++) {
            nums[i]=result[i];
        }
    }
}
