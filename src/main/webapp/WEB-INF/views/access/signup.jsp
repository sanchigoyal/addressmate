<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<link rel="icon" href="resources/images/logo/addressmate_favicon.ico">
    <title>Addressmate</title>
  </head>

  <body>
  
	<!-- Header -->
    <%@include file="../layout/header-login.jsp" %>
	<!-- -- --- -->
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h3 class="text-center">
					   <b>BUILD</b> YOUR PROFILE <br>
					   <small>This information will let us know more about you.</small>
					</h3>
				</div>
				<div class="col-md-12">
					<form class="form-horizontal" action="/addressmate/register" id="registrationForm" method="post">
						<h4 class="text-center"> Let's start with the basic information</h4>
						<div class="col-sm-4 col-sm-offset-2 picture-container">
							<div class="picture not-active">
								<img src="resources/images/others/default-avatar.png" class="picture-src" id="wizardPicturePreview">
								<input type="file" id="wizard-picture" name="uploadimage">
							</div>
						</div>
						<div class="col-sm-4">
							<div class="required form-group-sm form-group">
							   <label for="firstname" class="control-label">First Name</label>
							   <input type="text" id="firstname" name="firstName" class="form-control input-sm" placeholder="Enter First Name..."/>
							 </div>
							 <div class="required form-group form-group-sm">
							   <label for="lastname" class="control-label">Last Name</label>
							  <input type="text" id="lastname" name="lastName" class="form-control input-sm" placeholder="Enter Last Name..."/>
							 </div>
						</div>
						<div class="col-sm-8 col-sm-offset-2">
							<div class="required form-group form-group-sm">
							   <label for="email" class="control-label">Email</label>
							   <input id ="email" type="email" class="form-control input-sm" name="email" placeholder="Enter Email... " value="${user.email}"/>
							 </div>
						</div>
						<div class="col-sm-4 col-sm-offset-2">
							<div class="required form-group form-group-sm">
							   <label for="password" class="control-label">Password</label>
							   <input type="password" class="form-control input-sm" id="password" name="password" placeholder="Enter Password..." value="${user.password}"/>
							 </div>
						</div>
						<div class="col-sm-4">
							<div class="required form-group form-group-sm">
							   <label for="repassword" class="control-label">Re-Enter Password</label>
							   <input type="password" class="form-control input-sm"  name="repassword" placeholder="Re-Enter Password...">
							 </div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-8">
								<button type="submit" class="btn btn-success btn-jumbo"> Sign up for Addressmate</button>
								<p class="text-center">By clicking "Sign up for Addressmate", you agree to our terms of service and privacy policy. We'll occasionally send you account related emails.</p>
							</div>
					    </div>					
					</form>
				</div>
			</div>
		</div>
	<!-- Footer -->
    <%@include file="../layout/footer-login.jsp" %>
    <script src="resources/js/signup-min.js"></script>
  </body>
</html>