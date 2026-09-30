class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mp1=new HashMap<>();
        HashMap<Character, Character> mp2=new HashMap<>();
        if(s.length() != t.length())return false;
        for(int i=0; i<s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
           if(mp1.containsKey(a) && mp1.get(a)!=b)return false;
           if(mp2.containsKey(b) && mp2.get(b)!=a)return false;
           mp1.put(a, b);
           mp2.put(b, a); 
        }
     return true;   
    }
}