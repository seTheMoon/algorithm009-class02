class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,((o1, o2) -> (o1[0] - o2[0])));

        int index = -1;
        int[][] res = new int[intervals.length][2];

        for (int[] interval : intervals) {
            if (index == -1 || interval[0] > res[index][1]) {
                res[++index] = interval;
            }else {
                res[index][1] = Math.max(res[index][1],interval[1]);
            }
        }

        return Arrays.copyOf(res,index+1);
    }
}

// 先按区间起始位置升序排序，再遍历