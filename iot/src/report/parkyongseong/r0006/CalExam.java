package report.parkyongseong.r0006;

import java.util.Scanner;

public class CalExam
{
	//반복문을 사용하여 Scanner클래스를 이용해
	//총 10명의 학생의 점수를 받아주세요
	//10명의 학생의 총점과 평균을 구해주세요
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("학생 수를 입력해 주세요 : ");
		String input1 = scanner.nextLine();
		int num1 = Integer.parseInt(input1);
		int[] people = new int[num1];
		
		//총 학생의 점수를 담을 변수
		int sumNum = 0;
		
		for(int i = 0; i < people.length; i++)
		{
			System.out.print((i + 1) + "번째 학생의 점수를 입력해 주세요 : ");
			String input2 = scanner.nextLine();
			people[i] = Integer.parseInt(input2);
			sumNum += people[i];
		}
		
		System.out.println(people.length + " 명의 학생 총점 값은 = " + (sumNum));
		System.out.println(people.length + " 명의 학생 평균 값은 = " + (sumNum / people.length));
		
		int temp = 0;
		
		for(int i = 0; i < people.length; i++)
		{
			for(int j = (i + 1); j < people.length; j++)
			{
				if(people[i] > people[j])
				{
					temp = people[i];
					people[i] = people[j];
					people[j] = temp;
				}
			}
			System.out.println("내림차순정렬 점수 :  " + people[i]);
		}
	
	}
}
