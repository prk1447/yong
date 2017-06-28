package report.parkyongseong.r0002;

public class Test1 
{
	public int[] getArrayVar(int initNum, int maxNum)
	{
		int[] a = new int[maxNum - initNum];
		for(int i = (initNum - initNum); i < (maxNum - initNum); i++)
		{
			a[i] = i + 1;
		}
		return a;
	}
	
	public void printArrayVar(int[] a)
	{
		for(int i = (a.length - 1); i >= 0; i--)
		{
			System.out.println("a의" + i + "번째 방의 값 = " + a[i]);
		}
	}
	
	public static void main(String[] args)
	{
		Test1 t1 = new Test1();
		
		int[] a = t1.getArrayVar(1, 5);
		t1.printArrayVar(a);
	}
}
