package examples.pubhub.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.dao.BookDAO;
import examples.pubhub.dao.TagDAO;
import examples.pubhub.model.Tag;
import examples.pubhub.utilities.DAOUtilities;

/**
 * Servlet implementation class AddTagServlet
 */
@WebServlet("/AddTag")
public class AddTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTagServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("publishTag.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		

		String isbn13 = req.getParameter("isbn13");
		String tagname = req.getParameter("tag_name");
		TagDAO tagdatabase = DAOUtilities.getTagsDAO();
		int tempTags = tagdatabase.tagCount(isbn13, tagname);
		
		
		Tag tag = new Tag();
		tag.set_isbn_13(isbn13);
		tag.settag_name(req.getParameter("tag_name"));
		int tag_count = tempTags+1;
		tag.settag_count(tag_count);
		
		
		boolean isSuccess = tagdatabase.addTag(tag);
		if (isSuccess)
		{
			req.getSession().setAttribute("message", "Tag successfully counted");
			req.getSession().setAttribute("messageClass", "alert-success");
			
			res.sendRedirect(req.getContextPath() + "/BookPublishing");
		}
		else
		{
			req.getSession().setAttribute("message", "There was a problem publishing the book");
			req.getSession().setAttribute("messageClass", "alert-danger");
			req.getRequestDispatcher("publishBook.jsp").forward(req, res);
		}
	}
}
