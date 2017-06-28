package report.parkyongseong.r0009;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ListExam3 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		ArrayList<HashMap<String, Object>> arrList = new ArrayList<HashMap<String, Object>>();
		System.out.print("사람 수를 입력해 주세요 : ");
		String input = scanner.nextLine();
		int person = Integer.parseInt(input);
		
		String[] gender = new String[person];
		String[] name = new String[person];
		int[] age = new int[person];
		for(int i = 0; i < person; i++)
		{
			HashMap<String, Object> hm = new HashMap<String, Object>();
			System.out.print("이름을 입력해 주세요 : ");
			name[i] = scanner.nextLine();
			System.out.print("나이를 입력해 주세요 : ");
			age[i] = Integer.parseInt(scanner.nextLine());
			System.out.print("성별을 입력해 주세요 : ");
			gender[i] = scanner.nextLine();
			hm.put("name", name[i]);
			hm.put("age", age[i]);
			hm.put("gender", gender[i]);
			arrList.add(hm);
		}
		
		for(int i = 0; i < person; i++)
		{
			System.out.println(arrList.get(i));
		}
	}
}
