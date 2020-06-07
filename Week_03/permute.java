class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> current = new ArrayList();
        recursiveHelper(res,current,nums);
        return res;
    }

    public void recursiveHelper(List<List<Integer>> res,
                                List<Integer> current,
                                int[] nums) {
        
        if (current.size() >= nums.length) {
            res.add(new ArrayList(current));
            return;
        }

        for (int i  = 0; i < nums.length; i++) {
            if (current.contains(nums[i])) continue;
            current.add(nums[i]);
            recursiveHelper(res,current,nums);
            current.remove(current.size() - 1);
        }

    }

}

// 第二遍
// 要记住清理状态
