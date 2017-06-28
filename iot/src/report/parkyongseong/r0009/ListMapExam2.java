package report.parkyongseong.r0009;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ListMapExam2 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		ArrayList<HashMap<String, Integer>> arrList = new ArrayList<HashMap<String, Integer>>();
		System.out.print("학생수를 입력해 주세요 : ");
		String input = scanner.nextLine();
		int student = Integer.parseInt(input);
		int sumNum = 0;
	
		
		int[] score = new int[student];
		for(int i = 0; i < student; i++)
		{
			HashMap<String, Integer> hm = new HashMap<String, Integer>();
			System.out.print((i + 1) + "번 점수를 입력해 주세요 : ");
			String inputNum = scanner.nextLine();
			score[i] = Integer.parseInt(inputNum);
			sumNum += score[i];
			hm.put((i + 1) + "번 점수 ", score[i]);
			arrList.add(hm);
		}
		
		for(int i = 0; i < arrList.size(); i++)
		{
			System.out.println(arrList.get(i));
		}
		
		System.out.println(student + "명의 총 점수는 : " + sumNum);
		System.out.println(student + "명의 평균 점수는 : " + (sumNum / student));
		
		
	}
}
