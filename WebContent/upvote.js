function upvote(upv,post_id)
{
	console.log(post_id);
	console.log(upv);
	var xhttp = new XMLHttpRequest();
 	xhttp.onreadystatechange = function() {
 		if (this.readyState == 4 && this.status == 200) {
 			console.log(this.responseText);
 			//var status=JSON.parse(this.responseText);
 			
 			console.log(status);
 			var check=status.status;
 			console.log(status);
 			//document.getElementById("body").innerHTML=check;
 			/*if(check==false){
 				document.getElementById("error").innerHTML="User id already exists";
 			}
 			else{
 				document.getElementById("error").innerHTML="";
 				
 				Str="<html><body><h3>Signed up successfully</h3>";
		 			Str+="<form action=\"Home\" action=\"POST\">" +
		 				"<button type=\"submit\">Go to Home</button><br><br></form></body></html>";
		 			document.getElementById("body").innerHTML=Str;
 			}*/
 		}
 	}
 	xhttp.open("GET", "upvote?post_id="+post_id+"&upvote="+upv, true);     
 	xhttp.send();

};