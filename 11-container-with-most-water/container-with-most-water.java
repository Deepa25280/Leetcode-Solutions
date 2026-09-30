class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int maxi = 0;

        while (l < r) {
            int w = r-l;
            int h = Math.min(height[l], height[r]);
            int a = h*w;
            maxi=Math.max(maxi, a);
            if(height[l]<height[r])l++;
            else r--;
        }
        return maxi;
    }
}