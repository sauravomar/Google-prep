package main.leetcode;

public class MissingNumber {
    public int missingNumber(int[] nums) {

        if (nums.length == 0) return 0;

        int number = 0;

        int totalSum = (nums.length * (nums.length + 1)) / 2;
        int sum = 0;
        for (int no : nums) {
            sum = sum + no;
        }

        return totalSum - sum;
    }

//    public static void main(String[] args) {
//
//        int arr[] = {1, 0, 3};
//        System.out.println(new MissingNumber().missingNumber(arr));
//    }

//     class Outer
//    {
//        private static int data = 10;
//        private static int LocalClass()
//        {
//            class Inner
//            {
//                public int data = 20;
//                private int getData()
//                {
//                    return data;
//                }
//            };
//            Inner inner = new Inner();
//            return inner.getData();
//        }
//
//        public static void main(String[] args)
//        {
//            System.out.println(data * LocalClass());
//        }
//    }


}
