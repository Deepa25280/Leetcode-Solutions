class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] f1 = new int[26];
        int[] f2 = new int[26]; 

        for (int i = 0; i < s1.length(); i++) {
            f1[s1.charAt(i) - 'a']++;
        }
        
        int l=0;
        int r=0;
        while(r<s2.length()){
            f2[s2.charAt(r)-'a']++;
            if(r-l+1>s1.length()){
                f2[s2.charAt(l)-'a']--;
                l++;
            }
           
            if(Arrays.equals(f1,f2))return true;
             r++;
        }
        return false;
    }
}