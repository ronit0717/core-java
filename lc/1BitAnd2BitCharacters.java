class Solution {
    public boolean isOneBitCharacter(int[] bits) {
 		boolean result = false;
 		int i = 0;
 		int length = bits.length;
 		while(i < length) {
 			if(bits[i] == 0) {
 				i++;
 				if (i == length) {
 					result = true;
 				}
 			} else {
 				i+=2;
 			}
 		}
 		return result;
    }
}