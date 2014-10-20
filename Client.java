public class Client
{
	public static void main(String args[])
	{
		int[] k = { 20, 10, 30, 5,25,  40, 15, 12,18};
		arrayTree t = new arrayTree();
		for(int e : k)
		{
			t.insert(e);
		}
		t.disp();
	}
}
