package report.parkyongseong.r0005;

import java.util.Scanner;

public class Cal2 
{
	int num1;
	int num2;
	String operator;
	
	Cal2(int num1, int num2, String operator)
	{
		this.num1 = num1;
		this.num2 = num2;
		this.operator = operator;
	}
	
	void printPlus()
	{
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
	}
	
	void printMinus()
	{
		System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
	}
	
	void printMultiple()
	{
		System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
	}
	
	void printDivision()
	{
		System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
	}
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자를 입력해 주세요 : ");
		String input1 = scanner.nextLine();
		int num1 = Integer.parseInt(input1);
		
		System.out.print("연산자 입력해 주세요 : ");
		String operator = scanner.nextLine();
		
		System.out.print("숫자를 입력해 주세요 : ");
		String input3 = scanner.nextLine();
		int num2 = Integer.parseInt(input3);
		
		Cal2 cal2 = new Cal2(num1, num2, operator);
		
		if(cal2.operator.equals("+"))
		{
			cal2.printPlus();
		}
		else if(cal2.operator.equals("-"))
		{
			cal2.printMinus();
		}
		else if(cal2.operator.equals("*"))
		{
			cal2.printMultiple();
		}
		else if(cal2.operator.equals("/"))
		{
			cal2.printDivision();
		}
		else
		{
			System.out.println("연산자를 잘못 입력하셨네요.");
		}
	}
}
