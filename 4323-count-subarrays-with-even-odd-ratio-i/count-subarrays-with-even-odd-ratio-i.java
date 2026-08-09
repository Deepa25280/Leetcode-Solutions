class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int n=nums.length;
        int cnt=0;
        for(int i=0; i<n; i++){
            int x=0, y=0;
            for(int j=i; j<n; j++){
                if((nums[j]%2)==1){
                    y++;
                }else{
                    x++;
                }
                if(y>0 && (long)(x*b)<=(long)(y*a)){
                  cnt++;
                }
            }
        }
        return cnt;
    }
}