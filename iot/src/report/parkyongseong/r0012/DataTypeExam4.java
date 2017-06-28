package report.parkyongseong.r0012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public final class DataTypeExam4 
{
	Scanner scanner = new Scanner(System.in);
	
	public HashMap<Object, Object> getHashMap()
	{
		HashMap<Object, Object> hm = new HashMap<Object, Object>();
		System.out.print("클래스를 입력해 주세요 : ");
		hm.put("클래스", scanner.nextLine());
		System.out.print("이름을 입력해 주세요 : ");
		hm.put("이름", scanner.nextLine());
		System.out.print("나이를 입력해 주세요 : ");
		hm.put("나이", scanner.nextLine());
		System.out.print("성별을 입력해 주세요 : ");
		hm.put("성별", scanner.nextLine());
		
		return hm;
	}
	
	
	
	public static void main(String[] args)
	{
		ArrayList<HashMap<Object, Object>> al = new ArrayList<HashMap<Object, Object>>();
		DataTypeExam4 dte4 = new DataTypeExam4();
		
		for(int i = 0; i < 5; i++)
		{
			al.add(dte4.getHashMap());
		}
		
		for(int i = 0; i < al.size(); i++)
		{
			HashMap<Object, Object> result = al.get(i);
			System.out.print(result.get("클래스") + ",");
			System.out.print(result.get("이름") + ",");
			System.out.print(result.get("나이") + ",");
			System.out.println(result.get("성별"));
		}	
	}
}
