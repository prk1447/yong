package report.parkyongseong.r0004;

public class Exam 
{
	public void printPlusResult(int a, int b)
	{
		System.out.println("더한 결과 값 : " + (a + b));
	}
	
	public int getPlusResult(int a, int b)
	{
		return a + b;
	}
	
	public static void main(String[] args)
	{
		Exam ex = new Exam();
		ex.printPlusResult(1, 3);
		int result = ex.getPlusResult(1, 6);
		System.out.println("더한 결과 값 : " + result);
	}
}
