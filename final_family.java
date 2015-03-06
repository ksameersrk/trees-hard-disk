public class Family 
{
	String person;
	String spouse;
	
	public Family()
	{
		person=null;
		spouse=null;
	}
	
	public void set(String str1,String str2)
	{
		person=str1;
		spouse=str2;
	}
	
	/*public int size_of_person()
	{
		return person.length();
	}
	
	public int size_of_spouse()
	{
		return spouse.length();
	}*/
	
	public String getPerson()
	{
		return person;
	}
	
	public String getSpouse()
	{
		return spouse;
	}
}
