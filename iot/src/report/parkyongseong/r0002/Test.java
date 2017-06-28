package report.parkyongseong.r0002;

import java.util.Scanner;

public class Test 
{
	public void gugudan(int initNum, int maxNum)
	{
		for (int i = initNum; i <= maxNum; i++)
		{
			int j = initNum;
			for(j = initNum; j <= (maxNum - 1); j++)
			{
				System.out.print(j + " x " + i + " = " + (i*j) + ", ");
			}
			System.out.println(j + " x " + i + " = " + (i*j));
		}
		
	}
	
	public static void main(String[] args)
	{	
		Scanner scanner = new Scanner(System.in);
		Test t = new Test();
		
		System.out.print("구구단 시작값을 입력해 주세요 : ");
		String input1 = scanner.nextLine();
		int initNum = Integer.parseInt(input1);
		
		System.out.print("몇단까지 하고싶은지 입력해 주세요 : ");
		String input2 = scanner.nextLine();
		int maxNum = Integer.parseInt(input2);
		
		t.gugudan(initNum, maxNum);
		/*
		for(int i = 1; i <= 9; i++)
		{
			int j = 0;
			for(j = 1; j <= 8; j++)
			{
				System.out.print(j + " X " + i + " = " + (i*j) + " ,");
			}
			System.out.println(j + " X " + i + " = " + (i*j));
		}
		*/
	}
}
