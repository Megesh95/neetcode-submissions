class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch:t.toCharArray()){
            if(!map.containsKey(ch)){
                return false;
            }
            if(map.get(ch)<=0)return false;
            map.put(ch,map.getOrDefault(ch,0)-1);
        }
        if (s.length() != t.length()) {
    return false;
}
        return true;
    }
}
