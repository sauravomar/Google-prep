package main.arrays;

public class RotateArray {

    public void rotate(int [] arr)
    {
        int x = arr[arr.length-1], i;
        for (i = arr.length-1; i > 0; i--)
            arr[i] = arr[i-1];
        arr[0] = x;
    }
}
