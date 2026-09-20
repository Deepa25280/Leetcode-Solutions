class Solution {
    public boolean strongPasswordCheckerII(String password) {
        int n = password.length();
         if(n<8)return false;
        int i=0;
        boolean l = false;
        boolean u = false;
        boolean d = false;
        boolean sp = false;

        while(i<n){
           
            char ch = password.charAt(i);
            if(i>0 && password.charAt(i-1) == password.charAt(i) )return false;
                if(ch>='a' && ch<='z' && l==false){
                     l=true;
                }
                else if(ch>='A' && ch<='Z' && u==false){
                     u=true;
                }
                else if(ch>='0' && ch<='9' && d==false){
                     d=true;
                }
                else if (ch=='!'|| ch=='@'|| ch=='#'|| ch=='$'|| ch=='%'|| ch=='^'|| ch=='&'|| 
                ch=='*'||ch=='('||ch==')'||ch=='-'|| ch=='+'){
                     sp=true;
                }
            i++;
        }
        if(l==true && u==true && d==true && sp==true)return true;
        else return false;
    }
}