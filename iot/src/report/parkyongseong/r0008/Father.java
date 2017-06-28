package report.parkyongseong.r0008;

import java.util.Scanner;

public class Father 
{
	int a = 3;
	int result = 0;
	int temp = 0;
	int[] student;
	Scanner scan;
	String str1, str2;
	
	Father()
	{
		scan = new Scanner(System.in);
	}
	
	Father(int a)
	{
		
	}
	
	void printFromInput1()
	{
		str1 = scan.nextLine();
	}
	
	void printFromInput2()
	{
		str2 = scan.nextLine();
	}
	
	void shuffle(int initNum, int maxNum)
	{
		for(int i = initNum; i <= maxNum; i++)
		{
			result = i;
			System.out.println(result);
		}
	}
	//-------------------------------------------------------------------
	void printPeopleNum()
	{
		System.out.print("학생수를 입력해주세요 : ");
		str1 = scan.nextLine();
	}
	
	void peopleScore(int initNum)
	{
		student = new int[initNum];
		for(int i = 0; i < initNum; i++)
		{
			System.out.print("[" + (i + 1) + "]" + "번째 학생의 점수를 입력해주세요 : ");
			str2 = scan.nextLine();
			student[i] = Integer.parseInt(str2);
			result += student[i];
		}
		System.out.println("학생들의 총점 값은 = " + result);
		System.out.println("학생들의 평균 값은 = " + (result / student.length));
	}
	
	void peopleScoreRange()
	{
		for(int i = 0; i < student.length; i++)
		{
			for(int j = (i + 1); j < student.length; j++)
			{
				if(student[i] < student[j])
				{
					temp = student[i];
					student[i] = student[j];
					student[j] = temp;
				}
			}
			System.out.println("[" + (i + 1) + "]" + "등의 점수는 = " + student[i]);
		}
	}
}
