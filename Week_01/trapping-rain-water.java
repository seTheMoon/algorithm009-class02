class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack();
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            while ( !stack.isEmpty() && height[i] > height[stack.peek()]) {
               int pillarHeight = height[stack.pop()];
               if (stack.isEmpty()) break;
               int containerHeitht = Math.min(height[i],height[stack.peek()]) - pillarHeight;
               int distance = i - stack.peek() - 1;
               sum += distance * containerHeitht;
            }
            stack.push(i);
        }
        return sum;
    }
}

