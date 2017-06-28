package report.parkyongseong.r0011;

import java.util.Scanner;

public class ExceptionExam2 
{
	/*		10개의 방을 가지고 있는 int 형 배열변수 arrNum을
	 * 		ExceptionExam2의 맴버 변수로 선언해주세요
	 * 		for문을 돌며 Scanner 클래스의 nextLine()함수를 사용하여 아무런 값이나 입력해주세요.
	 * 		단 for문을 돌며 문자값이 입력됬을때 에러메세지를 나오게 해주세요.
	 */
	Scanner scan;
	int[] arrNum;
	String str;
	
	ExceptionExam2()
	{
		scan = new Scanner(System.in);
		printScanner();
		arrNum = new int[Integer.parseInt(str)];
	}
	
	void printScanner()
	{
		System.out.print("반복문을 몇번 돌고 싶은지 입력해 주세요 : ");
		str = scan.nextLine();
	}
	
	public static void main(String[] args)
	{
		ExceptionExam2 ee2 = new ExceptionExam2();
		for(int i = 0; i < ee2.arrNum.length; i++)
		{
			try
			{
				System.out.print((i + 1) + "번째 숫자를 입력해 주세요 : ");
				ee2.arrNum[i] = Integer.parseInt(ee2.scan.nextLine());
			}
			catch(Exception e)
			{
				System.out.println("문자가 찍혓어요");
				i--;
			}
		}
		
		for(int i = 0; i < ee2.arrNum.length; i++)
		{
			System.out.println(ee2.arrNum[i]);
		}
		
	}
}
