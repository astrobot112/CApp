

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
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
		System.out.println(user_id);
		response.setContentType("text/html");
		String html="<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"<head>\n" + 
				"  <meta charset=\"utf-8\">\n" + 
				"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
				"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\">\n" + 
				"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" + 
				"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n" + 
				"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"></script>\n" + 
				"  <link rel=\"stylesheet\" href=\"home_page.css\">\n" + 
				"  <script src=\"home_script.js\"></script>\n" + 
				"<title>Home</title>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"<p id=\"demo1\"></p>\n" + 
				"	<p id=\"demo\"></p>	\n" + 
				"   <script>document.getElementById(\"demo1\").innerHTML = showheader();\n" + 
				"   document.getElementById(\"demo\").innerHTML = showcategory();</script>\n" + 
				"</body>\n" + 
				"</html>\n" + 
				"";
		PrintWriter out = response.getWriter();
		out.print(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String category;
		
		category= request.getParameter("category_name");
		HttpSession session = request.getSession();
		session.setAttribute("category_name", category);
		System.out.println(category);
		response.sendRedirect("category_page");
	}

}