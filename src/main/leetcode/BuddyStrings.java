package main.leetcode;

public class BuddyStrings {

    public boolean buddyStrings(String A, String B) {

        if(A.length() != B.length()) return  false;

        char a='a';
        char b='b';


        boolean isSwapped = false;

        for(int i=0; i<A.length();i++){

            if(A.charAt(i) == B.charAt(i)) continue;
            if(!isSwapped){
                a=A.charAt(i);
                b=B.charAt(i);
                isSwapped=true;
            }else{
                if(a == B.charAt(i) && b == A.charAt(i)) continue;
                i++;
                while(A.charAt(i) ==  B.charAt(i)) continue;

                if( i< A.length() && A.charAt(i) !=  B.charAt(i)) return false;
                else if( i ==(A.length()-1) && A.charAt(i) ==  B.charAt(i)) return true;
                else return false;
            }
        }


        if(isSwapped) return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(new BuddyStrings().buddyStrings("aa", "aa"));
    }
}
