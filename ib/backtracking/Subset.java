public class Solution {
  public ArrayList < ArrayList < Integer >> subsets(ArrayList < Integer > a) {
    Collections.sort(a);
    ArrayList < ArrayList < Integer >> result = new ArrayList < > ();
    HashMap < Integer, ArrayList < ArrayList < Integer >>> memMap = new HashMap < > ();
    return recSubset(a, 0, memMap);

  }

  private ArrayList < ArrayList < Integer >> recSubset(ArrayList < Integer > a,
    int index, HashMap < Integer, ArrayList < ArrayList < Integer >>> memMap) {

    if (memMap.containsKey(index)) {
        //System.out.println("mem hit for index: "+ index);
      return new ArrayList<>(memMap.get(index));
    }

    if (index == (a.size() + 1)) {
      return new ArrayList<ArrayList<Integer>>();
    }

    ArrayList < ArrayList < Integer >> result = new ArrayList < > ();

    for (int i = index; i <= a.size(); i++) {
      if (i == index) {
        result.add(new ArrayList < Integer > ());
      } else {
        ArrayList < ArrayList < Integer >> subResult =
          recSubset(a, i, memMap);
        if (subResult.size() == 0) {
          ArrayList < Integer > set = new ArrayList < Integer > ();
          set.add(a.get(i - 1));
          result.add(set);
        } else {
          for (ArrayList < Integer > set: subResult) {
              ArrayList<Integer> newSet;
              if (set.size() == 0) {
                 newSet = new ArrayList<>();
              } else {
                newSet = new ArrayList<>(set);   
              }
            newSet.add(0, a.get(i - 1));
            result.add(newSet);
          }
        }
      }
    }

    //System.out.println("Index: " + index + " result: "+ result);
    memMap.put(index, result);
    return result;
  }

}