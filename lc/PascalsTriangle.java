//Solution 3 (Optimised NCR. Using the pattern of multiplication, optimised solution)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>(i);
            int num = 1;
            list.add(num);
            for (int j = 2; j <= i; j++) {
                num *= (i - j + 1);
                num /= (j - 1);
                list.add(num);
            }
            ans.add(list);
        }
        return ans;
    }
}

//Solution 2 (Using NCR)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>(i);
            for (int j = 1; j <= i; j++) {
                int num = ncr(i - 1, j - 1);
                list.add(num);
            }
            ans.add(list);
        }
        return ans;
    }

    private int ncr(int n, int r) {
        if (r == 0 || n == r) {
            return 1;
        }
        int ans = 1;
        for (int i = 1; i <= r; i++) {
            ans = ans * (n - i + 1);
            ans = ans / i;
        }
        return ans;
    }
}

//Solution 1 (Intuitive solution)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);
        List<Integer> list = null;
        List<Integer> prev = null;
        for (int i = 0; i < numRows; i++) {
            prev = list;
            list = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(prev.get(j) + prev.get(j - 1));
                }
            }
            ans.add(list);
        }
        return ans;
    }
}

/*

      1
     1 1
    1 2 1
   1 3 3 1
  1 4 6 4 1

*/