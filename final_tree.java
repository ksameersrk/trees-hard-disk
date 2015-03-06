import java.io.*;
public class Tree implements Serializable
{
    //int root;
    int i;
	long arr[][] = new long[10][3];
	
    public Tree()
    {
        //root = 1;
        i = 1;
		for(int j=0;j<arr.length;j++)
		{
			arr[j][0]=-1;
			arr[j][1]=-1;
			arr[j][2]=-1;
		}	
    }	
//    long point=-1;
  //  final int RECORD_SIZE = 24; //size of a student record
	//final int SIZE = 4; //size of a root record
	String person_name;
	String spouse_name;
    Family family=new Family();
    
	public void createRoot(Family family, int index,String filename1,String filename2) 
    {
        //arr[i] = index;
        try
        {
            writeToFile(family,i,filename1,filename2);
        }
        catch(Exception e)
        {
        }
    }
    //f.seek();
    
	public void setLeft(Family family, int index,String filename1,String filename2)
    {
        //arr[2*index] = file1.getFilePointer;
        try
        {
			if(arr.length<2*index+1)
			{
				for(int k=arr.length;k<=2*index+1;++k)
				{
					arr[k][0]=-1;
					arr[k][1]=-1;
					arr[k][2]=-1;
				}
			}
            appendToFile(family,2*index,filename1,filename2);
            //writeToFile(student,arr[2*index]);
        }
        catch(Exception e)
        {
        }
        //i=2*index;
    }
    
	public void setRight(Family family, int index,String filename1,String filename2)
    {
        //arr[2*index +1] =arr[i]+RECORD_SIZE;
        
		try
        {
			if(arr.length<2*index+1)
			{
				for(int k=arr.length;k<=2*index+1;++k)
				{
					arr[k][0]=-1;
					arr[k][1]=-1;
					arr[k][2]=-1;
				}
			}
            appendToFile(family,2*index+1,filename1,filename2);
            //writeToFile(student,arr[2*index+1]);
        }
        catch(Exception e)
        {
        }
        //i=2*index+1;
    }
    
	/*public void dispArr()  
    {
		for(int j=0;j<arr.length;j++)
		if(arr[j]!=-1) System.out.println(arr[j]+" ");
		
		try
		{
			readFromFile();
		}
		catch(Exception e)
		{
		}		
	}*/	
    
	public void writeToFile(Family family,int root,String filename1,String filename2) throws IOException
    {
        /*try
        {
         FileOutputStream fileOut1 = new FileOutputStream("family.ser");
         ObjectOutputStream out1 = new ObjectOutputStream(fileOut1);
		 FileOutputStream fileOut2 = new FileOutputStream("root.ser");
         ObjectOutputStream out2 = new ObjectOutputStream(fileOut2);
         out1.writeObject(family);
		 out2.writeObject(rt);
         //out.writeObject(f);
         out1.close();
         fileOut1.close();
		 out2.close();
         fileOut2.close();
		 //R.read();
         //System.out.printf("Serialized data is saved in base.ser");
        }*/
			try
			{
				RandomAccessFile file1=new RandomAccessFile(filename1,"rw");
				file1.seek(file1.length());
				arr[root][0]=0;
				person_name=family.getPerson();
				spouse_name=family.getSpouse();
				file1.writeChars(person_name);
				arr[root][1]=file1.getFilePointer();
				//System.out.println(point);
				//file1.writeChars("->");
				//file1.seek(point);
				file1.writeChars(spouse_name);
				//point=file1.getFilePointer();
				//System.out.println(point);
				//file1.writeChars(" ");
				arr[root][2]=file1.getFilePointer();
				file1.close();
			
				/*	RandomAccessFile file2=new RandomAccessFile(filename2,"rw");
				file2.seek(0);
				file2.writeInt(root);
				file2.close();  */
			}
			catch(IOException i)
			{
				i.printStackTrace();
			}
    }
	
	/*private void readFromFile() throws IOException,ClassNotFoundException
	{
		try
		{
			String name,usn;
			FileInputStream fileIn=new FileInputStream("out2.ser");
			ObjectInputStream in=new ObjectInputStream(fileIn);
			name=(String)in.readObject();
			usn=(String)in.readObject();
			in.close();
			fileIn.close();
			System.out.println("Name:"+name+" "+"usn:"+usn);
		}
		catch(Exception e)
		{
		}
	}*/
	
	public String read_record(int rec,String filename1,String filename2) throws IOException,ClassNotFoundException
	{
		String string="";
		try
		{
			
			RandomAccessFile file1=new RandomAccessFile(filename1,"rw");
			for(int i =0; i<10;++i)	
			{
				for(int h=0;h<3;++h)
				
					{
						System.out.print(arr[i][h]);
						System.out.print(" ");
					}
				System.out.println();	
			}		
			file1.seek(arr[rec][0]);
			char data[]=new char[20];
			int j;
			//int c=0;
			int k;
			
			for(j=0;j<(arr[rec][1]-arr[rec][0])/2;j++)
			{
				data[j]=file1.readChar();
				//++c;
				//++j;
			}
			data[j]=' ';
			int len=j;
			for(j=j+1;j<len+1+(arr[rec][2]-arr[rec][1])/2;j++)
			{
				data[j]=file1.readChar();
				//++c;
				//++j;
			}
			data[++j]='\0';
			/*long i=arr[rec][0];
			long count=arr[rec+1][0]-arr[rec][0];
			int c=0;
			while(c<count)
			{
				data[j]=file1.readChar();
				++j;
				++c;
			}*/
			
			//for(k=0;data[k]!='\0';k++)
				//System.out.print(data[k]);
				string=new String(data);
				
			
		}
		catch(Exception e)
		{
		}
		return string;
	}
	
    public void appendToFile(Family family,int root,String filename1,String filename2) throws IOException
    {
        try
		{
			RandomAccessFile file1=new RandomAccessFile(filename1,"rw");
			file1.seek(file1.length());
			person_name=family.getPerson();
			spouse_name=family.getSpouse();
			arr[root][0]=file1.getFilePointer();
			file1.writeChars(person_name);
			arr[root][1]=file1.getFilePointer();
			//file1.writeChars('->');
		 //	point=file1.getFilePointer();
		 //	file1.seek(point);
			file1.writeChars(spouse_name);
			//file1.writeChars('  ');
			arr[root][2]=file1.getFilePointer();
			file1.close();
			
			/*RandomAccessFile file2=new RandomAccessFile(filename2,"rw");
			file2.seek(file2.getFilePointer());
			file2.writeInt(root);
			file2.close();*/
		}
		/*try
        {
            ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream("family.ser", true)) {
            protected void writeStreamHeader() throws IOException {
                reset();
            }
        };
			ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream("root.ser", true)) {
            protected void writeStreamHeader() throws IOException {
                reset();
            }
        };
            out1.writeObject(family);
            out1.close();
			
			out2.writeObject(root);
            out2.close();
        
        } */  
        catch(IOException i)
        {
        }
    }
	
	void delete(int n)
	{
		if((n>0) && (n<arr.length) && (arr[n][0]!=-1))  // arr.length is supposed to givenumber rows in array (dont know if my syntax is right for 2d array)
		{		
			arr[n][0]=-1;   
			arr[n][1]=-1; 
			arr[n][2]=-1; 
			delete(2*n);
			delete(2*n+1);
		}
	}
	
	void replace(int n, Family family,String filename1) throws IOException
	{
		try	
		{
			RandomAccessFile file1=new RandomAccessFile(filename1,"rw") ;
			file1.seek(file1.length());
			person_name=family.getPerson();
			spouse_name=family.getSpouse();
			//arr[root][0]=file1.getFilePointer();
			arr[n][0]=file1.getFilePointer();
			file1.writeChars(person_name);		
			arr[n][1]=file1.getFilePointer();
			file1.writeChars(spouse_name);
			arr[n][2]=file1.getFilePointer();
			//file1.writeChars('  ');
			file1.close();
		}       
		catch(IOException i)
		{
        }	
	}
	
	void atf(String filename2) throws IOException
	{
		try
		{
			RandomAccessFile file2=new RandomAccessFile(filename2,"rw");
			for(int i=0; i<arr.length ; ++i)			
			for(int j=0;j<3;++j)
			file2.writeLong(arr[i][j]);	
			
			file2.close();

		}
		catch(IOException i)
        {
        }
	}
	
	void fta(String filename2) throws IOException
	{
		try
		{
			RandomAccessFile file2=new RandomAccessFile(filename2,"rw"); 
			for(int i=0; i<file2.length()/24 ; ++i)			
			for(int j=0;j<3;++j)
			arr[i][j]=file2.readLong();	
			
			file2.close();

		}
		catch(IOException i)
        {
        }
	}
}	
