package main.dp;

public class LookAndSay {

    public String countnndSay(int n) {

        if (n == 1) return "1";
        if (n == 2) return "11";

        String str = "11";

        for (int i = 3; i <= n; i++) {
            str += '$';
            int len = str.length();

            String tmp = "";
            int count = 1;

            for (int j = 1; j <len; j++) {

                if(str.charAt(j-1) != str.charAt(j)){
                    tmp = tmp + count + str.charAt(j-1);
                    count=1;
                }else{
                    count++;
                }
            }
            str=tmp;
        }

        return  str;
    }

    public static void main(String[] args) {
        System.out.println(new LookAndSay().countnndSay(5));

    }
}
