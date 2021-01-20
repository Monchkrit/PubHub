package examples.pubhub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examples.pubhub.model.Book;
import examples.pubhub.model.Tag;
import examples.pubhub.utilities.DAOUtilities;

public class TagDAOImpl implements TagDAO {
	Connection connection = null;
	PreparedStatement stmt = null;
	
	@Override
	public boolean addTag(Tag tag) {
		try
		{
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO Tags VALUES (?,?,?)";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, tag.getisbn_13());
			stmt.setString(2, tag.gettag_name());
			stmt.setBytes(3, tag.getContent());
			
			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			closeResources();
		}
	}

	@Override
	public boolean removeTag(Tag tag) {
		try
		{
			connection = DAOUtilities.getConnection();
			String sql = "DELETE Books WHERE isbn_13=? && tag_name=?";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, tag.getisbn_13());
			stmt.setString(2, tag.gettag_name());
			
			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			closeResources();
		}
	}

	@Override
	public List<Tag> bookTags(String isbn) {
		List<Tag> tags = new ArrayList<>();
		
		try
		{
			connection = DAOUtilities.getConnection();
			String sql = "SELECT * FROM book_tags WHERE isbn_13 = ?";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, isbn);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next())
			{
				Tag tag = new Tag();
				tag = new Tag();
				tag.set_isbn_13(rs.getString("isbn_13"));
				tag.settag_name(rs.getString("tag_name"));
				
				tags.add(tag);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeResources();
		}
		
		return tags;
	}
	
	@Override
	public List<Tag> allTags()
	{
		List<Tag> tags = new ArrayList<>();
		
		try
		{
			connection = DAOUtilities.getConnection();
			String sql = "SELECT * FROM book_tags";
			stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next())
			{
				Tag tag = new Tag();
				tag = new Tag();
				tag.set_isbn_13(rs.getString("isbn_13"));
				tag.settag_name(rs.getString("tag_name"));
				
				tags.add(tag);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeResources();
		}
		
		return tags;
	}
	
	private void closeResources()
	{
		try
		{
			if (stmt != null)
				stmt.close();
		}
		catch (SQLException e)
		{
			System.out.println("Could not close the SQL statement!");
			e.printStackTrace();
		}
		
		try
		{
			if (connection != null)
				connection.close();
		}
		catch (SQLException e)
		{
			System.out.println("Could not close the SQL connection!");
			e.printStackTrace();
		}
	}
}
