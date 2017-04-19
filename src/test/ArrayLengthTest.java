package test;

public class ArrayLengthTest {
	public static void main(String[] agrs){
		int[] ar = {1,5,6,4,6,4,2,8,3};
		System.out.println(ar[8]);
		int[] ar2 = new int[ar.length + 1];
		System.out.println(ar2.length);
		ar2 = ar;
		System.out.println(ar2.length);
		ar[9] = 1;
		
	}

}
