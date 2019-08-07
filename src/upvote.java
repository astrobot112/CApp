

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class upvote
 */
@WebServlet("/upvote")
public class upvote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public upvote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("id");
		int post_id=Integer.parseInt(request.getParameter("post_id"));
		String upvote = (String) request.getParameter("upvote");
		System.out.println("start");
		System.out.println(user_id);
		System.out.println(post_id);
		System.out.println(upvote);
		if(upvote.equals("1")) {
			String messageQuery = "update post set no_upvotes=no_upvotes+1 where user_id=? and post_id=?";
			String json = DbHelper.executeUpdateJson(messageQuery, 
				new DbHelper.ParamType[] {DbHelper.ParamType.STRING,DbHelper.ParamType.INT}, 
				new Object[] {user_id,post_id});
			System.out.println(json);
			response.getWriter().print(json);
		}
		else if(upvote.equals("2")) {
			String messageQuery = "update post set no_downvotes=no_downvotes+1 where user_id=? and post_id=?";
			String json = DbHelper.executeUpdateJson(messageQuery, 
				new DbHelper.ParamType[] {DbHelper.ParamType.STRING,DbHelper.ParamType.INT}, 
				new Object[] {user_id,post_id});
			response.getWriter().print(json);
		}
		else if(upvote.equals("4")) {
			System.out.println("deleted");
			String messageQuery0 = "delete from tags where post_id=?";
			String json0 = DbHelper.executeUpdateJson(messageQuery0, 
				new DbHelper.ParamType[] {DbHelper.ParamType.INT}, 
				new Object[] {post_id});
			String messageQuery = "delete from post where user_id=? and post_id=?";
			String json = DbHelper.executeUpdateJson(messageQuery, 
				new DbHelper.ParamType[] {DbHelper.ParamType.STRING,DbHelper.ParamType.INT}, 
				new Object[] {user_id,post_id});
			System.out.println(json);
			response.getWriter().print("print");
		}
		else if(upvote.equals("3")) {
			String messageQuery = "update post set status_name='Resolved' where user_id=? and post_id=?";
			String json = DbHelper.executeUpdateJson(messageQuery, 
				new DbHelper.ParamType[] {DbHelper.ParamType.STRING,DbHelper.ParamType.INT}, 
				new Object[] {user_id,post_id});
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
