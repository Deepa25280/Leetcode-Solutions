class Solution {
    public int passwordStrength(String password) {
        int n = password.length();
        int s = 0;
        int i=0;
        boolean[] seen =new boolean[128];
        
        while(i<n){
            char ch = password.charAt(i);
           
            if(!seen[ch] && ch>='a' && ch<='z'){
                s+=1;
                seen[ch]=true;
            
               
            }
            else if(!seen[ch]&& ch>='A' && ch<='Z'){
                s+=2;
               seen[ch]=true;
             
            }
            else if(!seen[ch] && ch>='0' && ch<='9'){
               s+=3;
                seen[ch]=true;
               
            }
             else if(!seen[ch] && (ch=='!' || ch=='@'||ch=='#' || ch=='$')){
                s+=5;
              seen[ch]=true;
            }
         i++;
        }
        return s;
    }
}