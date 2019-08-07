

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Signup_user
 */
@WebServlet("/Signup_user")
public class Signup_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String LOGIN_FORM = 
    		"<html>"
			+ "<head>"
    	    		
			+ "    <script src=\"jquery-3.3.1.js\"> </script>" 
			+ "    <script src=\"jquery.dataTables.min.js\"></script>"  
			+ "    <script src=\"jquery-ui.min.js\"></script>" 
			+ "    <link rel=\"stylesheet\" href=\"jquery-ui.css\" />"  
			+ "    <link rel=\"stylesheet\" href=\"jquery.dataTables.min.css\"/>" 
			
			+ "	 <script src=\"whatasap_home.js\"></script>"
			+ "</head>"
    		
			+ "<style>"
			+ "body {font-family: Arial, Helvetica, sans-serif;}\r\n" + 
			"* {box-sizing: border-box;}"
			
			+ "input[type=text], input[type=password] {\r\n" + 
			"    width: 50%;\r\n" + 
			"    padding: 15px;\r\n" + 
			"    margin: 5px 0 22px 0;\r\n" + 
			"    display: inline-block;\r\n" + 
			"    border: none;\r\n" + 
			"    background: #f1f1f1;\r\n" + 
			"}\r\n" 
			
			+ "input[type=text]:focus, input[type=password]:focus {\r\n" + 
			"    background-color: #ddd;\r\n" + 
			"    outline: none;\r\n" + 
			"}\r\n" 
			
			+ "button {\r\n" + 
			"    background-color: #4CAF50;\r\n" + 
			"    color: white;\r\n" + 
			"    padding: 14px 20px;\r\n" + 
			"    margin: 8px 0;\r\n" + 
			"    border: none;\r\n" + 
			"    cursor: pointer;\r\n" + 
			"    width: 100%;\r\n" + 
			"    opacity: 0.9;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"button:hover {\r\n" + 
			"    opacity:1;\r\n" + 
			"}"
			
			+ ".signupbtn {\r\n" + 
			"  float: left;\r\n" + 
			"  width: 50%;\r\n" + 
			"}"
			
			+ ".modal {\r\n" +  
			"    position: fixed; /* Stay in place */\r\n" + 
			"    z-index: 1; /* Sit on top */\r\n" + 
			"    left: 0;\r\n" + 
			"    top: 0;\r\n" + 
			"    width: 100%; /* Full width */\r\n" + 
			"    height: 100%; /* Full height */\r\n" + 
			"    overflow: auto; /* Enable scroll if needed */\r\n" + 
			"    background-color: #474e5d;\r\n" + 
			"    padding-top: 50px;\r\n" + 
			"}\r\n"  
			
			+ ".modal-content {" + 
			"    background-color: #fefefe;" + 
			"    margin: 5% auto 15% auto;" + 
			"    border: 1px solid #888;" + 
			"    width: 80%; " + 
			"}"
			
			+ ".container {\r\n" + 
			"    padding: 16px;\r\n" + 
			"}" 
			
			+ "hr {\r\n" + 
			"    border: 1px solid #f1f1f1;\r\n" + 
			"    margin-bottom: 25px;\r\n" + 
			"}"
			
			+ ".userbtn {\r\n" + 
			"    padding: 14px 20px;\r\n" + 
			"    background-color: #f44336;\r\n" + 
			"}"
			
			+ "</style>"

    		
    		+ "<body id=\"body\">"
    		
    		+ "<div class=\"modal\">"
    		+ "<div class=\"modal-content\">"
    		+ "<div class=\"container\">"
    		+ " <h1>Welcome Again</h1>\r\n" 
    		+ "      <p>You are one step away from becoming a user!</p>"
    		+ "<hr>\r\n" 
    		+ "      <label for=\"user_name\"><b>User Name</b></label>\r\n"
			+ "      <input type=\"text\" id=\"user_name\" name=\"user_name\" placeholder=\"Enter User Name\" required > <br>" 
			
			+ "      <label for=\"user_id\"><b>User ID</b></label>\r\n"
			+ "      <input type=\"text\" id=\"user_id\" name=\"user_id\" placeholder=\"Enter User ID\" required > <br>" 
			+ "<div id=\"error\">"
			+ "</div>"
			+ "		 <label for=\"password\"><b>Password</b></label>"
			+ "      <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"Enter Password\" required > <br>"
			+ "		 <label for=\"password_check\"><b>Re-enter Password</b></label>"
			+ "      <input type=\"password\" id=\"password_check\" name=\"password_check\"  placeholder=\"Re-enter Password\" required > <br>"
			+ "<div id=\"samepd\">"
			+ "</div>"
			
			+ "<p>By creating an account you agree to our <a href=\"terms.html\" style=\"color:dodgerblue\">Terms & Privacy</a>.</p>\n"
			+ "        <button type=\"submit\" onclick=\"insert_user()\" class=\"signupbtn\"> Create User</button> <br> <br> <br> <br>" 
			+ "</div>"
			+ "</div>"
			+ "</div>"
			+ "</body></html>"; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup_user() {
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
		out.println(LOGIN_FORM);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
//		

	}

}