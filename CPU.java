
public class CPU {
	public CPU(int[] reg,Stack s,int index)
	{
		this.reg = reg;
		this.s = s;
		this.index = index;  //暂时没有溢出错误控制
	}
	//将变量存储于寄存器内
	public int storeReg(int num)
	{
		reg[index] = num;
		return ++index;  //注意Index的变化
	}
	//CPU内部表达式运算机制
	public void Robot(Expr expr)
	{
		if(expr.lExpr == null && expr.rExpr == null)
		{
			//迭代运算
			storeReg(expr.getA());
			storeReg(expr.getB());
			storeReg(reg[--index] + reg[--index]);//加法器实现
		}
		else if(expr.lExpr != null && expr.rExpr == null)
		{
			//递归运算
			s.push(expr.getB());
			
			Robot(expr.lExpr);
			
			storeReg(s.pop());
			
			storeReg(reg[--index] + reg[--index]);
		}
		else if(expr.lExpr == null && expr.rExpr != null)
		{
			//递归运算
			s.push(expr.getA());
			
			Robot(expr.rExpr);
			
			storeReg(s.pop());
			
			storeReg(reg[--index] + reg[--index]);
		}
		else    //左右两个均为递归运算表达式
		{
			//这里没有递归运算，因为没有需要维护的状态变量
			//递归解析和递归运算是不同的
			Robot(expr.lExpr);
			Robot(expr.rExpr);
			
			storeReg(reg[--index] + reg[--index]);
		}
	}
	//获取寄存器存储的值
	public int getReg(int index)
	{
		return reg[--index];
	}
	
	private int[] reg;
	private Stack s;
	private int index;
}
