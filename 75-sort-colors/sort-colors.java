class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int l=0; int m=0; int h=n-1;
        while(m<=h){
            if(nums[m]==0){
                swap(nums,l, m);
                m++;
                l++;
            }else if(nums[m]==2){
                swap(nums, m, h);
                h--;
            }
            else{
                m++;
            }
        }
    }
    public static void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]=temp;
    }
}