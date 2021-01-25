package examples.pubhub.model;

public class Tag {
	public String isbn_13;
	public String tag_name;
	public int tag_count;
	
	public String getisbn_13()
	{
		return isbn_13;
	}
	
	public void set_isbn_13(String isbn_13)
	{
		this.isbn_13 = isbn_13;
	}
	
	public String gettag_name()
	{
		return tag_name;
	}
	
	public void settag_name(String tag_name)
	{
		this.tag_name = tag_name;
	}
	
	public void settag_count(int tag_count)
	{
		this.tag_count = tag_count;
	}
	
	public int gettag_count()
	{
		return tag_count;
	}
}
