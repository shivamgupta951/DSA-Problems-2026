class Solution {
    public int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }

        int max = 0;
        int count = 0;
        int prev = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int n = pq.remove();
            if (prev == Integer.MAX_VALUE)
                count++;
            else if (n - 1 == prev)
                count++;
            else if (n == prev)
                count = count;
            else
                count = 1;
            if (count > max)
                max = count;
            prev = n;
        }
        return max;
    }
}