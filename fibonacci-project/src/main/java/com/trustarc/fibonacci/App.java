package com.trustarc.fibonacci;

/**
 * Hello world!
 *
 */
public class App 
{
	static int n1=0,n2=1,n3=0;
	static boolean printFibonacci(int count) {
		if(count>0) {
			n3 = n1+n2;
			n1 = n2;
			n2 = n3;
			System.out.print(" "+n3);
			printFibonacci(count-1);
		}
		return true;
	}
    public static void main( String[] args )
    {
    	int count=0;
    	java.util.Scanner sc = new java.util.Scanner(System.in);
    	System.out.println( "Enter Range:");
    	while(!sc.hasNextInt()) {
    		sc.nextLine();
    		System.out.println( "Please enter only numbers:");
    	}
    	count = sc.nextInt();
    	System.out.print(n1+" "+n2);
    	printFibonacci(count-2);
//    	for(int i = 0; i < count; i++) {
//    		n3 = n1+n2;
//			n1 = n2;
//			n2 = n3;
//			System.out.print(" "+n3);
//    	}
    	sc.close();
    }
}
