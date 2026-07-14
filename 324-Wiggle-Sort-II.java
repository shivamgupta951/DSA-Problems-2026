class Solution {
    public void wiggleSort(int[] nums) {
        int[] array = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i];
        }
        Arrays.sort(array);
        int left = (nums.length - 1) / 2;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = array[left--];
            } else {
                nums[i] = array[right--];
            }
        }
    }
}