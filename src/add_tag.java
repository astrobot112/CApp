

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.JSONParser;

/**
 * Servlet implementation class add_tag
 */
@WebServlet("/add_tag")
public class add_tag extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add_tag() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String post_id = request.getParameter("post_id");
		int postid = Integer.parseInt(post_id);
		String tag = request.getParameter("dropdown1");
		//response.getWriter().print(tag.length);
		List<String> list = Arrays.asList(tag.split(","));
		int listlen = list.size();
		String json="";
		 for(int i=0;i<listlen;i++)
		 {  
		String query = "insert into tags (post_id,sub_category) values (?,?)";
		 json = DbHelper.executeUpdateJson(query, 
				new DbHelper.ParamType[] {DbHelper.ParamType.INT,  DbHelper.ParamType.STRING},
				new Object[] {postid,list.get(i)});
	
		 }
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
