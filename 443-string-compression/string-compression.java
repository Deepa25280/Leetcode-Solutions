class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0, j = 0;
        char[] newChars = new char[n];
     
        while(i < n) {   
            char ch = chars[i];
            int cnt=1;
            while(i<n-1 && ch==chars[i+1]){
                i++;
                cnt++;
            }
            newChars[j++]=ch;
            if(cnt>1){
                String s=Integer.toString(cnt);
                for(char c:s.toCharArray()){
                    newChars[j++]=c;
                }
            }
            i++;
        }
        for (int k = 0; k < j; k++) {
            chars[k] = newChars[k];
        }
        return j;
    }
}