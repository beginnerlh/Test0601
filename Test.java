package bishi0601;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int n = 3; //格雷码位数
        /*int a = (int)Math.pow(2, n);
        String[] str = new String[a];
        for(int i = 0; i < a; i++){
            int grayCode = (i >> 1) ^ i;
            str[i] = addGray(grayCode, n);
        }
        System.out.println(Arrays.toString(str));*/
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.getGray(n)));
    }
    public static String addGray(int grayCode, int n){
        String ret = "";
        for(int i = n-1; i >= 0; i--){
            ret += (grayCode >> i) & 1;
        }
        return ret;
    }
}

class Solution{
    public String[] getGray(int n){
        // produce 2^n grade codes
        String[] graycode = new String[(int) Math.pow(2, n)];

        if (n == 1) {
            graycode[0] = "0";
            graycode[1] = "1";
            return graycode;
        }

        String[] last = getGray(n - 1);

        for (int i = 0; i < last.length; i++) {
            graycode[i] = "0" + last[i];
            graycode[graycode.length - 1 - i] = "1" + last[i];
        }

        return graycode;

    }
}
