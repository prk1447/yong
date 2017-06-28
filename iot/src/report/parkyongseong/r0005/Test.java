package report.parkyongseong.r0005;

public class Test
{
	public static void main(String[] args)
	{
		Cal cal = new Cal(10, 1 , "+");
		cal.printCal();
		cal = new Cal(9, 2, "+");
		cal.printCal();
		cal = new Cal(8, 3, "+");
		cal.printCal();
		cal = new Cal(7, 4, "+");
		cal.printCal();
		
		for(int i = 1; i <= 10; i++)
		{
			cal = new Cal(i, (11 - i), "+");
			cal.printCal();
		}
	}
}
