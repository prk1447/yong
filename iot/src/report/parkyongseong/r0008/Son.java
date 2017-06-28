package report.parkyongseong.r0008;

public class Son extends Father
{
	//아빠 클래스에서 값을 str1, str2를 Scanner클래스의 nextLine()함수를 사용하여 값을 입력받아 주세요.
	//숫자값을 입력받아 정수로 변환해 주시고
	//첫번째 값은 반복문의 초기값 두번째값은 반복문의 맥스값
	//반복문만큼 i의 값을 출력하는 함수를 아빠 클래스에 선언해주시고
	//아들클래스에서 호출하여 결과값을 나타내주세요
	
	Son()
	{
		
	}
	
	Son(int a)
	{
		
	}
	
	public static void main(String[] args)
	{
		//문제
		Son s = new Son();
		s.printFromInput1();
		s.printFromInput2();
		int initNum = Integer.parseInt(s.str1);
		int maxNum = Integer.parseInt(s.str2);
		s.shuffle(initNum, maxNum);
		
		System.out.println("----------------------------------------------------------");	
		//학생 평균
		s = new Son();
		s.printPeopleNum();
		initNum = Integer.parseInt(s.str1);
		s.peopleScore(initNum);
		s.peopleScoreRange();
	}
}
