//树形表达式结构
public class Expr {
	
	public Expr(char cal,int a,int b)
	{
		this.cal = cal;
		this.a = a;
		this.b = b;
	}
	
	public int getA()
	{
		return a;
	}
	public int getB()
	{
		return b;
	}
	public int getCal()
	{
		return (int)cal;
	}
	
	public char cal;
	private int a;
	private int b;
	
	public Expr lExpr = null;
	public Expr rExpr = null;
}
