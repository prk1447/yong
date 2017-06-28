package report.parkyongseong.r0003;

public class ArrayExam5 
{
	public static void main(String[] args)
	{
		int[] a = new int[10];
	
		for(int i = (a.length - 1); i >= 0; i--)
		{
			a[i] = (i + 1);
			System.out.println("a의" + (9 - i) + "번째 방의 값은 = " + a[i]);
		}
	}
}
