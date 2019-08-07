import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class authority_page
 */
@WebServlet("/authority_page")
public class authority_page extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authority_page() {
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
		String messageQuery = "select distinct post.post_id,title,post.user_id,msg_content,timestamp,status_name,fake_status,no_upvotes,no_downvotes from post,tags,councilmember where tags.post_id=post.post_id and councilmember.sub_category=tags.sub_category and councilmember.user_id=?";
		String json = DbHelper.executeQueryJson(messageQuery, 
				new DbHelper.ParamType[] {DbHelper.ParamType.STRING}, 
				new String[] {user_id});
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