package report.parkyongseong.r0009;

import java.util.ArrayList;
import java.util.Collections;

public class ListExam 
{
	public static void main(String[] args)
	{
		/*
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i = 0; i <= 10; i++)
		{
			al.add(i);
			System.out.println(al.get(i));
		}
		*/
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for(int i = 4; i >= 0; i--)
		{
			arrList.add(((int)(Math.random() * 45) + 1));
		}
		
		/*
		for(int i = 0; i < arrList.size(); i++)
		{
			System.out.println(arrList.get(i));
		}
		*/
		
		Collections.sort(arrList);
		
		for(int i = 0; i < arrList.size(); i++)
		{
			System.out.println(arrList.get(i));
		}
		
	}
}
