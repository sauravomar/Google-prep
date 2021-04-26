package main.leetcode;

public class BitwiseComplement {

    public int bitwiseComplement(int N) {

        if(N == 0) return 1;

        int no = N;
        StringBuilder sb = new StringBuilder();

        while(no != 0){

            if(no %2 == 0){
                sb.append("1");
            }else{
                sb.append("0");
            }
            no = no>>1;

        }

        return Integer.parseInt(sb.reverse().toString(),2);
    }

    public static void main(String[] args) {
        BitwiseComplement obj = new BitwiseComplement();
        System.out.println(obj.bitwiseComplement(5));
    }
}
