package main.leetcode;

public class KthCharacterDecryptedString {

    static char encodedChar(String str,int k){

        if(str.length() == 0) return ' ';

        int start = 0;
        int pos = 0;

        for(int i=0; i<str.length(); i++){

            if(Character.isDigit(str.charAt(i))){
                int digitStart = i;
                int end = i+1;
                while(end < str.length() && Character.isDigit(str.charAt(end))){
                    i++;
                    end++;
                }
                int count =  Integer.parseInt(str.substring(digitStart, end));

                int strCount =  (i - start- (end-digitStart -1));

                if( (count * strCount + pos) >= k){
                    if((count * strCount + pos) == k) return str.charAt(start+ ((k-pos) % strCount));
                    else return str.charAt(start+ ((k-pos) % strCount)-1);
                }else{
                    pos = pos  + count * strCount;
                    start = i+1;
                }
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        String str = "ab4c12ed3";
        int k = 22;
        System.out.println(encodedChar(str, k));
    }


}
