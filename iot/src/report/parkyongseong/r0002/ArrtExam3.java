package report.parkyongseong.r0002;

import java.util.Scanner;

public class ArrtExam3 
{
	public int[] getArryVar(int initNum, int maxNum)
	{
		int[] a = new int[maxNum];
		
		for(int i = (initNum - initNum); i <= (maxNum - initNum); i++)
		{
			a[i] = i + 1; 
		}
		return a;
	}
	
	public void printArrayVar(int[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			System.out.println(a[i]);
		}
	}
	
	public static void main(String[] args)
	{
		ArrtExam3 ae3 = new ArrtExam3();
		Scanner scanner = new Scanner(System.in);
		
		String input1 = scanner.nextLine();
		int initNum = Integer.parseInt(input1);
				
		String input2 = scanner.nextLine();
		int maxNum = Integer.parseInt(input2);
		
		int[] a = ae3.getArryVar(initNum, maxNum);
		ae3.printArrayVar(a);
		/*
		for(int i = (initNum - initNum); i <= (maxNum - initNum); i++)
		{
			System.out.println(a[i]);
		}
		*/
	}
}
