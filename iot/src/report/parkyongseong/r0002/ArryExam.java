package report.parkyongseong.r0002;

public class ArryExam 
{
	public void gugudan(int[] a, int[] b)
	{
		for(int i = 0; i < a.length; i++)
		{
			
			for(int j = 0; j < b.length; j++)
			{
				System.out.print(a[i] + " X " + b[j] + " = " + (a[i]*b[j]) + " ,");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		ArryExam ae = new ArryExam();
		int[] a = {1,2,3,4,5,6,7,8,9};
		int[] b = {1,2,3,4,5,6,7,8,9};
		
		ae.gugudan(a, b);
	}
}
