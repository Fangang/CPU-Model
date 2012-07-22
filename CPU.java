
public class CPU {
	public CPU(int[] reg,Stack s,int index)
	{
		this.reg = reg;
		this.s = s;
		this.index = index;  //��ʱû������������
	}
	//�������洢�ڼĴ�����
	public int storeReg(int num)
	{
		reg[index] = num;
		return ++index;  //ע��Index�ı仯
	}
	//CPU�ڲ����ʽ�������
	public void Robot(Expr expr)
	{
		if(expr.lExpr == null && expr.rExpr == null)
		{
			//��������
			storeReg(expr.getA());
			storeReg(expr.getB());
			storeReg(reg[--index] + reg[--index]);//�ӷ���ʵ��
		}
		else if(expr.lExpr != null && expr.rExpr == null)
		{
			//�ݹ�����
			s.push(expr.getB());
			
			Robot(expr.lExpr);
			
			storeReg(s.pop());
			
			storeReg(reg[--index] + reg[--index]);
		}
		else if(expr.lExpr == null && expr.rExpr != null)
		{
			//�ݹ�����
			s.push(expr.getA());
			
			Robot(expr.rExpr);
			
			storeReg(s.pop());
			
			storeReg(reg[--index] + reg[--index]);
		}
		else    //����������Ϊ�ݹ�������ʽ
		{
			//����û�еݹ����㣬��Ϊû����Ҫά����״̬����
			//�ݹ�����͵ݹ������ǲ�ͬ��
			Robot(expr.lExpr);
			Robot(expr.rExpr);
			
			storeReg(reg[--index] + reg[--index]);
		}
	}
	//��ȡ�Ĵ����洢��ֵ
	public int getReg(int index)
	{
		return reg[--index];
	}
	
	private int[] reg;
	private Stack s;
	private int index;
}
