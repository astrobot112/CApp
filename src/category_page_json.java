

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class category_page_json
 */
@WebServlet("/category_page_json")
public class category_page_json extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public category_page_json() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("id") == null) { //not logged in
			response.sendRedirect("LoginServlet");
		}
		String user_id = (String) session.getAttribute("id");
		String category = (String) session.getAttribute("category_name");
		

			String messageQuery = "select distinct post.post_id,title,user_id,msg_content,timestamp,status_name,fake_status,no_upvotes,no_downvotes from post,tags,sub_category where post.post_id=tags.post_id and tags.sub_category=sub_category.sub_category and sub_category.category_name=?";
			String json = DbHelper.executeQueryJson(messageQuery, 
				new DbHelper.ParamType[] {DbHelper.ParamType.STRING}, 
				new String[] {category});
			response.getWriter().print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}