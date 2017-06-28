package report.parkyongseong.r0003;

public class ArrayExam6 
{
	public static void main(String[] args)
	{
		int[] a = new int[6];
		int count = 0;
		
		for(int i = 0; i < 6; i++)
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
			} // for(j) end
			
			if(count == 2)
			{
				System.out.println("중복 되었습니다 : " + a[i]);
			}
			else
			{
				count = 0;
			}
		}//for(i) end
	}
}