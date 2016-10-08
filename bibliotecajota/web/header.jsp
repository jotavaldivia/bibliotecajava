    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
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


  <h1 class="h11" style="color:  midnightblue"> Bienvenidos al sistema de biblioteca online</h1>
  <br>
  
  
  <br>

	
 
      
      
      
      
      <!-- Barra de Navegación -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Colegio Regional Del Maule</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="inicio.jsp">Inicio</a></li>
            <li><a href="Servlet_Libros?p=1">Libros</a></li>
              <li><a href="Servlet_Prestamos?p=1">Prestamos</a></li>
              
            
          </ul>
          <ul class="nav navbar-right top-nav">  
                <li>
                    <font color="white" style="background-color: #337ab7" >
                   <% 
                                         out.println("USUARIO :");
                                    if((String)session.getAttribute("nombre")!=null){
                                        out.println((String)session.getAttribute("nombre"));
                                    
                                        out.println("(((");
                                        out.println("<a  href = Servlet_Personas?p=2> Cerrar Sesión</a >");
                                        out.println(")))");
                                    }else{
                                %>
                              
                  
                    </font> 
                    <form action="Servlet_Personas?p=1" method="POST" id="signin" class="navbar-form pull-right form-horizontal" role="form">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input id="user" type="text" class="form-control input-sm" name="usu" value="" placeholder="Usuario">                                        
                            </div>

                            <div class="input-group input-group-sm">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input id="password" type="password" class="form-control input-sm" name="pass" value="" placeholder="Password">                                        
                            </div>

                            <button type="submit" class="btn btn-primary">Login</button>
                    </form>
                    <% 
                                if(request.getParameter("error")!=null)
                                    out.println(request.getParameter("error"));
                            
                            %>
                        
                    
                </li> 
                
                 
          </ul>  
                    
                 
        </div><!--/.nav-collapse -->
        
                <div>
                            <div class="large alert-info">
                                <a href="Servlet_Personas?p=6">¿Olvido Password?</a>
                            </div>
                            <div class="large alert-info">
                                <a href="Servlet_Personas?p=7">¿Regístrate?</a>
                            </div>
                            <div class="large alert-info">
                                <a href="Servlet_Personas?p=10">¿Desea actualizar Nombre de usuario?</a>
                            </div>
                 </div>
                        <% } %>
        
        
      </div>
    </nav>
      <!-- Fin Barra de Navegación -->