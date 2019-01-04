package com.prep.string;

public class RabinKarpAlorithm {

  public final static int noOfChars = 256;

  static void search(String pat, String txt, int q) {
    int i, j;
    int p = 0; // hash value for pattern
    int t = 0; // hash value for txt
    int h = 1;

    for (i = 0; i < pat.length(); i++)
      h = (h * noOfChars) % q;
  }
}
