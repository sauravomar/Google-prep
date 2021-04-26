package main.leetcode;

public class JumpGame_iii {

    public boolean canReach(int[] arr, int start) {
        if(start < 0 || arr.length == 0 || start > arr.length-1) return false;
        return dfs(arr,start,0);
    }


    private boolean dfs(int[] arr, int start, int count ){
        if(start < 0 || start > arr.length-1) return false;
        if(count >= arr.length) return false;
        if(arr[start] == 0) return true;
        return dfs(arr,start-arr[start], count+1) || dfs(arr,arr[start] + start, count+1);

    }
    public static void main(String[] args) {
        JumpGame_iii obj = new JumpGame_iii();

        int []arr = {4,4,1,3,0,3};

        System.out.println(new JumpGame_iii().canReach(arr, 2));

    }

}
