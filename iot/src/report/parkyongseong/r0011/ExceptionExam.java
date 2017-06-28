package report.parkyongseong.r0011;

import java.util.Scanner;

public class ExceptionExam 
{
	/*		ExceptionExam1의 맴버 변수로 int num1, num2를 선언해주세요
	 * 		맴버변수 num1, num2의 값을 계산하여 int값을 리턴하는
	 * 		plus(), minus(), mutiple(), division() 함수를 4개 선언하여 이름에 맞게 연산하여 리턴해주세요
	 * 		Scanner 클래스의 nextLine()함수를 사용하여 num1의 값과 num2값을 대입해주세요
	 * 		숫자값을 입력하지 않았을때는 Exception에서 "숫자를 입력해야지!!!"라는 문자열이 나와야 합니다.
	 * 		정상적으로 숫자값을 입력했다면
	 * 		위에 선언한 4개의 함수를 호출하여 값을 받아 출력하는 예제를 작성해 주시기 바랍니다
	 */
	int num1 = 0;
	int num2 = 0;
	
	int plus()
	{
		return (num1 + num2);
	}
	
	int minus()
	{
		return (num1 - num2);
	}
	
	int mutiple()
	{
		return (num1 * num2);
	}
	
	int division()
	{
		return (num1 / num2);
	}
	
	public static void main(String[] args)
	{
		try
		{
			Scanner scanner = new Scanner(System.in);
			ExceptionExam ee = new ExceptionExam();
			System.out.print("숫자 두개를 입력해주세요 : ");
			String input1 = scanner.nextLine();
			String input2 = scanner.nextLine();
			ee.num1 = Integer.parseInt(input1);
			ee.num2 = Integer.parseInt(input2);
			
			System.out.println("더한값 = " + ee.plus());
			System.out.println("뺀 값 = " + ee.minus());
			System.out.println("곱한 값 = " + ee.mutiple());
			System.out.println("나눈 값 = " + ee.division());
		}
		catch(Exception e)
		{
			System.out.println("숫자를 입력해야지!!");
		}
		finally
		{
			System.out.println("오류가 나든 나지 않든 실행");
		}
	}
}
