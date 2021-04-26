package main.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class FunctionInfo {
    String name;
    String type;
    int time;

    public FunctionInfo(String name, String type, int time) {
        this.name = name;
        this.type = type;
        this.time = time;
    }
}

class FunctionTim {
    String name;
    int timeTaken;

    public FunctionTim(String name, int time) {
        this.name = name;
        this.timeTaken = time;
    }

}

public class FunctionTimeTaken {


    public List<FunctionTim> timeTaken(List<FunctionInfo> list) throws Exception {
        List<FunctionTim> result = new ArrayList<>();

        if (list.size() == 0) return result;

        Stack<FunctionInfo> stack = new Stack<>();

        int timeTaken = 0;

        for (int i = 0; i < list.size(); i++) {
            FunctionInfo functionInfo = list.get(i);
            if (functionInfo.type == null) {
                throw new Exception("In valid type");
            }
            if (functionInfo.type.equalsIgnoreCase("start")) {
                stack.push(functionInfo);
            } else {
                FunctionInfo poppedObj = stack.pop();
                if (poppedObj.name.equalsIgnoreCase(functionInfo.name)) {
                    int functionTime = functionInfo.time - poppedObj.time;

                    if (poppedObj.name.equalsIgnoreCase(list.get(i - 1).name)) {
                        result.add(new FunctionTim(functionInfo.name,
                                functionTime));
                    } else {
                        result.add(new FunctionTim(functionInfo.name,
                                functionTime - timeTaken));
                    }
                    timeTaken = timeTaken + functionInfo.time - poppedObj.time;

                } else {
                    throw new Exception("In valid sequence");
                }
            }
        }
        return result;
    }


    public static void main(String[] args) throws Exception {
        // you can write to stdout for debugging purposes, e.g.
        System.out.println("This is a debug message");
        FunctionTimeTaken obj = new FunctionTimeTaken();
        List<FunctionInfo> list = new ArrayList<>();

        list.add(new FunctionInfo("f1", "start", 10));
        list.add(new FunctionInfo("f2", "start", 30));
        list.add(new FunctionInfo("f4", "start", 40));
        list.add(new FunctionInfo("f4", "end", 50));
        list.add(new FunctionInfo("f2", "end", 60));
        list.add(new FunctionInfo("f3", "start", 60));
        list.add(new FunctionInfo("f3", "end", 80));
        list.add(new FunctionInfo("f1", "end", 100));

        obj.timeTaken(list);

    }
}

