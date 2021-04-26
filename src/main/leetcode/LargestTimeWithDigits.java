package main.leetcode;

public class LargestTimeWithDigits {

    public String largestTimeFromDigits(int[] A) {

        int digits[] = new int[10];

        for(int i=0; i<A.length; i++){
            if(A[i] < 9) digits[A[i]]++;
        }

        String firstHour = getFirstHour(digits);
        String secondHour = getSecondtHour(digits);

        String firstMinutes = getFirstMinutes(digits);
        String secondMinutes = getFirstMinutes(digits);

        if(firstHour.length() == 0 || secondHour.length() == 0 || firstMinutes.length() == 0 ||secondMinutes.length() == 0)
            return "";

        return firstHour+secondHour+":"+firstMinutes+secondMinutes;
    }

    private String getFirstHour( int digits[]){

        for(int i=2; i>=0; i--) {
            if(digits[i] > 0){
                digits[i]--;
                return i+"";
            }
        }

        return "";
    }

    private String getSecondtHour( int digits[]){

        StringBuilder sb = new StringBuilder();

        for(int i=3; i>=0; i--) {
            if(digits[i] > 0){
                digits[i]--;
                return i+"";
            }
        }

        return "";
    }

    private String getFirstMinutes( int digits[]){

        for(int i=5; i>=0; i--) {
           if(digits[i] > 0){
               digits[i]--;
               return i+"";
           }
        }

        return "";
    }

    private String getSecondMinutes( int digits[]){

        for(int i=5; i>=0; i--) {
            if(digits[i] > 0){
                digits[i]--;
                return i+"";
            }
        }

        return "";

    }

    public static void main(String[] args) {
         int arr[] = {5, 5, 6, 6};
        System.out.println(new LargestTimeWithDigits().largestTimeFromDigits(arr));
    }
}
