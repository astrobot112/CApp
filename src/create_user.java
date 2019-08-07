

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class create_user
 */
@WebServlet("/create_user")
public class create_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public create_user() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
//		out.println(LOGIN_FORM);
		String user_name = request.getParameter("user_name");
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		String password_check = request.getParameter("password_check");
		System.out.println(password);
		System.out.println(password_check);
		if(password.equals(password_check))
		{
			System.out.println("done");
		String query = "insert into users (user_id, user_name) values (?,?)";
			String res = DbHelper.executeUpdateJson(query, 
				new DbHelper.ParamType[] {DbHelper.ParamType.STRING,DbHelper.ParamType.STRING}, 
				new Object[] {user_id, user_name});

			String query2 = "insert into password (user_id, password) values (?,?)";
			String res2 = DbHelper.executeUpdateJson(query2, 
				new DbHelper.ParamType[] {DbHelper.ParamType.STRING,DbHelper.ParamType.STRING}, 
				new Object[] {user_id, password});

				response.getWriter().print(res);
				HttpSession session = request.getSession();
				session.setAttribute("id", user_id);
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