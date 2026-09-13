class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Count frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Bucket: index = frequency
        List<Integer>[] bucket = new List[nums.length + 1];

        for (int num : map.keySet()) {
            int freq = map.get(num);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(num);
        }

        // Get top k
        int[] ans = new int[k];
        int index = 0;

        for (int freq = bucket.length - 1; freq >= 0 && index < k; freq--) {
            if (bucket[freq] != null) {
                for (int num : bucket[freq]) {
                    ans[index++] = num;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return ans;
    }
}