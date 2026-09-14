class Solution {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        int curr = 0;
        while (curr < nums.length) {
            if (nums[curr] != 0) {
                nums[idx] = nums[curr];
                idx++;
            }
            curr++;
        }
        while (idx < nums.length) {
            nums[idx] = 0;
            idx++;
        }
    }
}
