//Solution 2: Using ArrayList (simulating behavior of a stack)
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> list = new ArrayList<>(asteroids.length);
        int pointer = -1;
        //initialise
        for (int i = 0; i < asteroids.length; i++) {
            list.add(0);
        }
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                pointer++;
                list.set(pointer, asteroids[i]);
                continue;
            }
            while(pointer >= 0 && list.get(pointer) > 0 && Math.abs(asteroids[i]) > list.get(pointer)) {
                pointer--;
            }
            if (pointer >= 0 && list.get(pointer) > 0 && Math.abs(asteroids[i]) == list.get(pointer)) {
                pointer--;
                //Both will explode
            } else if (pointer == -1 || list.get(pointer) < 0) {
                pointer++;
                list.set(pointer, asteroids[i]);
            }
            //else do nothing. As current asteroid will explode
        }
        int[] ans = new int[pointer + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}

//Solution 1: Using stack
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                st.push(asteroids[i]);
                continue;
            }
            while(!st.isEmpty() && st.peek() > 0 && Math.abs(asteroids[i]) > st.peek()) {
                st.pop();
            }
            if (!st.isEmpty() && st.peek() > 0 && Math.abs(asteroids[i]) == st.peek()) {
                st.pop();
                //Both will explode
            } else if (st.isEmpty() || st.peek() < 0) {
                st.push(asteroids[i]);
            }
            //else do nothing. As current asteroid will explode
        }
        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
}