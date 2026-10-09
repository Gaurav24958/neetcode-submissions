class Solution {

    public static String sortString(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> lst = new ArrayList();
        Map<String,List<String>> map = new HashMap();
        for(int i = 0; i<strs.length;i++){
            lst.add(sortString(strs[i]));
        }

        for(int i = 0;i<strs.length;i++){
            if(!map.containsKey(lst.get(i))){
                map.put(lst.get(i),new ArrayList<String>());
                map.get(lst.get(i)).add(strs[i]);
            }else{
                map.get(lst.get(i)).add(strs[i]);
            }
            
        }

        return new ArrayList<>(map.values());

        
    }
}
