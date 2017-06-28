package report.parkyongseong.r0003;

public class ArryExam4 
{
	public static void main(String[] args)
	{
		int[] a = new int[10];
		
		for(int i = (a.length - 1); i >= 0; i--)
		{
			a[i] = (i + 1) * 2;
			System.out.println("a의" + (9 - i) + "번쨰 방의 값은 = " + a[i]);
		}
	}
}
