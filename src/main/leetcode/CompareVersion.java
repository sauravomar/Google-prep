package main.leetcode;

public class CompareVersion {

    public int compareVersion(String version1, String version2) {

        if(version1 == null )return -1;
        if(version2 == null) return 1;
        if(version1 == null && version2 == null) return 0;

        String [] str1 = version1.split("\\.");
        String [] str2 = version2.split("\\.");

        int itertor = 0;

        while (itertor < str1.length && itertor< str2.length){

            if(Integer.parseInt(str1[itertor]) > Integer.parseInt(str2[itertor])){
                return  1;
            }else if(Integer.parseInt(str1[itertor]) <Integer.parseInt(str2[itertor])){
                return -1;
            }else{
                itertor ++;
            }
        }

        while( itertor < str1.length){
            if(Integer.parseInt(str1[itertor])!=0) return 1;
            itertor++;
        }

        while( itertor < str2.length){
            if(Integer.parseInt(str2[itertor])!=0) return -1;
            itertor++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new CompareVersion().compareVersion("1","1.1"));
    }
}
