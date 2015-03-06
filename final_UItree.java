import java.io.*;
public class UITree
{
	Tree tree=new Tree();
	Family fam=new Family();
	String filename1,filename2;
	String person_name;
	String spouse_name;
	int root;
	
	public void setFile(String filename1,String filename2)
	{
		this.filename1=filename1;
		this.filename2=filename2;
	}
	
	public void setLeft(String person,String spouse,int rt)
	{
		person_name=person;
		spouse_name=spouse;
		root=rt;
		fam.set(person_name,spouse_name);
		tree.setLeft(fam,rt,filename1,filename2);
	}
	
	public void setRight(String person,String spouse,int rt)
	{
		person_name=person;
		spouse_name=spouse;
		root=rt;
		fam.set(person_name,spouse_name);
		tree.setRight(fam,rt,filename1,filename2);
	}
	
	public String seek_record(int rec) throws IOException
	{
		String string="";
		try
		{
			 string= tree.read_record(rec,filename1,filename2);
		}
		catch(Exception e)
		{
		}	
		return string;
	}
	
	public void delete_record(int rec)
	{
		tree.delete(rec);
	}
	
	public void start_code() throws IOException
	{
		try
		{
			tree.fta(filename2);
		}
		catch(Exception e)
		{
		}	
	}
	
	public void exit_code() throws IOException
	{
		try
		{
			tree.atf(filename2);
			System.exit(0);
		}
		catch(Exception e)
		{
		}	
	}
	
	
}
