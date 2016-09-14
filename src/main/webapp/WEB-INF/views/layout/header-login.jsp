<!-- List of CSS -->
<!-- Bootstrap -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="resources/css/jumbotron.css" rel="stylesheet">
<link href="resources/css/navbar.css" rel="stylesheet">
<link href="resources/css/extra.css" rel="stylesheet">
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/css/wizard.css" rel="stylesheet">
<link href="resources/css/formValidation.min.css" rel="stylesheet">
<link href="resources/css/bootstrap-formhelper-min.css" rel="stylesheet">
<link href="resources/css/bootstrap-switch.css" rel="stylesheet">
<link href="resources/css/index.css" rel="stylesheet">

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
	<div class="navbar-header">
	  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
		<span class="sr-only">Toggle navigation</span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
	  </button>
	  <a class="navbar-brand" href="/addressmate/">Addressmate</a>
	</div>
	<div id="navbar" class="navbar-collapse collapse">
	  <form class="navbar-form navbar-right form-inline" action="/addressmate/login" method="POST" id="loginForm">
		<div class="form-group">
		  <input type="text" placeholder="Email" class="form-control" name="email">
		</div>
		<div class="form-group">
		  <input type="password" placeholder="Password" class="form-control" name="password">
		</div>
		<button type="submit" class="btn btn-success">Sign in</button>
	  </form>
	</div><!--/.navbar-collapse -->
  </div>
</nav>