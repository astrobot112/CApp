

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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")   
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private static final String LOGIN_FORM =       
    		"<html>"
    		+ "<head>"
    		+ "<script type=\"text/javascript\">\r\n" 
    		+ "            function callServlet() {\r\n" 
    		+ "                document.forms[0].action = \"Signup_user\";\r\n" 
    		+ "                document.forms[0].submit();\r\n" 
    		+ "            }\r\n" 
    		
    		+ "</script>\r\n"
    		+ "	 <script src=\"auth_fail.js\"></script>"
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
    		"    width: 25%;\r\n" + 
    		"    opacity: 0.9;\r\n" + 
    		"}\r\n" + 
    		"\r\n" + 
    		"button:hover {\r\n" + 
    		"    opacity:1;\r\n" + 
    		"}"
    		
    		+ ".userbtn, .loginbtn {\r\n" + 
    		"  float: center;\r\n" + 
    		"  width: 25%;\r\n" + 
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
    		"    width: 60%; " + 
    		"}"
    		
			+ ".container {\r\n" + 
			"    padding: 16px;\r\n" + 
			"}" 
		
		
			+ "hr {\r\n" + 
			"    border: 1px solid #f1f1f1;\r\n" + 
			"    margin-bottom: 25px;\r\n" + 
			"}"
			
			+ ".clearfix::after {\r\n" + 
			"    content: \"\";\r\n" + 
			"    clear: both;\r\n" + 
			"    display: table;\r\n" + 
			"}\r\n" 
			
			+ ".userbtn {\r\n" + 
			"    padding: 14px 20px;\r\n" + 
			"    background-color: #f44336;\r\n" + 
			"}"
			
			+ "h1 {\r\n" + 
			"   font-family: courier;\r\n" +
			" }"
    		+ "</style>"
    		
    		+ "<body id=\"body\">"
    		+ "<div class=\"modal\"  style=\"text-align:center\">"
    		+ "<h1 style=\"color:white;\"> CApp </h1>"
    		+ "<h2 style=\"color:white;\"> Complaint forum for a better insti</h2>"
    		+ "<div class=\"modal-content\" >"
    		//+ "<form class=\"modal-content\" id=\"loginform\" method=\"post\">"   
    		+ "<div class=\"container\">"
    		+ " <h1>Welcome</h1>\r\n" 
    		+ "      <p>Please sign in to view your newsfeed</p>"
    		+ "<hr>\r\n" 
    		+ "      <label for=\"user_id\"><b>User ID</b></label>\r\n"
			+ "        <input type=\"text\" id=\"user_id\" name=\"user_id\" placeholder=\"Enter User ID\" required > <br>"
			+ "<div id=\"ider\">"
    		+ "</div>"
			+ "		   <label for=\"password\"><b>Password</b></label>"
			+ "        <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"Enter Password\" required> <br>"
			+ "<div id=\"pder\">"
    		+ "</div>"
			+ " <button type=\"submit\" onclick=\"check_auth()\" class=\"loginbtn\">Login</button>"
    		+ "<form action=\"Signup_user\" method=\"Post\">"
			+ " <button type=\"submit\" class=\"userbtn\" >User Sign Up</button> "
			+ "</form>"
			+ "<br> <br> <br> <br>"
			+ "</div>"
			+"</div>"
			//+ " </form>"
			+ "</div>"
			+ "</body></html>";   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

			}
    
}    
