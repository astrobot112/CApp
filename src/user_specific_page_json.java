

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class user_specific_page_json
 */
@WebServlet("/user_specific_page_json")
public class user_specific_page_json extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_specific_page_json() {
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
		String category = (String) session.getAttribute("category");
		System.out.println(category);
		String sub_category = (String) session.getAttribute("sub_category");
		String given_sub_cat = (String) session.getAttribute("given_sub_cat");

	
		String json="";
		if(given_sub_cat.equals("yes")) {
			String messageQuery = "select distinct post.post_id,title,user_id,msg_content,timestamp,status_name,fake_status,no_upvotes,no_downvotes from post,tags where user_id=? and post.post_id=tags.post_id and tags.sub_category=? ";
			json = DbHelper.executeQueryJson(messageQuery, 
				new DbHelper.ParamType[] {DbHelper.ParamType.STRING,DbHelper.ParamType.STRING}, 
				new String[] {user_id,sub_category});
			System.out.println(json);
			response.getWriter().print(json);
		}else {
			String messageQuery = "select distinct post.post_id,title,post.user_id,msg_content,timestamp,status_name,fake_status,no_upvotes,no_downvotes from post,tags,sub_category where user_id=? and post.post_id=tags.post_id and tags.sub_category=sub_category.sub_category and sub_category.category_name=?) ";
			json = DbHelper.executeQueryJson(messageQuery, 
					new DbHelper.ParamType[] {DbHelper.ParamType.STRING,DbHelper.ParamType.STRING}, 
					new String[] {user_id,category});
			response.getWriter().print(json);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}