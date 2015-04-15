<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="generator" content="Bootply" />
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<link href="css/styles.css" rel="stylesheet">
<link href="http://hayageek.github.io/jQuery-Upload-File/uploadfile.min.css" rel="stylesheet">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://rawgithub.com/hayageek/jquery-upload-file/master/js/jquery.uploadfile.min.js"></script>
<script src="js/createUser.js"></script>

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="WelPageLead.jsp">SGC</a>
    </div>
    <div>
      <ul class="nav navbar-nav navbar-right">
      <li> <a class="navbar-brand" id ="modificacion "href="#">Bienvenido <%
    out.println(session.getAttribute("user"));
    %></a></li>
        <li><a href="index.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
  <div class="container_fluid">
  <div class="jumbotron">
  <h1 align="center">Administraci&oacute;n de Contenidos</h1>
  </div>
  </div>

    <div class="container-fluid">
      
      <div class="row row-offcanvas row-offcanvas-left">
        
         <div class="col-sm-3 col-md-2 sidebar-offcanvas" id="sidebar" role="navigation">
           
            <ul class="nav nav-sidebar">
             <li> <a href="#" id="formats"><h4>Formatos</h4></a></li>
               <%
             if("N".equals(session.getAttribute("leadProcess"))) {
                 %> <li><a href="#" id="notifications"><h4>Notificaciones</h4></a></li>
                 <%
                }
              %>
                <li><a href="#"><h4>Plan de Acci�n</h4></a></li>
                 <li><a href="#"><h4>Acciones Correctivas</h4></a></li>
              <li><a href="#"><h4>Indicadores</h4></a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-md-10 main">
      <div class="container">
       <form class="form-horizontal">
       <div class="form-group">
       <div class="col-md-6">
     <h2>Modificar Perfil</h2>
    </div>
   </div>
  <div class="form-group">
    <label class="col-md-3 control-label">Nombre Usuario</label>
    <div class="col-md-3">
      <input type="text" class="form-control" value="<% out.println(session.getAttribute("nombre"));
    %>"id="nombreUsuario" name="nombreUsuario"
             placeholder="Nombre del Usuario">
    </div>
  </div>
    <div class="form-group">
    <label class="col-md-3 control-label">Email</label>
    <div class="col-md-3">
      <input type="text" class="form-control"value="<% out.println(session.getAttribute("user"));%>" id="email" name="email"
             placeholder="Email">
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-md-3 control-label">Sexo</label>
    
 <div class="col-lg-3">   
   <label class="checkbox-inline">
  <input type="radio"  id="sexo" name="sexo" value="M" <% if(session.getAttribute("sex").equals("M")){
	  out.println("checked");
  }%>> Masculino
</label>

<label class="checkbox-inline">
  <input type="radio"  id="sexo" name="sexo" value="F" <% if(session.getAttribute("sex").equals("F")){
	  out.println("checked");
  }%>> Femenino
</label>
      </div>
  </div>
  
  <div class="form-group">
    <label class="col-md-3 control-label">ID Proceso</label>
    <div class="col-lg-3">
      <input type="text" class="form-control"value="<%out.println(session.getAttribute("process"));
    %>" id="IdProceso" name="IdProceso" placeholder="Id del Proceso" disabled>
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-md-3 control-label">Lider de Proceso</label>
    
 <div class="col-lg-3">   
   <label class="checkbox-inline">
  <input type="radio"  id="esLider" name="esLider" value="Y" <% if(session.getAttribute("leadProcess").equals("Y")){
	  out.println("checked");
  }%> disabled> Si
</label>

<label class="checkbox-inline">
  <input type="radio"  id="esLider" name="esLider" value="N" <% if(session.getAttribute("leadProcess").equals("N")){
	  out.println("checked");
  }%> disabled> No
</label>
      </div>
  </div>
  
  <div class="form-group">
    <label class="col-md-3 control-label">Contrase�a</label>
    <div class="col-lg-3">
      <input type="text" class="form-control" value="<% out.println(session.getAttribute("contrase�a"));
    %>"id="contra" name="contra"  placeholder="Contrase�a">
    </div>
  </div>
  <div class="form-group">
    <div class="col-lg-offset-2 col-lg-10">
       <input type="button" value="Modificar" id="modificacion" class="btn btn-success"/>
      
    </div>
  </div>
</form>

    </div>
</div>
</div>
</div>
 
</body>
</html>