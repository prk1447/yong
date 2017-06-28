package report.parkyongseong.r0008;

import report.parkyongseong.r0007.Exam11;

public class Exam12 extends Exam11
{
	Exam12(int a, int b)
	{
		super(a, b);
		this.a = a;
		this.b = b;
	}
	public static void main(String[] args)
	{
		Exam12 ex12 = new Exam12(12, 5);
		ex12.getGub();
		ex12.printResult();
		ex12.getNa();
		ex12.printResult();
		ex12.getSum();
		ex12.printResult();
		ex12.getMinus();
		ex12.printResult();
	}
}
