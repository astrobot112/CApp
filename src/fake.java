

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fake
 */
@WebServlet("/fake")
public class fake extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fake() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = (String) request.getParameter("user_id");
		int post_id=Integer.parseInt(request.getParameter("post_id"));
		String fake = (String) request.getParameter("fake");
		if(fake.equals("fake")) {
			String messageQuery = "update post set fake_status='1' where user_id=? and post_id=?";
			String json = DbHelper.executeUpdateJson(messageQuery, 
				new DbHelper.ParamType[] {DbHelper.ParamType.STRING,DbHelper.ParamType.INT}, 
				new Object[] {user_id,post_id});
			response.getWriter().print(json);
		}
		else if(fake.equals("unfake")) {
			String messageQuery = "update post set fake_status='0' where user_id=? and post_id=?";
			String json = DbHelper.executeUpdateJson(messageQuery, 
				new DbHelper.ParamType[] {DbHelper.ParamType.STRING,DbHelper.ParamType.INT}, 
				new Object[] {user_id,post_id});
			response.getWriter().print(json);
		}
		response.sendRedirect("authority_profile_page");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
