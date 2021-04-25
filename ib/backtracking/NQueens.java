public class Solution {
  public ArrayList < ArrayList < String >> solveNQueens(int a) {
    if ( a <= 0) {
        return null;
    }
    ArrayList < ArrayList < String >> result = new ArrayList<>();
    ArrayList < String > candSet = new ArrayList < > ();
    rec(0, a, candSet, result);
    return result;
  }

  private static void rec(int index,
                            int N, 
                            ArrayList < String > candSet, 
                            ArrayList < ArrayList < String >> result) {
    if (index == N) {
      result.add(candSet);
      return;
    }
    for (int i = 0; i < N; i++) {
      //create new cand String, with Q in ith position
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < N; j++) {
        if (i == j) {
          sb.append('Q');
        } else {
          sb.append('.');
        }
      }
      String cand = sb.toString();

      //check is it safe, if safe add string to candSet else continue
      if (isSafe(candSet, cand)) {
          ArrayList < String > newCandSet = new ArrayList < > (candSet);
          newCandSet.add(cand);
          rec(index + 1, N, newCandSet, result);
       }
    }
  }

  private static boolean isSafe(List < String > candSet, String cand) {
    int row = candSet.size();
    int col = 0;
    for (int i = 0; i < cand.length(); i++) {
      if (cand.charAt(i) == 'Q') {
        col = i;
        break;
      }
    }

    //col check
    for (String set: candSet) {
      if (set.charAt(col) == 'Q') {
        return false;
      }
    }

    //left diagonal check
    int j = row - 1;
    int i = col - 1;
    while (j >= 0 && i >= 0) {
      if (candSet.get(j).charAt(i) == 'Q') {
        return false;
      }
      j--;
      i--;
    }

    //right diagonal check;
    j = row - 1;
    i = col + 1;
    while (j >= 0 && i < cand.length()) {
      if (candSet.get(j).charAt(i) == 'Q') {
        return false;
      }
      j--;
      i++;
    }

    return true;
  }

  }