package main.leetcode;

public class Pallindrome {

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]","").replaceAll("\\s+","");
        return checkPallindrome(s.toLowerCase().toCharArray());
    }

    public boolean checkPallindrome(char str[])
    {
        // Start from leftmost and rightmost corners of str
        int l = 0;
        int h = str.length- 1;

        // Keep comparing characters while they are same
        while (h > l)
        {
            if (str[l++] != str[h--])
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Pallindrome().isPalindrome("ab#a"));
    }
}


