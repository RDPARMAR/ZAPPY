<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>Big store a Ecommerce Online Shopping Category Flat Bootstrap Responsive Website Template | Kitchen :: w3layouts</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta property="og:title" content="Vide" />
<meta name="keywords" content="Big store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- js -->
   <script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<script>
    function calc(i)
    {
    	var q=document.getElementById("q"+i).value;
    	var up=document.getElementById("up"+i).value;
    	document.getElementById("total"+i).value=q*up;
    	
    }
    
    <%
    String user =(String)session.getAttribute("email");
    String msg=(String)request.getAttribute("msg");
    if(msg!=null){
    %>
    <script>
    alert("<%=msg%>")</script>
    <%}
    %>

</script>
<%@page import="java.util.ArrayList,Bean.AddBean"%>
<!-- start-smoth-scrolling -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Noto+Sans:400,700' rel='stylesheet' type='text/css'>
<!--- start-rate---->
<script src="js/jstarbox.js"></script>
	<link rel="stylesheet" href="css/jstarbox.css" type="text/css" media="screen" charset="utf-8" />
		<script type="text/javascript">
			jQuery(function() {
			jQuery('.starbox').each(function() {
				var starbox = jQuery(this);
					starbox.starbox({
					average: starbox.attr('data-start-value'),
					changeable: starbox.hasClass('unchangeable') ? false : starbox.hasClass('clickonce') ? 'once' : true,
					ghosting: starbox.hasClass('ghosting'),
					autoUpdateAverage: starbox.hasClass('autoupdate'),
					buttons: starbox.hasClass('smooth') ? false : starbox.attr('data-button-count') || 5,
					stars: starbox.attr('data-star-count') || 5
					}).bind('starbox-value-changed', function(event, value) {
					if(starbox.hasClass('random')) {
					var val = Math.random();
					starbox.next().text(' '+val);
					return val;
					} 
				})
			});
		});
		</script>
<!---//End-rate---->




<a href="offer.html"><img src="images/download.png" class="img-head" alt=""></a>
<div class="header">

		<div class="container">
			
			<div class="logo">
				<h1 ><a href="index.jsp"><b>F<br>O<br>O<br>D</b>Zappy<span>Makes you Happy</span></a></h1>
			</div>
			<div class="head-t">
				
				</ul>		
			</div>
			
			<div class="header-ri">
				<ul class="social-top">
					<li><a href="#" class="icon facebook"><i class="fa fa-facebook" aria-hidden="true"></i><span></span></a></li>
					<li><a href="#" class="icon twitter"><i class="fa fa-twitter" aria-hidden="true"></i><span></span></a></li>
					<li><a href="#" class="icon pinterest"><i class="fa fa-pinterest-p" aria-hidden="true"></i><span></span></a></li>
					<li><a href="#" class="icon dribbble"><i class="fa fa-dribbble" aria-hidden="true"></i><span></span></a></li>
				</ul>	
			</div>

</head>
<body>

					<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
						<ul class="nav navbar-nav ">
							<li ><a href="index.jsp" class="hyper "><span>Home</span></a></li>	
						    <li><a href="ZappyProductStore" class="hyper"> <span>Zappy Product Store</span></a></li>
							
							<li><a href="contact.html" class="hyper"><span>Contact Us</span></a></li>
						</ul>
					</div>
					</nav>
					 		
</div>
  <!---->

   <%-- <%
							if(user==null){%>
								<li><a href="login.jsp?pagename=indexnew.jsp">Login</a></li> 
								<li><a href="login.jsp?pagename=indexnew.jsp">Sign Up</a></li>
								<%}else{%>
									<li>Welcome <%=user %></li> 
									<li><a href="CustomerLogout">Logout</a></li>
									<li><a href = "UpdateUserProfile">Update Profile</a></li>
								<%} %>
		 --%>
   


		<style>
table {
	text-align: center;
}
th{
  text-align:center; 
}
</style>

	



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
								
								<th>Weight</th>
								<th>Quantity</th>
								<th>Product Price</th>
								<th>total</th>
								<th></th>
								<th>Image</th>
								<th>Remove</th>
								
								
							</tr>
							
							<%
							ArrayList<AddBean> list=(ArrayList<AddBean>)request.getAttribute("data");
									if(list!=null){
										int x =1;
										int i=0;
							for(AddBean b : list){
								
							%>
							<tr>
							    
								<td><%=x %></td>
								<td><%=b.getPname() %></td>
								
								<td><%=b.getWeight()%></td>
								
								
								 <td><input type="number" id="q<%=i%>"  value="<%=b.getQuantity() %>" onchange="calc(<%=i%>)"/></td>
                                   <td><input type="text" id="up<%=i%>" value="<%=b.getPrice()%>" /></td>
                                   <td><input type="text" id="total<%=i%>"  value="<%=Integer.parseInt(b.getPrice())*Integer.parseInt(b.getQuantity())%>" /></td>
								
								<td>
								
								<!-- <div class="quantity buttons_added">
  <input id="minus" type="button" class="minus" value="-">
  <input id="theInput" type="number" size="4" class="input-text qty text" title="Qty" value="1" min="0" step="1">
  <input id="plus" type="button" class="plus" value="+">
</div> -->
</td>
								
								
								<td><img src="imgupload/<%=b.getImage()%>" height="100" width="100"></td>
								<td><a href ="RemoveCart?pid=<%=b.getPid() %>">Remove</a></td>
								
							</tr>
							<%
							x++;i++;}}%>
						</table>
						<p>&nbsp;</p>
					</center>
				</div>
			</div>
		</div>
		<center>
		<form action="PlacedOrder" method="get">
<input type="submit" value="Place Order" class="btn btn-primary"  style="background-color:red;color: white;padding:6px;width: 100px"> 
</form>   
  <!--  <a href="ZappyProductStore">CONTINUE SHOPPING</a> -->
   <td><form action="ZappyProductStore" method="get"><input type="submit" value="Continue Shopping" style="background-color:red;color: white;padding: 2px;width:135px"/></form></td>
   </center>
	</section>





		
		
				
</body>
</html>
</body>
</html>