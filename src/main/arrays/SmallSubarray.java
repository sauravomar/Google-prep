package main.arrays;

public class SmallSubarray {


   public int smallestSubWithSum(int arr[], int sum){

       int end = 0;

       int minLength = arr.length+1;
       int curr_sum = 0;
       int start =0;

       while (end < arr.length){

           while (curr_sum <= sum && end < arr.length)
               curr_sum += arr[end++];


           if(minLength > (end -start)){
               minLength = end-start;
           }


            while(curr_sum > sum && start < arr.length ){
                curr_sum = curr_sum - arr[start];
                start++;

                if(minLength > (end -start)){
                    minLength = end-start;
                }
            }

       }

       return minLength;
   }

    public static void main(String[] args) {
        int arr1[] = {1, 4, 45, 6, 10, 19};

        int res1 = new SmallSubarray().smallestSubWithSum(arr1, 51);

        System.out.println(res1);
    }
}



