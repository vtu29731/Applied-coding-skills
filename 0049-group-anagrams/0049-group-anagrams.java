class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> mp = new HashMap<>();
        for(int i = 0 ; i < strs.length ; i++){
            String word = strs[i];
            char arr[] = word.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if(!mp.containsKey(key)){
                mp.put(key , new ArrayList<>());
            }

            mp.get(key).add(word);
        }
    return new ArrayList<>(mp.values());
    }
}