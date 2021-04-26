package main.leetcode;

public class KMP {

    public boolean KMPSearch(String pat, String txt) {

        if(txt.length() == 0 || pat.length() == 0) return false;

        int lps[] = computeLPS(pat);


        int start =0;
        int pattStart = 0;

        while(start < txt.length()){

            if(txt.charAt(start) == pat.charAt(pattStart)){
                start++;
                pattStart++;
                continue;
            }
            if (pattStart == pat.length()) {
                System.out.println("found");
                return  true;
            } else if (start < txt.length() && pat.charAt(pattStart) != txt.charAt(start)) {
                if(pattStart !=0) {
                    pattStart = lps[pattStart-1];
                }else{
                    start++;
                }
            }
        }

        return false;
    }


    private int[] computeLPS(String pat) {

        int i = 1;
        int lps[] = new int[pat.length()];
        lps[0] = 0;
        int len = 0;

        while (i < pat.length()) {

            if (pat.charAt(len) == pat.charAt(i)) {
                i++;
                len++;
                continue;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }

        return lps;
    }
}
