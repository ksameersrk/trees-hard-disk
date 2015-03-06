import java.io.*;
import java.util.*;
public class Client
{
    public static void main(String[] args) throws IOException
    {
		String str1,str2;
		String filename1,filename2;
		char ch='N';
		char elder='N';
		char child;
		int root=1;
		int rec;
		int choice;
		String person_name,spouse_name;
		Scanner in=new Scanner(System.in);
		Tree t = new Tree();
		Family F=new Family();
		
		System.out.println("Enter the file name for the family");
		filename1=in.next();		
		
		System.out.println("Enter the file name for the root");
		filename2=in.next();

		if(filename2!=null)
			t.fta(filename2);	
		
		try
		{
			System.out.println("Enter person name and his/her spouse");
			str1=in.next();
			str2=in.next();
			F.set(str1,str2);
			t.createRoot(F,root,filename1,filename2);
				
			do
			{
				System.out.println("Do you have a child?(Y or N)");		
				child=in.next().charAt(0);
				
				if(child=='y' || child=='Y')
				{
					System.out.println("Do you have an elder child?(Y or N)");
					elder=in.next().charAt(0);
					
					if(elder=='Y' || elder=='y')
					{
						System.out.println("Enter person name and his/her spouse");
						str1=in.next();
						str2=in.next();
						F.set(str1,str2);
						t.setLeft(F,root,filename1,filename2);
						//root=2*root;
					}
					else
					{
						System.out.println("Enter person name and his/her spouse");
						str1=in.next();
						str2=in.next();
						F.set(str1,str2);
						t.setRight(F,root,filename1,filename2);
						//root=2*root+1;
					}
				
				
					System.out.println("Any more children?(y or N)");
					ch=in.next().charAt(0);
				}
			
			}while(Character.toUpperCase(child)=='Y' && Character.toUpperCase(ch)=='Y');
			do
			{
				System.out.println("1. seeking \n 2. replacing \n 3. deleting \n 4. exit");
				System.out.println("Enter your choice");
				choice=in.nextInt();
			
				switch(choice)
				{
					case 1:
					System.out.println("Enter the record number");
					rec=in.nextInt();
					if(t.read_record(rec,filename1,filename2)=="")
					System.out.println("Record does not exist");
					else
					System.out.println("Record is:"+" "+t.read_record(rec,filename1,filename2));
					break;
				
					case 2:
					System.out.println("Enter the record number");
					rec=in.nextInt();
					System.out.println("Enter the person's name");
					person_name=in.next();
					System.out.println("Enter the spouse's name");
					spouse_name=in.next();
					F.set(person_name,spouse_name);
					t.replace(rec,F,filename1);
					System.out.println("Replaced record:"+" "+t.read_record(rec,filename1,filename2));
					break;
				
					case 3:
					System.out.println("Enter the record number");
					rec=in.nextInt();
					t.delete(rec);
					if(t.read_record(rec,filename1,filename2)=="")
					System.out.println("Record deleted");
					break;
				
					case 4:
					System.exit(0);
				
					default:
					System.out.println("Wrong choice. Enter again");
				}
			}while(choice!=4);	
		}
		catch(Exception e)
		{
		}
    }
}
