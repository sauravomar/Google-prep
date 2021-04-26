package main.leetcode;

public class RepeatedSubString {



    public boolean repeatedSubstringPattern(String s) {

        if(null == s || s.length() == 0 || s.length() == 1) return false;
        int lps[] = computeLPSArray(s);

        int count = 0;

        for(int i=0; i<s.length(); i++){
            if(lps[i] == 0){
                count++;
            }
        }

        return (lps[s.length()-1] > 0 && s.length()%(s.length()-lps[s.length()-1]) == 0)? true: false;
    }

    public int[] computeLPSArray(String pat){
        int lps[] = new int[pat.length()];


        int i=1;
        int len = 0;
        lps[0] = 0;

        while( i < pat.length()){

            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len !=0){
                    len = lps[len-1];
                }else{
                    lps[i] =len;
                    i++;
                }
            }
        }


        return lps;
    }

    public static void main(String[] args) {
        System.out.println(new RepeatedSubString().repeatedSubstringPattern("aba"));
    }
}
