

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class sub_category_page
 */
@WebServlet("/sub_category_page")
public class sub_category_page extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sub_category_page() {
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
		String sub_category= (String) request.getParameter("sub_category_name");
		HttpSession catsession = request.getSession();
		catsession.setAttribute("sub_category_name", sub_category);
		
		 final String PROFILE_PAGE="<html>\n" + 
					"<head>\n" + 
					"  <meta charset=\"utf-8\">\n" + 
					"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
					"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\">\n" + 
					"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n" + 
					"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"></script>\n" + 
					"  <link rel=\"stylesheet\" href=\"posts.css\" />\n" + 
					"  <script src=\"whatasap.js\"></script>" +
					"  <script src=\"upvote.js\"></script>" +
					"<title>CategoryComplaints</title>\n" + 
					"<style>\n" + 
					"\n" + 
					"</style>\n" + 
					"</head>\n" + 
					"\n" + 
					"<body>\n" + 
					"	<div class=\"brand\">Complaints  ["+sub_category+"]</div>\n" + 
					"	<div class=\"nav-side-menu\">\n" + 
					"        <div class=\"menu-list\">\n" + 
					"    		<ul id=\"menu-content\" class=\"menu-content collapse out\">\n" + 
					"				<li data-toggle=\"collapse\" data-target=\"#service\" class=\"collapsed\">\n" + 
					"                	<a href=\"#\"><i class=\"fa fa-globe fa-lg\"></i> Category <span class=\"arrow\"></span></a>\n" + 
					"                </li>  \n" + 
					"                <ul class=\"sub-menu collapse\" id=\"service\">\n" + 
					"                    <li><a href=\"category_page\">Back</a></li>\n" + 
					"                </ul>\n" + 
					"				<li data-toggle=\"collapse\" data-target=\"#new\" class=\"collapsed\">\n" + 
					"                  <a href=\"#\"> Posts <span class=\"arrow\"></span></a>\n" + 
					"                </li>\n" + 
					"                <ul class=\"sub-menu collapse\" id=\"new\">\n" + 
					"                  <li><a href=\"createpost.html\">Add Post</a></li>\n" + 
					"                </ul>\n" + 
					"                <li><a href=\"Home\"><i class=\"fa fa-user fa-lg\"></i> Home</a></li>\n" + 
					"                <li><a href=\"LogoutServlet\"><i class=\"fa fa-users fa-lg\"></i>Logout</a></li>\n" + 
					"            </ul>\n" + 
					"    	</div>\n" + 
					"    </div>\n" + 
					"\n" + 
					"\n" + 
					"	<div class=\"container2\">\n" + 
					"		<p id=\"demo\"></p>\n" + 
					"	</div>	\n" + 
					"\n" + 
					
					
					"<script>\n" + 
					
					"function showCustomer() {\n" + 
					"  var xhttp;    \n" + 
					"  xhttp = new XMLHttpRequest();\n" + 
					"  xhttp.onreadystatechange = function() {\n" + 
					"    if (this.readyState == 4 && this.status == 200) {\n" + 
					"      obj = JSON.parse(this.responseText).data; \n" + 
					"		var cards=\"\";\n" + 
					"		var cards2=\"\";\n" + 
					"      for (x in obj){\n" + 
					"        cards2 = cards2+\"<div class=\\\"cardd\\\">\";\n" + 
					"      	cards2=cards2+\"<p style=\\\"text-align:left;\\\"><b><font size=6>\"+obj[x].title+\"</font></b>  ---\"+obj[x].user_id;\n" + 
					"    	if(obj[x].fake_status==\"true\"){\n" + 
					"    		cards2=cards2+\"<span style=\\\"float:right;\\\">\"+obj[x].status_name+\"(Marked as Fake)\"+\"</span></p>\";\n" + 
					"    	}else{\n" + 
					"    		cards2=cards2+\"<span style=\\\"float:right;\\\">\"+obj[x].status_name+\"</span></p>\";\n" + 
					"    	}\n" + 
					"      	cards2=cards2+\"<div class=\\\"card-body\\\">\"+obj[x].msg_content+\"</div>\";\n" + 
					"      	cards2=cards2+\"<div class=\\\"card-footer2\\\"><ul class='inlineList'>\";\n" + 
					"        cards2=cards2+\"<li class='line'><a style='color:#000' onclick='redirect(1,obj[x].post_id)'>UpVote(\"+obj[x].no_upvotes+\")</a></li>\";\n" + 
					"        cards2=cards2+\"<li class='line'><a style='color:#000' onclick='redirect(2,obj[x].post_id)'>DownVote(\"+obj[x].no_downvotes+\")</a></li>\";\n" + 
					"        cards2=cards2+\"</ul></div></div>\";\n" + 
					"        cards=cards2+cards;\n" + 
					"        cards2=\"\";\n" + 
					"      }\n" + 
					"      document.getElementById(\"demo\").innerHTML =cards ;\n" + 
					"    }\n" + 
					"  };\n" + 
					"  xhttp.open(\"GET\", \"sub_category_page_json\", true);\n" + 
					"  xhttp.send();\n" + 
					"}\n" + 
					"document.getElementById(\"demo\").innerHTML =showCustomer();\n" + 
					"</script>"+
					"<script>" +
					"function redirect(upv,post_id)\n" + 
					"{upvote(upv,post_id); document.location.href=\"sub_category_page?sub_category_name="+sub_category+"\";} "
					+ "</script>"+
					"</body>\n" + 
					"</html>";
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println(PROFILE_PAGE);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}