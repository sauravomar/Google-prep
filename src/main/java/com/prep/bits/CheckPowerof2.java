package com.prep.bits;

public class CheckPowerof2 {
	
	public boolean isPowerof2(int v){
		return v!=0 && (v & (v-1)) == 0;
	}
	
	public static void main(String[] args) {
		System.out.println(new CheckPowerof2().isPowerof2(31));
	}
}
