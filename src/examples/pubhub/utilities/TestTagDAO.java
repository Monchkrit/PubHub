package examples.pubhub.utilities;

import java.util.List;

import examples.pubhub.dao.TagDAO;
import examples.pubhub.dao.TagDAOImpl;
import examples.pubhub.model.Tag;

public class TestTagDAO {

	public static void main(String[] args) {
		TagDAO dao = new TagDAOImpl();
		
		List<Tag> list = dao.bookTags("1111111111111");
		
		for (int i = 0; i < list.size(); i++)
		{
			Tag t = list.get(i);
			System.out.println(t.tag_name);
		}
	}

}
