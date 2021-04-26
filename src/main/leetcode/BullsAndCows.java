package main.leetcode;

public class BullsAndCows {

    public String getHint(String secret, String guess) {

        StringBuilder sb = new StringBuilder();
        if(secret.length() == 0 || guess.length() == 0) return sb.toString();


        int bulls = 0;
        int cows = 0;

        int bullsArr[] = new int[10];
        int cowsArr[] = new int[10];

        for(int i =0; i<secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
            }else{
                bullsArr[Integer.parseInt(secret.charAt(i)+"")] ++;
                cowsArr[Integer.parseInt(guess.charAt(i)+"")] ++;
            }
        }

        for(int i =0; i<10; i++){
            if(bullsArr[i] != 0 && cowsArr[i] !=0){
                if(cowsArr[i] > bullsArr[i]){
                    cows = cows + bullsArr[i];
                }else{
                    cows = cows + cowsArr[i];
                }
            }
        }

        sb.append(bulls).append("A");
        sb.append(cows).append("B");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new BullsAndCows().getHint("1123", "0111"));
    }

}
