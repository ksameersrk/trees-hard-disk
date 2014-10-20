import java.util.Scanner;
public class Client
{
    public static void main(String[] args)
    {
        int x;
        TreesArray tr = new TreesArray();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the numbers.");
        for(int i=0; i<8; i++)
        {
            x = in.nextInt();
            tr.insert(x);
        }
        
        tr.display();
        //tr.countNodes();
        //tr.countLeaves();
    }
}
