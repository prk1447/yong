package report.parkyongseong.r0005;

public class Exam 
{
	
	public static void main(String[] args)
	{
		int num1 = 10;
		int num2 = 2;
		//더하기
		Cal cal = new Cal(num1, num2, "+");
		cal.printCal();
		//빼기
		cal = new Cal(num1, num2, "-");
		cal.printCal();
		//곱하기
		cal = new Cal(num1, num2, "*");
		cal.printCal();
		//나누기
		cal = new Cal(num1, num2, "/");
		cal.printCal();
		
		
		
		Robot bot = new Robot("지로봇", 10);
		bot.doKick();
		bot.doChange();
		bot.doRun();
	}
}
