function showcategory() {
	   var xhttp;    
	   xhttp = new XMLHttpRequest();
	   xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	obj = JSON.parse(this.responseText).data;
		    	var str="<div class=\"container3\"><h2 id=\"d1\">Categories</h2>";
		    	var i=1;
			    for (x in obj){
			    	if(i%3==1) str+="<div class=\"row\">";
			    	str+="<div class=\"column\"><form action=\"Home\" method=\"post\">";
			    	str+="<button class=\"box\" name=\"category_name\" value=\"";
			    	str+=obj[x].category_name;
			    	str+="\" id=\"box\" style=\"background: url(";
			    	str+=obj[x].category_name;
			    	str+=".jpeg";
			    	str+=") no-repeat;\">";
			    	str+=obj[x].category_name;
			    	str+="</button></form>";
			    	str+="</div>";
			    	if(i%3==0) str+="</div>";
			    	i++;
			    }
			    str+="<\div>";
			    document.getElementById("demo").innerHTML = str;
		    }
	   };
	   xhttp.open("GET", "Category", true);
	   xhttp.send();  
   }
function showheader() {
	var xhttp;    
	   xhttp = new XMLHttpRequest();
	   xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	obj = JSON.parse(this.responseText).data;
		    	var str="<div class=\"brand\"><div class=\"row\"><div class=\"column\" id=\"i1\">CApp</div>";
		    	if(obj[0].authority=="true") {
		    		str+="<div class=\"column\" id=\"i2\"><button style=\"background-color:#474e5d;font-size:24px;height:60px;\" onclick=\"location.href='authority_profile_page'\">";
		    		str+="<i class=\"fa fa-bank\" style=\"color:#e1ffff;\"></i></button></div>";
		    	}
		    	str+="<div class=\"column\" id=\"i3\"><button style=\"background-color:#474e5d;font-size:24px;height:60px;\" onclick=\"location.href='profile_page'\">";
	    		str+="<i class=\"fa fa-user\" style=\"color:#e1ffff;\"></i></button></div>";
		    	str+="<div class=\"column\" id=\"i4\"><a href=\"LogoutServlet\">Logout</a></div></div></div>";
		    	document.getElementById("demo1").innerHTML = str;
		    }
	   };
	   xhttp.open("GET", "AuthorityStatus", true);
	   xhttp.send();
}