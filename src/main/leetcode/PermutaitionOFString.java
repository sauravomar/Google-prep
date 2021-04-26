package main.leetcode;

public class PermutaitionOFString {

    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public void generate(String str, int start, int end){


        if(start == end){
            System.out.println(str);
        }

        else{
            for(int i=start; i<=end;i++){
                str =  swap(str, start, i);
                generate(str,start+1, end);
                str =  swap(str, start, i);
            }
        }
    }

    public static void main(String[] args) {
        String str = "ABC";
        int n = str.length();
        PermutaitionOFString permutation = new PermutaitionOFString();
        permutation.generate(str, 0, n-1);

    }
}
