class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        PriorityQueue<Integer> heap = new PriorityQueue((o1,o2) -> (map.get(o2) - map.get(o1)));
        for (int i = 0; i < nums.length;i++) {
            if (map.get(nums[i]) == null) map.put(nums[i],1);
            else map.put(nums[i],map.get(nums[i])+1);
        }

        for (Integer integer : map.keySet()) {
            heap.offer(integer);
        }
        int[] res = new int[k];
        for (int i = 0; i < k;i++){
            res[i] = heap.poll();
        }
        return res;
    }
}