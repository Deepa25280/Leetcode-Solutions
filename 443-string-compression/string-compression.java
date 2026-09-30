class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0, j = 0;
      while(i<n){
        int cnt=0;
        char ch = chars[i];
        while(i<n && chars[i]==ch){
            cnt++;
            i++;
        }
        chars[j++]=ch;
        if(cnt>1){
            String s = Integer.toString(cnt);
            for(char c:s.toCharArray()){
                chars[j++]=c;
            }
        }
      }
      return j;
    }
}