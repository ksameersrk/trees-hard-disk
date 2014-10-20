public class TreesArray
{
    int arr[] = new int[100];
    int root;
    int left,right;
    public TreesArray()
    {
        root = 1;
        for(int i=0; i<100; i++)
        {
            arr[i] = -1;
        }
    }
    
    public void insert(int key)
    {
        insert(root,key);
    }
    
    public void insert(int root,int key)
    {
        left = 2*root;
        right = (2*root) + 1;
        if(arr[root] == -1)
        {
            arr[root] = key;
        }
        else if(arr[root] > key)
        {
            insert(left,key);
        }
        else
        {
            insert(right,key);
        }
    }
    
    public void countNodes()
    {
        int x = countNodes(root);
        System.out.println("# of nodes : "+ x);
    }
    
    public int countNodes(int root)
    {
        if(arr[root] == -1)
        {
            return 0;
        }
        else
        {
            return 1 + countNodes(2*root) + countNodes((2*root)+1);
        }
    }
    public void countLeaves()
    {
        int x = countLeaves(root);
        System.out.println("# of leaves : "+x);
    }
    public int countLeaves(int root)
    {
        left = 2*root;
        right = (2*root)+1;
        if(arr[root] == -1)
        {
            return 0;
        }
        else if(arr[left] == -1 && arr[right] == -1)
        {
            return 1; 
        }
        else
        {
            return countLeaves(2*root) + countLeaves((2*root)+1);
        }
    }
    
    public void display()
    {
        System.out.println("Inorder : ");
        inorder(root);
        System.out.println("preorder : ");
        preorder(root);
        System.out.println("Postorder : ");
        postorder(root);
    }
    
    public void inorder(int root)
    {
        if(arr[root] != -1)
        {
            inorder(2*root);
            System.out.println(arr[root]);
            inorder((2*root)+1);
        }
    }
    public void preorder(int root)
    {
        if(arr[root] != -1)
        {
            System.out.println(arr[root]);
            preorder(2*root);
            preorder((2*root)+1);
        }
    }
    public void postorder(int root)
    {
        if(arr[root] != -1)
        {
            postorder(2*root);
            postorder((2*root)+1);
            System.out.println(arr[root]);
        }
    }
    
}
