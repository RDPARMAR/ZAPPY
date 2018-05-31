<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="java.util.ArrayList,Bean.AddBean"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<%@page import="java.util.ArrayList,Bean.AddBean"%>
<%@page import="java.util.ArrayList,Dao.MyDao" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VIEW CART</title>
</head>
<body>

<form action="ShowCart" method="get">



<section id="showcart" class="showcart">
		<div class="container">
			<div class="row">
				<div class="viewcart_content text-center">

					<center>
						<h2>Show cart</h2>
						<table border="1">
							<tr>
								
								<th>S.NO</th>
								<th>Product Name</th>
								<th>Product Price</th>
								<th>Weight</th>
								<th>Quantity</th>
								<th>Image</th>
								<th>Remove</th>
								
								
							</tr>
							
							<%
							ArrayList<AddBean> list=(ArrayList<AddBean>)request.getAttribute("data");
									if(list!=null){
										int x =1;
							for(AddBean b : list){
								
							%>
							<tr>
							    
								<td><%=x %></td>
								<td><%=b.getPid() %></td>
								<td><%=b.getPrice()%></td>
								<td><%=b.getQuantity() %></td>
								<td>
								
								<div class="quantity buttons_added">
  <input id="minus" type="button" class="minus" value="-">
  <input id="theInput" type="number" size="4" class="input-text qty text" title="Qty" value="1" min="0" step="1">
  <input id="plus" type="button" class="plus" value="+">
</div>
<script>
var input = document.getElementById('theInput');
document.getElementById('plus').onclick = function(){
    input.value = parseInt(input.value, 10) +1
}
document.getElementById('minus').onclick = function(){
    input.value = parseInt(input.value, 10) -1
}
</script>
								<%=b.getQuantity() %></td>
								
								
								<td><img src="imgupload/<%=b.getImage()%>" height="100" width="100"></td>
								<td><a href ="remove?ProductId=<%=b.getPid() %>">Remove</a></td>
								
							</tr>
							<%
							x++;}}%>
						</table>
						<p>&nbsp;</p>
					</center>
				</div>
			</div>
		</div>
		<center>
 <input type="submit" value="PLACED ORDER" class="btn btn-primary">  <a href="index.jsp#portfolio">CONTINUE SHOPPING</a>
</center>
	</section>


</form>

</body>
</html>

</body>
</html>