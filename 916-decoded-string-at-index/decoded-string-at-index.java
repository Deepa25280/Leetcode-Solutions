class Solution {
    public String decodeAtIndex(String s, int k) {
        int n = s.length();
        long size = 0;
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                size=size*(ch-'0');
            }else{
                size+=1;
            }

        }
        for(int i=n-1; n>=0; i--){
            k=(int)(k%size);
            char ch = s.charAt(i);
            if(k==0 && Character.isLetter(ch)){
                return ch+"";
            }
            if(Character.isLetter(ch)){
                size-=1;
            }else{
                size=size/(s.charAt(i)-'0');
            }
        }
        return "";
    }
}