public class Solution {
    public int solve(ArrayList < Integer > A, int B, int C) {
        if (B == 0) {
            return 0;
        }
        
        if (A == null || A.size() == 0) {
            return 0;
        }
        
        Set<Integer> aSet = new HashSet<>();
        for (int d : A) {
            aSet.add(d);
        }
        A.clear();
        A.addAll(aSet);
        
        
        String cStr = Integer.toString(C);
        int cStrLen = cStr.length();
        if (B < cStrLen) {
            return (A.get(0) == 0 && B > 1) ? ((A.size() - 1) * (int)Math.pow(A.size(), (B - 1))) : (int)Math.pow(A.size(), B);
        } else if (B > cStrLen) {
            return 0;
        }

        int sum = 0;
        boolean overlap = false;
        for (int i = 0; i < B; i++) {
            if (i == 0) {
                int count = 0;
                for (int j = 0; j < A.size(); j++) {
                    if (A.get(j) == 0 && B > 1) {
                        continue;
                    }
                    int val = cStr.charAt(i) - '0';
                    if (A.get(j) <= val) {
                        count++;
                    }
                    if (A.get(j) == val) {
                        overlap = true;
                    }
                }
                sum = count * (int)Math.pow(A.size(), (B - 1));
            } else {
                overlap = false;
                int count = 0;
                int val = cStr.charAt(i) - '0';
                if (i == (B - 1)) {
                    for (int j = 0; j < A.size(); j++) {
                        if (A.get(j) >= val) {
                            count++;
                        }
                    }
                } else {
                    for (int j = 0; j < A.size(); j++) {
                        if (A.get(j) > val) {
                            count++;
                        } else if (A.get(j) == val) {
                            overlap = true;
                        }
                    }
                }
                sum -= count * Math.pow(A.size(), (B - i - 1));
            }    
            if (!overlap) {
                break;
            }
        }
        return sum;
    }
}