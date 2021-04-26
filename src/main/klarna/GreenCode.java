package main.klarna;

public class GreenCode {

//    Rule #1: CPU Usage should be less than 90%.
//
//    Rule #2: CPU Usage and Used Memory should not be in their maximum value in the array at the same time. (If both array sizes are NOT equal to 1)
//
//    Rule #3: Used Memory should be less than 60% of the total available.
//
//    Rule #4: Used Memory should not increase in given 3 consecutive measure values.
//
//            Rule #5: If the number of non readable data points (Null) for CPU are more than 30%, Rule #1 and #2 are rejected
//
//    Rule #6: If the number of non readable data points (Null) for Memory are more than 25% , Rule #3 and #4 are rejected
//
//    Rule #7: If there's no readable data points in both arrays, Rules #1, #2, #3 and #4 are rejected


    public static String verify(Float[] cpuUsage, Integer[] usedMemory) {

        if (cpuUsage.length == 0) return "green";


        boolean[] rules = new boolean[7];


        int maxCpuIndex = 0;
        int maxMemoryIndex = 0;

        int cpuNull = 0;
        int memoryNull = 0;


        for (int i = 0; i < cpuUsage.length; i++) {

            if (cpuUsage[i] == null) {
                cpuNull++;
                continue;
            }

            if (cpuUsage[i] >= 0.9f) {
                rules[0] = true;
            }
            if (cpuUsage[i] > cpuUsage[maxCpuIndex]) maxCpuIndex = i;
        }

        int increaseMemory = 1;
        int lastIndex = 0;

        for (int i = 0; i < usedMemory.length; i++) {

            if (usedMemory[i] == null) {
                memoryNull++;
                continue;
            }

            if (usedMemory[i] >= 19661) {
                rules[2] = true;
            }

            if (i > 0 && usedMemory[i - 1] != null && usedMemory[i] > usedMemory[i - 1]) {
                if (lastIndex == i - 1) {
                    increaseMemory++;
                } else increaseMemory = 1;

                lastIndex = i;

                if (increaseMemory == 3) rules[3] = true;
            }

            if (usedMemory[i] != null && usedMemory[maxMemoryIndex] !=null && usedMemory[i] > usedMemory[maxMemoryIndex]){
                maxMemoryIndex = i;
            }
        }

        if (cpuUsage.length > 1 && usedMemory.length > 1 && maxMemoryIndex == maxCpuIndex) rules[1] = true;


        if (cpuNull > cpuUsage.length * 0.3) {
            rules[0] = true;
            rules[1] = true;
        }

        if (memoryNull > usedMemory.length * 0.25) {
            rules[2] = true;
            rules[3] = true;
        }

        int ruleCount = 0;

        for (int i = 0; i < 7; i++) {
            if (rules[i]) ruleCount++;
        }

        if (ruleCount > 1) return "red";
        if (ruleCount == 1) return "yellow";
        return "green";
    }

    public static void main(String[] args) {
        Float[] cpuUsage = {0.3f};
        Integer[] usedHeap = {3000};
        System.out.println(verify(cpuUsage, usedHeap));
    }
}
