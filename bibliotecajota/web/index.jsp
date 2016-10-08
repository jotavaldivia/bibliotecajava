    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <html>
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>biblioteca.com</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/bootstrap-theme.min.css" rel="stylesheet"/>
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/navbar-fixed-top.css" rel="stylesheet">
<!-- Bootstrap de login  -->
<link href="css/j.css" rel="stylesheet" type="text/css"/>
<script src="js/j.js" type="text/javascript"></script>
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
      
      <h1 class="h11" style="color:  midnightblue"> Bienvenidos al sistema de biblioteca online</h1>
   <br>
 <h3 class="h33" style="color:  midnightblue"> Estimados alumnos para hacer ingreso al sistema deberán
      solicitar registro en la administración del establecimiento</h3>
 <br>
 <div style="color: red;text-align: center" >
         <% 
                                if(request.getParameter("error")!=null)
                                    out.println(request.getParameter("error"));
                            
                            %>
     
 </div>
 
  <div class="container"><div>
    
   </div>
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
            
            
            <form class="form" role="form" method="post" action="Servlet_Personas?p=1" accept-charset="UTF-8" id="login-nav">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="text" class="form-control" id="user" name="usu" placeholder="Nombre" required>
                <input type="password" id="password" class="form-control"  name="pass" placeholder="Contraseña" required>
                <div id="remember" class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                  
                   
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Ingresar</button>
             
            </form><!-- /form -->
      
            
            
            
            <a href="Servlet_Personas?p=6" class="forgot-password">
                Olvidaste tu contraseña?
            </a>
        </div><!-- /card-container -->
         
          
    </div><!-- /container -->

    <!-- Fin contenido de la página -->
       
  </body>
    </html>
     
    
