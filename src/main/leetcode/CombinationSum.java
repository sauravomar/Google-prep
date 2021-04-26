package main.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0) return null;
        Arrays.sort(candidates);
        List<List<Integer>>result = new ArrayList<>();
        return getTotalSum(candidates, new ArrayList<>(), target, 0, result,0);
    }


    private List<List<Integer>> getTotalSum(int candiates[], List<Integer>list, int target, int sum, List<List<Integer>>result, int start){
        if(sum == target){
             List<Integer>inResult = new ArrayList<>();
             inResult.addAll(list);
             result.add(inResult);
             return result;
        }

       for(int i=start; i<candiates.length; i++){
           if(candiates[i] + sum <= target){
               list.add(candiates[i]);
               getTotalSum(candiates, list, target,sum+candiates[i], result, i);
               list.remove(list.size()-1);
           }
       }
       return result;
    }

    public static void main(String[] args) {
        int [] candidates = {1};
        int target = 2;

        List<List<Integer>>result = new CombinationSum().combinationSum(candidates,target);
        System.out.println(result);
    }

}
