class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<Long>((o1,o2) -> (o1.compareTo(o2)));
        Set<Long> set = new HashSet();
        long[] arr = new long[]{2,3,5};
        heap.offer(1l);set.add(1l);
        heap.offer(2l);set.add(2l);
        heap.offer(3l);set.add(3l);
        heap.offer(5l);set.add(5l);

        long num = 0;
        for (int i = 0; i < n; i++) {
            num = heap.poll();
            for (long j : arr) {
                long tmp = num * j;
                if (!set.contains(tmp)) {
                    set.add(tmp);
                    heap.offer(tmp);
                }
            }
        }
        return (int)num;
    }
}