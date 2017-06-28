package report.parkyongseong.r0010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/*		HashMap을 상속받아주세요
 * 		키타입 String, 벨류타입 Integer로 선언해주세요
 * 		키는 아무거나 넣으셔도 되지만 벨류는 반드시 숫자만 입력하셔야 합니다.
 * 		총 10개의 키값을 생성해주세요
 * 		toString()함수를 오버라이딩 하여서
 * 		해당해쉬맵이 가지고있는 전체 숫자를 더한값을 출력해주세요
 */
public class MapExam2 extends HashMap<String, Integer>
{

	public String toString()
	{
		String result = "";
		List<String> keyList = new ArrayList<>(keySet());
		int sum = 0;
		for(int i = 0; i < keyList.size(); i++)
		{
			String key = keyList.get(i);
			Integer value = (int)get(key);
			sum += value;
		}
		result = "value 값을 총 더한 값은 = " + sum;
		return result;
	}
	
	public static void main(String[] args)
	{
		MapExam2 me2 = new MapExam2();
		String[] str = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
		//int sum = 0;
		for(int i = 0; i < str.length; i++)
		{
			me2.put(str[i], ((i + 1) * 10));
			//sum += me2.get(str[i]);
		}
		//System.out.println(sum);
		System.out.println(me2);
		
		/*
		for(int i = 0; i < me2.size(); i++)
		{
			System.out.println(me2.get(str[i]));
		}
		*/
	}
}
