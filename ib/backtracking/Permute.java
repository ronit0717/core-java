public class Solution {
  public ArrayList < ArrayList < Integer >> permute(ArrayList < Integer > A) {
    if (A == null || A.size() == 0) {
      return null;
    }
    ArrayList < ArrayList < Integer >> result = new ArrayList < > ();
    ArrayList < Integer > cand = new ArrayList < > ();
    recPermute(A, cand, result);
    return result;
  }

  private static void recPermute(ArrayList < Integer > A,
    ArrayList < Integer > cand,
    ArrayList < ArrayList < Integer >> result) {
    if (A.size() == 0) {
      result.add(cand);
      return;
    }

    for (int i = 0; i < A.size(); i++) {
      ArrayList < Integer > newA = new ArrayList < > (A);
      ArrayList < Integer > newCand = new ArrayList < > (cand);
      newCand.add(A.get(i));
      newA.remove(i);
      recPermute(newA, newCand, result);
    }
  }
}