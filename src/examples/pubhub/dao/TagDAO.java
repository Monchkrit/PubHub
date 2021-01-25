package examples.pubhub.dao;

import java.util.List;

import examples.pubhub.model.Tag;

public interface TagDAO {
	public boolean addTag(Tag tag);
	public boolean removeTag(Tag tag);
	public List<Tag> bookTags(String isbn);
	public List<Tag> allTags();
	public int tagCount(String isbn, String tag_name);
}
