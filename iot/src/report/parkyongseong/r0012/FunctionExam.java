package report.parkyongseong.r0012;

import java.util.Scanner;

public class FunctionExam 
{
	int arrNum[] = new int[5];
	Scanner scanner = new Scanner(System.in);
	int result = 0;
	
	int getNumberFromString()
	{
		try
		{
			System.out.println(result + "번째 숫자를 입력해 주세요 : ");
			result++;
			return Integer.parseInt(scanner.nextLine());
		}
		catch(Exception e)
		{
			System.out.println("문자열이 입력되었습니다.");
			result--;
			return getNumberFromString();
		}
	}
	
	public static void main(String[] args)
	{
		FunctionExam ee2 = new FunctionExam();
		for(int i = 0; i< ee2.arrNum.length; i++)
		{
			ee2.arrNum[i] = ee2.getNumberFromString();
		}
		
		for(int i = 0; i < ee2.arrNum.length; i++)
		{
			System.out.println(ee2.arrNum[i]);
		}
		
	}
	
	
	
}
