package report.parkyongseong.r0013;

public class Minus implements InterfaceExam
{
	@Override
	public String getString() 
	{
		return "Minus의 getString()함수 호출";
	}
	
	@Override
	public void setString(String str)
	{
		System.out.println("Minus 의 setString()함수 호출" + str);
	}

	@Override
	public int cal(int a, int b) 
	{
		return (a - b);
	}
}
