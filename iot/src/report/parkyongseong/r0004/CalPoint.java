package report.parkyongseong.r0004;

import java.util.Scanner;

public class CalPoint 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String input1 = "";
		int[] people = new int[6];		//학생 수를 넣을 변수
		int addNum = 0;					//총점 값을 넣을 변수
		int temp = 0;					//임시로 값을 저장할 변수
		
		for(int i = 0; i < people.length; i ++)
		{
			System.out.print((i + 1) + "번 학생의 성적을 적어 주세요 : ");
			input1 = scanner.nextLine();
			people[i] += Integer.parseInt(input1);
			addNum += people[i];
			
		}
		
		
		System.out.println(people.length + "명 학생의 총점 : " + addNum);
		System.out.println(people.length + "명 의 평균 : " + (addNum / people.length));
		
		for(int i = 0; i < people.length; i++)
		{
			for(int j = (i + 1); j < people.length; j++)
			{
				if(people[i] < people[j])
				{
					temp = people[i];
					people[i] = people[j];
					people[j] = temp;
				}
			}
			System.out.println(people[i]);
		}
		
		
	}
}
