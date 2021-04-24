public class Solution {
  public ArrayList < ArrayList < Integer >> subsets(ArrayList < Integer > a) {
    Collections.sort(a);
    ArrayList < ArrayList < Integer >> result = new ArrayList < > ();
    ArrayList < Integer > currSet = new ArrayList < > ();
    recSubset(a, 0, result, currSet);
    return result;
  }

  private static void recSubset(ArrayList < Integer > a,
                                int index,
                                ArrayList < ArrayList < Integer >> result,
                                ArrayList < Integer > currSet) {
    if (index == a.size()) {
      result.add(currSet);
      return;
    }

    for (int i = index - 1; i < a.size(); i++) {
      ArrayList < Integer > newCurr = new ArrayList < > (currSet);
      if (i == (index - 1)) {
        //nothing case
        result.add(newCurr);
      } else {
        newCurr.add(a.get(i));
        recSubset(a, i + 1, result, newCurr);
      }
    }
  }
}