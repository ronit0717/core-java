class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    row.add(1);
                } else {
                    row.add(result.get(i - 2).get(j - 2) + result.get(i - 2).get(j - 1));
                }
            }
            result.add(row);
        }
        return result;
    }
}

/*

      1
     1 1
    1 2 1
   1 3 3 1
  1 4 6 4 1

*/