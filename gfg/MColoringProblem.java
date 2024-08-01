//Problem Link : https://www.geeksforgeeks.org/m-coloring-problem-backtracking-5/

/*
Solution 2: Backtracking
*/
class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int[] color = new int[n]; //color of nodes
        return evaluate(0, graph, m, n, color);
    }
    
    private boolean evaluate(int node, boolean graph[][], int m, int n, int[] color) {
        if (node == n) {
            return true;
        }
        for (int i = 1; i <= m; i++) { //iterate all colors
            if (!canColor(graph, color, i, node, n)) {
                continue;
            }
            color[node] = i;
            boolean status = evaluate(node + 1, graph, m, n, color);
            if (status) {
                return status;
            }
            color[node] = 0; //remove color
        }
        return false;
    }
    
    private boolean canColor(boolean graph[][], int[] color, int selectedColor, int node, int n) {
        for (int i = 0; i < n; i++) {
            if (graph[node][i] && (color[i] == selectedColor)) {
                return false; //adjacent node has same color as selectedColor
            }
        }
        return true;
    } 
}

/*
Solution 1:
TC = O(M ^ N), as M choices and max depth is N.. think like a decision tree
Logic:
Go to one vertice
Go through each color one by one, if color is eligible (it should be different from all adjacent nodes), then color it and go to its vertices one by one and follow the same logic.
If color is not satisfying backtrack

Do this till all the vertices are colored
*/

class solve 
{
    //Function to determine if graph can be coloured with at most M colours such
    //that no two adjacent vertices of graph are coloured with same colour.
    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int C) 
    {
        // Your code here
        boolean status = true;
        for (int n = 0; n < G.length; n++) {
            if (color[n] != 0) {
                continue;
            }
            status = colorUtil(G, color, n, C);
            if (!status) {
                return status;   
            }
        }
        return status;
    }
    
    private static boolean colorUtil(List<Integer>[] G, int[] color, int i, int C) 
    {
        // Your code here
        List<Integer> next = G[i];
        for (int j = 1; j <= C; j++) {
            boolean eligibleColor = true;
            for (Integer n : next) {
                if (color[n] == j) {
                    eligibleColor = false;
                    break;
                }
            }
            if (eligibleColor) {
                color[i] = j;
                boolean status = true;
                for (Integer n : next) {
                    if (color[n] != 0) {
                        continue;
                    }
                    status = colorUtil(G, color, n, C);
                    if (!status) {
                        break;
                    }
                }
                if (status) {
                    return status;
                }
            }
            color[i] = 0; //backtrack
        }
        return false;
    }
}