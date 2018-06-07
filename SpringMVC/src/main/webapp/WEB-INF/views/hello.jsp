<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>
<body onload="load();">
	<input type="hidden" id="user_id">
	Name : <input type="text" name ="user_name" id="name" required ="required">
	Email : <input type="email" id="email" name="email_user" required="required">
	<button onclick="submit();">Submit</button>
	<table id="table" border="1" bordercolor="777">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<tr>
			<td>Diae</td>
			<td>diae@diae</td>
			<td>Edi</td>
			<td>Del</td>
		</tr>
	</table>
	<script type="text/javascript">
		data = "";
		submit = function() {
			$.ajax({
				url:'saveOrUpdate',
				type:'POST',
				data:{user_id:$("#user_id").val(), user_name:$("#name").val(), email_user:$("#email").val()},
				success: function (response) {
					alert(response.message);
					load();
					
				}
			});
		}
			
		delete = function(id) {
			$.ajax({
				url:'delete',
				type:'POST',
				data:{user_id:id}
				success: function(response){
					alert(response.message);
					load();
				}
			});
		}	
		
		edit = function(index) {
			$("#user_id").val(data[index].user_id);
			$("#name").val(data[index].user_name);
			$("#email").val(data[index].email_user);
		}
		
		load = function() {
			$.ajax({
				url:'list',
				type:'POST',
				success : function(response) {
					data: response.data;
					$('.tr').remove();
					for(i=0; i<reponse.data.lengh; i++){
						$("#table").append("<tr class='tr'> <td>"+response.data.user_name+ "</td> <td>"+response.data.email_user+"</td> <td><a href='#' onclick= edit("+i+");> Edit </a> </td> <td> <a href='#' onclick= 'delete_("+response.data.user_id+");'> Delete </a></td></tr>");
					}
				}
			});
			
		}
		
	</script>
</body>
</html>