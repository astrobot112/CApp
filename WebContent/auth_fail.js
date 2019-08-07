function check_auth()
{
	console.log("done");
	var user_id = document.getElementById("user_id").value; 
	var password = document.getElementById("password").value; 
	console.log("user_id");
	console.log("password");
	
	var xhttp = new XMLHttpRequest();
 	xhttp.onreadystatechange = function() {
 		if (this.readyState == 4 && this.status == 200) {
 			console.log(this.responseText);
 			var status=JSON.parse(this.responseText);
 			var len=status.data.length;
 			console.log(status);
 			console.log(status.data.length);
 			
 			
 			//console.log(pd);
 			var check= status.status;
 			//document.getElementById("body").innerHTML=check;
 			if(len==0)
 				{
 				document.getElementById("ider").innerHTML="User doesn't exist!";
 				document.getElementById("pder").innerHTML="";
 				}
 			else {
 				var pd=status.data[0].user_id;
 				if(password!=pd){
 				document.getElementById("pder").innerHTML="Enter Correct Password";
 				document.getElementById("ider").innerHTML="";
 			}
 			else{
 				document.location.href="Home";
 				/*Str="<html><body><h3>Signed up successfully</h3>";
		 			Str+="<form action=\"Home\" action=\"POST\">" +
		 				"<button type=\"submit\">Go to Home</button><br><br></form></body></html>";
		 			document.getElementById("body").innerHTML=Str;
		 			console.log(status);*/
 			}
 			}
 		}
 	}
 	xhttp.open("GET", "login_query?user_id="+user_id+"&password="+password, true);     
 	xhttp.send();

};
