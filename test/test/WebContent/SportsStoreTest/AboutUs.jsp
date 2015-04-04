<!DOCTYPE HTML>
<!--
	Halcyonic by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>ABOUT US</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<script src="js/jquery.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-layers.min.js"></script>
		<script src="js/init.js"></script>
		<noscript>
			<link rel="stylesheet" href="css/skel-halcyonic.css" />
			<link rel="stylesheet" href="css/style-halcyonic.css" />
			<link rel="stylesheet" href="css/style-desktop.css" />
		</noscript>
		<!--[if lte IE 9]><link rel="stylesheet" href="css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
	</head>
	<body class="subpage">

<% if(getServletContext().getAttribute("session") == null)
	{
	response.sendRedirect("index.html");
	
	}%>
		<!-- Header -->
			<div id="header-wrapper">
				<header id="header" class="alt">
					<div class="row">
						<div class="12u">

							<!-- Logo -->
								<h1><a href="#" id="logo">SPORTS STOP</a></h1>
							
							<!-- Nav -->
								<nav class="button special">
									<a href="index-home.jsp" class="button special">HOME</a>
									<a href="AboutUs.jsp" class="button special">ABOUT US</a>
									<a href="admin-home.html" class="button special">SEARCH</a>
									
									
									<a href="index.html?session=" class="button special">LOG OUT</a>
									
								</nav>

						</div>
					</div>
				</header>
			</div>

		<!-- Content -->
			<div id="content-wrapper">
				<div id="content">
					<div class="container">
						<div class="row">
							<div class="9u">
								
								<!-- Main Content -->
									<section class="wrapper style2 container special-alt">
										<header>
											<h2>DESCRIPTION</h2>
											
										</header>
										
										<p>
											Sports Stop was founded on a better approach to order fulfillment solutions on sports items - 
											a philosophy that simultaneously breaks many existing constraints and takes 
											fulfillment back to its simple basics. sports stop can be grown to a 
											great extent and make it a  widely recognized solution for eCommerce fulfillment of sports products 
											and split-case each every item picking applications of all types.
										</p>
										<h3>WE BELIEVE:</h3>
										<p>
										
											<h4>Products Should Organize Themselves:</h4>
											Current solutions store items in fixed locations which results in wasted time
											 and energy spent keeping the facility organized. 
											With Sports Stop, inventory is free from physical location constraints, locations and 
											positions are virtual and move and adapt to the products.  The result is that
											 any item can be delivered to any operator at any time. 							
										</p>
										<p>
											<h4>One Piece of Equipment & One Process Should Handle All Products:</h4>
											Sports Stop believes that one simple process and set of material handling equipment
											 should be used to store, move and sort all items in the warehouse so facility
 											managers can focus on the customer, not the complexity of their equipment
										</p>
										<p>
											<h4>Orders Should Be Filled When the Customers Want Them:</h4>
											Sport Stop believes that orders should drop directly from customers through to 
											pack operators resulting in shorter cycle times and same-day fulfillment.
  											Sports Stop customers view their supply chain as a competitive advantage. 							
										</p>
									</section>

							</div>
					</div>
					</div>
				</div>
			</div>

		<!-- Copyright -->
			<div id="copyright" style="background-color:black">
				&copy; Untitled. All rights reserved. | Design: <a href="index-home.html">SPORTS STOP</a>
			</div>

	</body>
</html>