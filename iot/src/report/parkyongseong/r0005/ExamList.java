package report.parkyongseong.r0005;

import java.util.ArrayList;
import java.util.List;

public class ExamList 
{
	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < 3; i++)
		{
			int num1 = i;
			list.add(num1);
		}
		
		for(int i = 0; i < 10; i++)
		{
			list.add(i);
			System.out.println(list.get(i));
		}
		
		System.out.println(list.size());

	}
}
