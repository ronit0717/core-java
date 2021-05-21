import java.util.*;

public class HelloWorld{

     public static void main(String []args){
        String[] dun = new String[4];
        dun[0] = "S....";
        dun[1] = ".###.";
        dun[2] = "..#..";
        //dun[2] = "..#.#";
        dun[3] = ".##E#";
        
        int w = dun[0].length(); //width
        int h = dun.length; //height
        
        
        //Creating adjecency list from the matrix
        int[][] d = { {0, -1}, {1, 0}, {0, 1}, {-1, 0} };
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                ArrayList<Integer> adjPos = new ArrayList<>();
                if (dun[i].charAt(j) != '#') {
                    for (int k = 0; k < 4; k++) {
                        int ii = i + d[k][0];
                        int jj = j + d[k][1];
                        if (validPosition(ii, jj, w, h, dun)) {
                            adjPos.add(getPos(ii, jj, w));
                        }
                    }   
                } else {
                    adjPos.add(-1);
                }
                adj.add(adjPos);
            }
        }
        
        //BFS traversal to reach Exit from Start
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[w*h];
        boolean reached = false;
        q.add(0); //start position
        while(!q.isEmpty() && !reached) {
            int curr = q.poll();
            if (visited[curr]) {
                continue;
            }
            visited[curr] = true;
            int curr_i = curr / w;
            int curr_j = curr % w;
            if (dun[curr_i].charAt(curr_j) == 'E') {
                reached = true;
                continue;
            }
            List<Integer> next = adj.get(curr);
            for (Integer n : next) {
                q.add(n);
            }
        }
          
        if (reached) {
            System.out.println("Reached !!!");
        } else {
            System.out.println("Mission failed :(");
        }
     }
     
     private static int getPos(int i, int j, int w) {
         return (i*w) + j;
     }
     
     private static boolean validPosition(int i, int j, int w, int h, String[] dun) {
         if (i >= 0 && i < h && j >= 0 && j < w && dun[i].charAt(j) != '#') {
             return true;
         }
         return false;
     }
}