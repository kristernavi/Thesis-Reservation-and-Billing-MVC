<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bodare Login Form</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" 
        href='<c:url value="/assets/assets/bootstrap/css/bootstrap.min.css"/>'
       >
        <link rel="stylesheet" 
        href='<c:url value="/assets/assets/font-awesome/css/font-awesome.min.css"/>'
       >
		<link rel="stylesheet"
		 href='<c:url value="/assets/assets/css/form-elements.css"/>'
		 >
        <link rel="stylesheet" 
         href='<c:url value="/assets/assets/css/style.css"/>'
        >

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <!-- <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png"> -->

    </head>

    <body>

        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                	
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							     Bodare Pension House</h1>
                            <div class="description">
                            	<p>
	                            	Welcome to the <strong>"Administrator Login Panel"</strong>! You can always go back to 
	                            	the <a href="index.html" target="_blank"><strong>Home Page</strong></a>.
	                            	
                            	</p>
                            </div>
                        </div>
                    </div>
					
                        <div class="col-sm-6" style="width: 930px;padding-left: 250px;">
                        	<div class="form-box">
	                        	<div class="form-top">
	                        		<div class="form-top-left">
	                        			<h3>Bodare Login Form</h3>
	                            		<p>Enter username and password to log on:</p>
	                            		 <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
      <font color="red">
        Your login attempt was not successful due to <br/><br/>
        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
      </font>
    </c:if>
	                        		</div>
	                        		<div class="form-top-right">
	                        			<i class="fa fa-key"></i>
	                        		</div>
	                            </div>
	        
	                            <div class="form-bottom">
				                    <form role="form" action="j_spring_security_check" method="post" class="login-form">
				                    	<div class="form-group">
				                    		<label class="sr-only" for="form-username">Username</label>
				                        	<input type="text" name="j_username" placeholder="Username..." class="form-username form-control" id="form-username">
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-password">Password</label>
				                        	<input type="password" name="j_password" placeholder="Password..." class="form-password form-control" id="form-password">
				                        </div>
				                        <button type="submit" class="btn">LOGIN</button>
				                    </form>
			                    </div>
		                    </div>
		                
	
	                        
                        </div>
                       


        <!-- Javascript -->
        <script src='<c:url value="/assets/assets/js/jquery-1.11.1.min.js"/>'></script>
        <script src='<c:url value="/assets/assets/bootstrap/js/bootstrap.min.js"/>'></script>
          <script src='<c:url value="/assets/assets/js/scripts.js"/>'></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>