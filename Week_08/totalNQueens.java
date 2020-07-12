class Solution {
	private int size; 
	private int count;
	private void solve(int col, int pie, int na) { 
		if (col == size) { 
			count++; 
			return; 
		}
		int pos = size & (~(col | pie | na)); 
		while (pos != 0) { 
			int p = pos & (-pos); 
			pos -= p; // pos &= pos - 1; 
			solve(col | p, (pie | p) << 1, (na | p) >> 1); 
		} 
	} 
    public int totalNQueens(int n) { 
        count = 0; 
        size = (1 << n) - 1; 
        System.out.println(size);
        solve(0, 0, 0); 
        return count; 
    } 
}