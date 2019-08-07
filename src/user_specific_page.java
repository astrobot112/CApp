

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class user_specific_page
 */
@WebServlet("/user_specific_page")
public class user_specific_page extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_specific_page() {
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
		
		String category = (String) request.getParameter("category");
		String given_sub_cat =(String) request.getParameter("given_sub_cat");
		String sub_category = (String) request.getParameter("sub_category_name");
		
		HttpSession session2 = request.getSession();
		session2.setAttribute("category", category);
		session2.setAttribute("sub_category", sub_category);
		System.out.println("gotcha"+sub_category);
		session2.setAttribute("given_sub_cat", given_sub_cat);

		
		 final String PROFILE_PAGE="<html>\n" + 
					"<head>\n" + 
					"  <meta charset=\"utf-8\">\n" + 
					"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
					"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\">\n" + 
					"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n" + 
					"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"></script>\n" + 
					"  <link rel=\"stylesheet\" href=\"posts.css\" />\n" + 
					"  <script src=\"whatasap.js\"></script>" +
					"<title>MyComplaints</title>\n" + 
					"<style>\n" + 
					"\n" + 
					"</style>\n" + 
					"</head>\n" + 
					"\n" + 
					"<body>\n" + 
					"	<div class=\"brand\">My Complaints ["+sub_category+"]"+"</div>\n" + 
					"	<div class=\"nav-side-menu\">\n" + 
					"        <div class=\"menu-list\">\n" + 
					"    		<ul id=\"menu-content\" class=\"menu-content collapse out\">\n" + 
					"				<li data-toggle=\"collapse\" data-target=\"#service\" class=\"collapsed\">\n" + 
					"                	<a href=\"#\"><i class=\"fa fa-globe fa-lg\"></i> Categories <span class=\"arrow\"></span></a>\n" + 
					"                </li>  \n" + 
					"                <ul class=\"sub-menu collapse\" id=\"service\">\n" + 
					"                    <p id=\"getsubcat\"></p>\n"+
					"                </ul>\n" + 
					"				<li data-toggle=\"collapse\" data-target=\"#new\" class=\"collapsed\">\n" + 
					"                  <a href=\"#\"><i class=\"fa fa-car fa-lg\"></i> Posts <span class=\"arrow\"></span></a>\n" + 
					"                </li>\n" + 
					"                <ul class=\"sub-menu collapse\" id=\"new\">\n" + 
					"                  <li><a href=\"Home\">Add Post</a></li>\n" + 
					"                </ul>\n" + 
					"                <li><a href=\"profile_page\"><i class=\"fa fa-user fa-lg\"></i> All Complaints</a></li>\n" +
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
					"function show_sub_cat() {\n" + 
					"  var xhttp;    \n" + 
					"  xhttp = new XMLHttpRequest();\n" + 
					"  xhttp.onreadystatechange = function() {\n" + 
					"    if (this.readyState == 4 && this.status == 200) {\n" + 
					"      obj = JSON.parse(this.responseText).data; \n" + 
					"    var cards=\"\";\n" + 
					"      for (x in obj){\n" + 
					"         cards+=\"<li><a href=\\\"user_specific_page?given_sub_cat=yes&sub_category_name=\"+obj[x].sub_category+\"\\\">\"+obj[x].sub_category+\"</a></li>\";"+ 
					"      }\n" + 
					"      document.getElementById(\"getsubcat\").innerHTML =cards ;\n" + 
					"    }\n" + 
					"  };\n" + 
					"  xhttp.open(\"GET\", \"show_subcat\", true);\n" + 
					"  xhttp.send();\n" + 
					"}\n" + 
					"document.getElementById(\"getsubcat\").innerHTML =show_sub_cat();\n" + 
					"</script>"+
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
					"    	cards2=cards2+\"<p style=\\\"text-align:left;\\\"><b><font size=6>\"+obj[x].title+\"</font></b>\";\n" + 
					"    	if(obj[x].fake_status==\"true\"){\n" + 
					"    		cards2=cards2+\"<span style=\\\"float:right;\\\">\"+obj[x].status_name+\"(Marked as Fake)\"+\"</span></p>\";\n" + 
					"    	}else{\n" + 
					"    		cards2=cards2+\"<span style=\\\"float:right;\\\">\"+obj[x].status_name+\"</span></p>\";\n" + 
					"    	}\n" + 
					"      	cards2=cards2+\"<div class=\\\"card-body\\\">\"+obj[x].msg_content+\"</div>\";\n" + 
					"      	cards2=cards2+\"<div class=\\\"card-footer2\\\"><ul class='inlineList'>\";\n" + 
					"        cards2=cards2+\"<li class='line'><a style='color:#000' onclick='redirect(4,obj[x].post_id)'>Delete</a></li>\";\n" + 
					"        cards2=cards2+\"<li class='line'><a style='color:#000' onclick='redirect(1,obj[x].post_id)'>UpVote(\"+obj[x].no_upvotes+\")</a></li>\";\n" + 
					"        cards2=cards2+\"<li class='line'><a style='color:#000' onclick='redirect(2,obj[x].post_id)'>DownVote(\"+obj[x].no_downvotes+\")</a></li>\";\n" + 
					"        if(obj[x].status_name=='Unresolved'){\n" + 
					"        	cards2=cards2+\"<li class='line'><a style='color:#000' onclick='redirect(3,obj[x].post_id)'>Resolve</a></li>\";\n" + 
					"        }  \n" + 
					"        cards2=cards2+\"</ul></div></div>\";\n" + 
					"        cards=cards2+cards;\n" + 
					"        cards2=\"\";\n" + 
					"      }\n" + 
					"      document.getElementById(\"demo\").innerHTML =cards ;\n" + 
					"    }\n" + 
					"  };\n" + 
					"  xhttp.open(\"GET\", \"user_specific_page_json\", true);\n" + 
					"  xhttp.send();\n" + 
					"}\n" + 
					"document.getElementById(\"demo\").innerHTML =showCustomer();\n" + 
					"</script>"+
					"<script>" +
					"function redirect(upv,post_id)\n" + 
					"{upvote(upv,post_id); document.location.href=\"user_specific_page\";} "
					+ "</script>"+
					"\n" + 
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

