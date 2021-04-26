package main.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {

    public List<Integer> majorityElement(int[] nums) {

        int cnt1=0, cnt2=0;
        int a=0,b=0;

        for(int n: nums){
            if (n == a) cnt1++;
            else if (n == b) cnt2++;
            else if (cnt1 == 0){
                cnt1++;
                a = n;
            }
            else if (cnt2 == 0){
                cnt2++;
                b = n;
            }
            else{
                cnt1--;
                cnt2--;
            }

        }

        cnt1=cnt2=0;

        for(int n: nums){
            if (n==a) cnt1++;
            else if (n==b) cnt2++;
        }

        List<Integer>list = new ArrayList<>();

        if (cnt1 > nums.length/3) list.add(a);
        if (cnt2 > nums.length/3) list.add(b);
        return list;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,2,3,2,1,1,3};
        System.out.println( new MajorityElement().majorityElement(arr));
    }
}
