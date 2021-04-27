public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= A.size(); i++) {
            String sortedStr = getSortedString(A.get(i-1));
            ArrayList<Integer> set = null;
            if (map.containsKey(sortedStr)) {
                set = map.get(sortedStr);
            } else {
                set = new ArrayList<>();
            }
            set.add(i);
            map.put(sortedStr, set);
        }
        for (Map.Entry<String, ArrayList<Integer>> set : map.entrySet()) {
            result.add(set.getValue());
        }
        return result;
    }
    
    private static String getSortedString(String a) {
        char[] charArr = new char[a.length()];
        for (int i = 0; i < a.length(); i++) {
            charArr[i] = a.charAt(i);
        }
        Arrays.sort(charArr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArr.length; i++) {
            sb.append(charArr[i]);
        }
        return sb.toString();
    }
}

/* 
Key Point: The sorted string acts as the key
*/
