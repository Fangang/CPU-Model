//CPU模拟器

public class CPUTest {

	public static void main(String[] args) {
		System.out.println("CPUTest Main");
		
		//CPU寄存器分配
		int[] registers = new int[32];
		//CPU栈分配
		Stack s = new Stack();
		
		CPU cpu = new CPU(registers,s,0);
		//(+ (+ (+ 4 1) 1) (+ 4 1)) = (+ (+ 5 1) 5) = (+ 6 5) = 11
		Expr Exp1 = new Expr('+',0,0);
		Expr Exp2 = new Expr('+',0,1);
		Expr Exp3 = new Expr('+',4,1);
		Exp1.lExpr = Exp2;
		Exp1.rExpr = Exp3;
		Exp2.lExpr = Exp3;
		Exp2.rExpr = null;
		Exp3.lExpr = null;
		Exp3.rExpr = null;
		
		cpu.Robot(Exp1);//CPU开始表达式运算
		
		int result = cpu.getReg(1);//外部接口，寄存器Index以1为始,运算式最后结果存储于寄存器1
		result = cpu.getReg(1);
		System.out.println(result);
	}
	
}
