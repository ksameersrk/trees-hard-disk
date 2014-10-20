public class arrayTree
{
	int arrayTree[] = new int[100];
	int root;
	public arrayTree()
	{
		root =1;
		for(int i=1;i<100;i++)
			arrayTree[i] = -1;
	}

	public void insert(int key)
	{
		insert(root,key);
	}
	public void insert(int root,int key)
	{
		if(arrayTree[root] == -1)
		{
			arrayTree[root] = key;
		}
		else if(arrayTree[root] < key)
		{
			insert((2*root)+1,key);
		}
		else
		{
			insert((2*root),key);
		}
	}
	public void disp()
	{
		System.out.println("Inorder");
		inorder(root);
		System.out.println("PreOrder");
		preorder(root);
		System.out.println("PostOrder");
		postorder(root);
		System.out.println("Internal Nodes "+countInternal(root));
		System.out.println("External Nodes "+countExternal(root));
	}
	public void inorder(int root)
	{
		if(arrayTree[root] != -1)
		{
			inorder(2*root);
			System.out.println(arrayTree[root]);
			inorder((2*root)+1);
		}
	}
	public void preorder(int root)
	{
		if(arrayTree[root] != -1)
		{
			System.out.println(arrayTree[root]);
			preorder(2*root);
			preorder((2*root)+1);
		}
	}
	public void postorder(int root)
	{
		if(arrayTree[root] != -1)
		{
			postorder(2*root);
			postorder((2*root)+1);
			System.out.println(arrayTree[root]);
		}
	}
	public int countInternal(int root)
	{
		if(arrayTree[root] == -1)
		{
			return 0;
		}
		else if(arrayTree[(2*root)]==-1 && arrayTree[(2*root)+1]==-1 )
		{
			return 0;
		}
		else
		{
			return 1+countInternal(2*root)+countInternal((2*root)+1);
		}
	}
	public int countExternal(int root)
	{
		if(arrayTree[root] == -1)
		{
			return 0;
		}
		else if(arrayTree[(2*root)]==-1 && arrayTree[(2*root)+1]==-1 )
		{
			return 1;
		}
		else
		{
			return countExternal(2*root) + countExternal((2*root)+1);
		}
		
	}
}
