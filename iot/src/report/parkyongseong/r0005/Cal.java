package report.parkyongseong.r0005;

public class Cal 
{
	int num1;
	int num2;
	String str;
	
	Cal()
	{
		
	}
	
	Cal(int num1)
	{
		System.out.println(num1 + " 인트형 변수 파라메터 한개를 가진 생성자를 호출하셨네요 !");
		this.num1 = num1;
	}
	
	Cal(int num1, int num2, String str)
	{
		this.num1 = num1;
		this.num2 = num2;
		this.str = str;
	}
	
	void printPlus()
	{
		System.out.println(num1 + " + " + num2 + " = " +(num1 + num2));
	}
	
	void printCal()
	{
		if(str.equals("+"))
		{
			System.out.println(num1 + " + " + num2 + " = " +(num1 + num2));
		}
		else if(str.equals("-"))
		{
			System.out.println(num1 + " - " + num2 + " = " +(num1 - num2));
		}
		else if(str.equals("*"))
		{
			System.out.println(num1 + " * " + num2 + " = " +(num1 * num2));
		}
		else if(str.equals("/"))
		{
			System.out.println(num1 + " / " + num2 + " = " +(num1 / num2));
		}
		else
		{
			System.out.println("연산자를 잘못 입력 하셧습니다.");
		}
	}

	public static void main(String[] args)
	{
		Cal cl = new Cal(2, 4, "*");
		cl.printPlus();
		cl.printCal();
	}
}
