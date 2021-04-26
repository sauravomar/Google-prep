package main.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicates {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer>list = new ArrayList<>();

        if(nums.length == 0) return  list;

        HashMap<Integer,Integer>map = new HashMap();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() > 1){
                list.add(entry.getKey());
            }
        }
        return  list;

    }

    public static void main(String[] args) {
        int nums[] = {4,3,2,7,8,2,3,1};
        System.out.println(new FindDuplicates().findDuplicates(nums));
    }
}
