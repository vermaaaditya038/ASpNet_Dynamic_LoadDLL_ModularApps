<!DOCTYPE HTML>
<!--
	Halcyonic by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->

<html>
	<head>
		<title>SPORTS STORE HOME</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<script src="js/jquery.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-layers.min.js"></script>
		<script src="js/init.js"></script>
		<noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-desktop.css" />
		</noscript>
		<!--[if lte IE 9]><link rel="stylesheet" href="css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
	</head>
	<body>
	
	<% if(getServletContext().getAttribute("session") == null)
	{
	response.sendRedirect("index.html");
	
	}
	
%>

		<!-- Header -->
			<div id="header-wrapper">
				<header id="header" class="alt">
					<div class="row">
						<div class="12u">
						
							<!-- Logo -->
								<h1><a href="#" id="logo">Welcome</a></h1>
							
							<!-- Nav -->
								<nav class="button special">
									<a href="index-home.jsp" class="button special">HOME</a>
									<a href="AboutUs.jsp" class="button special">ABOUT US</a>
									<a href="admin-home.html" class="button special">SEARCH</a>
									
									<a href="index.html?session=" class="button special">LOG OUT</a>
								<!-- <a href="onecolumn.html">One Column</a> -->	
								</nav>

						</div>
					</div>
				</header>
					
								<!-- Feature #1 -->
									<section class="wrapper style2 container special-alt">
									
										<h2>SPORTS STOP</h2>
										<p>
											This is SPORT STOP, The One stop shop for 
											 buying top of the class sports equipment. 
											 This website is a prototype version of a 
											 web application software which can be used 
											 effectively to search, monitor,track edit and 
											 add critical sales information for the 
											 company Sports Stop LLC.
										This website serves as a backend customer support 
										and monitoring portal for the employees at sports stop
										to do a variety of common functionalities.
										</p>
										<p>
											SPORTS STOP LLC is a wholly owned subsidiary. Sports Stop uses game-changing automation 
											technology for fulfillment centers that helps its parent firm to simplify operations 
											and reduce costs while increasing strategic 
											flexibility. Using hundreds of autonomous mobile robots and 
											sophisticated control on delivery of sports goods, the sports stop Fulfillment System enables 
											extremely fast cycle times with reduced labor requirements, from receiving to picking to shipping.
											 The result is a building that is quick and low-cost to set up, inexpensive to operate and easy to change anywhere in the world.
										<!-- <p> Project Members:</p>
										<h4>RANGESH (Analysis, Design,Implementation) </h4>
										<h4>ADITHYA(Testing, Implementation, Documentation)</h4>
										<h4>ISHIKA (Implementation, Documentation)</h4> 
										<h4> SYED(Testing, Documentation)</h4>-->
										
									</section>

							</div>
							
						
						</div>
					</div>
				</footer>
			</div>

		<!-- Copyright -->
			<div id="copyright" style="background-color:black">
				&copy; Untitled. All rights reserved. | Design: <a href="imdex-home.html">SPORTS STOP</a>
			</div>

	</body>
</html>