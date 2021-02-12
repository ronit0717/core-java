class Solution {
    public String addBinary(String a, String b) {
        boolean carry = false;
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        while((i != -1) || (j != -1) || carry) {
        	char ac = '0';
        	char bc = '0';
        	if (i != -1) {
        		ac = a.charAt(i);
        		i--;
        	}
        	if (j != -1) {
        		bc = b.charAt(j);
        		j--;
        	}
        	if (ac == '1' && bc == '1' && carry) {
        		sb.insert(0, '1');
        		carry = true;
        	} else if (ac == '1' && bc == '1' && !carry) {
        		sb.insert(0, '0');
        		carry = true;
        	} else if ((ac == '1' || bc == '1') && carry) {
        		sb.insert(0, '0');
        		carry = true;
        	} else if ((ac == '1' || bc == '1') && !carry) {
        		sb.insert(0, '1');
        		carry = false;
        	} else if (carry) {
        		sb.insert(0, '1');
        		carry = false;
        	} else {
        		sb.insert(0, '0');
        	}
        }
        return sb.toString();
    }
}