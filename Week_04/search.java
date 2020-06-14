class Solution {
    public int search(int[] nums, int target) {

        int left = 0,right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target == nums[mid+1]) {
                return mid+1;
            }
            // 0~mid有序但 target 不在 0~mid 中
            if (nums[0] < nums[mid] && (target > nums[mid] || target < nums[0])) {
                left = mid + 1;
            } 
            // 0~mid无序 target不在 0~mid 中
            else if (target > nums[mid] && target < nums[0]) {
                left = mid + 1;
            }
            else right = mid;
        }
        return left == right && nums[left] == target ? left : -1;

    }
}