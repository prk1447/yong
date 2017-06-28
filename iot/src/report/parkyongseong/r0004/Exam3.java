package report.parkyongseong.r0004;



public class Exam3 
{
	int a = 0;
	int b = 0;
	int result = 0;
	public Exam3(){
		this.result  = 0;
	}
	public Exam3(int a, int b){
		this.a = a;
		this.b = b;
		this.result = this.a + this.b;
	}
	
	public static void main(String[] args)
	{
		Exam3 ex3 = new Exam3();
		System.out.println(ex3.a);
		int a = 4;
		System.out.println(a);
	}
}
