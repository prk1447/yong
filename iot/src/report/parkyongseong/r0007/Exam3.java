package report.parkyongseong.r0007;

import report.parkyongseong.r0006.RExam2;

public class Exam3
{
	//r0006 패키지에 있는 RExam2의 변수의 값을 변환하고 출력해주세요
	//단 RExam2의 변수의 접근제어자를 바꾸시면 안됩니다.
	//함수를 선언하여 해당 문제를 풀어주시기 바랍니다.
	public static void main(String[] args)
	{
		RExam2 re2 = new RExam2();
		re2.setA(5);
		System.out.println(re2.getA());
		re2.setB(8);
		System.out.println(re2.getB());
	}
}
