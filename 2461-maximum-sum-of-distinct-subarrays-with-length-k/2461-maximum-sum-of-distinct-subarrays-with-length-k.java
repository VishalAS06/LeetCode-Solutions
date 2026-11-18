class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

       int n = nums.length;
        long windowSum = 0;
        long maxAns = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        if (map.size() == k) {
            maxAns = windowSum;
        }

        for (int j = k; j < n; j++) {

            windowSum += nums[j];
            windowSum -= nums[j-k];

            int old = nums[j-k];

            map.put(old, map.get(old) - 1);

            if (map.get(old) == 0) {
                map.remove(old);
            }

            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            if (map.size() == k) {
                maxAns = Math.max(maxAns, windowSum);
            }
        }
        return maxAns;
    }
}