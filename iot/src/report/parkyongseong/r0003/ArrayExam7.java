package report.parkyongseong.r0003;

public class ArrayExam7 
{
	public int[] function(int initNum, int maxNum)
	{
		int[] a = new int[maxNum];
		for(int i = initNum; i <= maxNum; i++)
		{
			a[maxNum - i] = i * 2;
		}
		return a;
	}
	
	public void printArrVar(int[] a)
	{
		for(int i = 1; i < (a.length + 1); i++)
		{
			System.out.println(a[i - 1]);
		}
	}
	
	public void randomFunction(int maxNum)
	{
		int[] a = new int[maxNum];
		int count = 0;
		
		for(int i = 0; i < maxNum; i++)
		{
			int random = (int)(Math.random()*45)+1;
			a[i] = random;
			System.out.println((i + 1) + "번째 로또 번호 = " + a[i]);
			for(int j = i; j >= 0; j--)
			{
				if(a[i] == a[j])
				{
					count++;
				}
			}
			
			if(count == 2)
			{
				System.out.print("중복 되었습니다 : " + a[i]);
			}
			else
			{
				count = 0;
			}
		}
	}
	
	public static void main(String[] args)
	{
		ArrayExam7 ae7 = new ArrayExam7();
		int[] a = ae7.function(1, 10);
		ae7.printArrVar(a);
		ae7.randomFunction(6);
	}
}
