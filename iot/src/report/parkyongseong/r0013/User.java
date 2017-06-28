package report.parkyongseong.r0013;

public class User 
{
	private InterfaceExam ie;
	
	User(String operator)
	{
		if(operator.equals("+"))
		{
			ie = new Plus();
		}
		else if(operator.equals("-"))
		{
			ie = new Minus();
		}
		else if(operator.equals("*"))
		{
			ie = new Multiple();
		}
		else if(operator.equals("/"))
		{
			ie = new Division();
		}
		else
		{
			System.out.println("연산자가 잘못 입력되었습니다.");
		}
	}
	
	public InterfaceExam getInterfaceExam()
	{
		return ie;
	}
	
	public static void main(String[] args)
	{
		User u = new User("*");
		InterfaceExam ie = u.getInterfaceExam();
		int result = ie.cal(3, 5);
		System.out.println(result);
		
		u = new User("/");
		ie = u.getInterfaceExam();
		result = ie.cal(6, 2);
		System.out.println(result);
	}
}
