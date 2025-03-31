class DisjointSet {
    int[] parent;
    int[] size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int getUltimateParent(int x) {
        if (parent[x] == x) {
            return x;
        }
        int uParent = getUltimateParent(parent[x]);
        parent[x] = uParent;
        return uParent;
    }

    public void union(int x, int y) {
        int uParentX = getUltimateParent(x);
        int uParentY = getUltimateParent(y);
        if (uParentX == uParentY) {
            return;
        }
        if (size[uParentY] < size[uParentX]) {
            parent[uParentX] = uParentY;
            size[uParentY] += size[uParentX];
        } else {
            parent[uParentY] = uParentX;
            size[uParentX] += size[uParentY];
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DisjointSet ds = new DisjointSet(accounts.size());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 0; j < accounts.get(i).size(); j++) {
                if (j == 0) {
                    continue; //name
                }
                String email = accounts.get(i).get(j);
                if (map.containsKey(email)) {
                    ds.union(i, (int)map.get(email));
                }
                map.put(email, i);
            }
        }
        Map<Integer, List<String>> mergedMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String email = entry.getKey();
            Integer index = entry.getValue();
            Integer ultimateIndex = ds.getUltimateParent(index);
            if (!mergedMap.containsKey(ultimateIndex)) {
                mergedMap.put(ultimateIndex, new LinkedList<>());
            }
            mergedMap.get(ultimateIndex).add(email);
        }
        List<List<String>> mergedAccounts = new LinkedList<>();
        for (Map.Entry<Integer, List<String>> entry : mergedMap.entrySet()) {
            Integer index = entry.getKey();
            List<String> emails = new LinkedList<>(entry.getValue());
            Collections.sort(emails);
            List<String> accountEmails = new LinkedList<>();
            accountEmails.add(accounts.get(index).get(0)); //name
            accountEmails.addAll(emails);
            mergedAccounts.add(accountEmails);
        }
        return mergedAccounts;
    }
}