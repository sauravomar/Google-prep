package main.leetcode;

import java.text.SimpleDateFormat;
import java.util.*;

public class AlertThreeCard {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String>result = new ArrayList<>();
        if(keyName.length == 0 || keyTime.length == 0) return result;

        Map<String, List<String>>map  = new HashMap<>();

        for(int  i=0; i<keyName.length;i++){
            List<String>list = new ArrayList<>();
            if(map.containsKey(keyName[i])){
                list = map.get(keyName[i]);
            }
            list.add(keyTime[i]);
            map.put(keyName[i],list);
        }


        for(Map.Entry<String, List<String>> entry :  map.entrySet()){
            if(entry.getValue().size() >= 3){
                boolean isAlert = isValid(entry.getValue());
                if(isAlert){
                    result.add(entry.getKey());
                }
            }
        }

        Collections.sort(result);
        return result;

    }


    private boolean isValid( List<String> list){
        int count = 0;

        for(int i=0;i<list.size(); i++){
            for(int j=i+1;j<list.size();j++){

                long val = getTimeStampDiff(list.get(i), list.get(j));

                if( val >= -60 &&  val <= 60){
                    count++;
                }

                if(count >= 2) return true;
            }
        }

        return false;
    }

    private long getTimeStampDiff(String time1, String time2){

            long min = 0;
            long difference ;
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm"); // for 12-hour system, hh should be used instead of HH
                Date date1 = simpleDateFormat.parse(time1);
                Date date2 = simpleDateFormat.parse(time2);

                difference = (date2.getTime() - date1.getTime()) / 1000;
                long hours = difference % (24 * 3600) / 3600; // Calculating Hours
                long minute = difference % 3600 / 60; // Calculating minutes if there is any minutes difference
                min = minute + (hours * 60); // This will be our final minutes. Multiplying by 60 as 1 hour contains 60 mins
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return min;

    }

    public static void main(String[] args) {
        String []  keyName =  { "a","a","a","a","a","a","b","b","b","b","b"};
        String [] keyTime = {"23:27","03:14","12:57","13:35","13:18","21:58","22:39","10:49","19:37","14:14","10:41"};

        System.out.println(new AlertThreeCard().alertNames(keyName,keyTime));
     }
}
