package com.prep.arrays;

public class LargestPrimeNo {

  public static void solve(long no) {
    
    long maxPrime = -1; 
    
    while(no % 2 == 0) {
      maxPrime = 2;
      no >>=1;
    }
    
    for(int i=3; i<=Math.sqrt(no); i+=2) {
      while(no % i == 0) {
        maxPrime = i;
        no = no /i;
      }
    }
    
    if (no > 2) maxPrime = no;
    
    System.out.println(maxPrime);
  }
  
  
  public static void main(String[] args) {
    solve(600851475143l);
  }
}
