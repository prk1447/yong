package report.parkyongseong.r0005;

public class Exam2
{
	public static void main(String[] args)
	{
		Cal[] cal = new Cal[5];
		
		for(int i = 0; i <= 4; i++)
		{
			cal[i] = new Cal(i + 1);
		}
		
		for(int i = 0; i <= 4; i++)
		{
			System.out.println(cal[i].num1);
		}
		
	}
}
