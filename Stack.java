
public class Stack {
	//�̶���Сջ
	public Stack()
	{
		Top = 0;
		Container = new int[100];
	}
	public int push(int num)
	{
		if(Top == 100)
		{
			System.out.println("Stack is full!");
			return -1;
		}
		else
		{
			Container[Top] = num;
			Top++;
		}
		return 0;
	}
	
	public int pop()
	{
		if(Top == 0)
		{
			System.out.println("Stack is empty");
			return -1;
		}
		else
		{
			Top--;
			return Container[Top]; 
		}
	}
	
	public int getTop()
	{
		return Top;
	}
	
	private int Top; //Topָ��ǰ��λ
	private int[] Container; 

}
