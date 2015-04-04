<%@ page import="java.sql.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		
		<title>Best NBA Manager</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="css/styles.css" rel="stylesheet">
    <link href="css/jumbotron.css" rel="stylesheet">
	</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="home.jsp">INFSCI 2130</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          
        </div><!--/.navbar-collapse -->
      </div>
    </nav>


<!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>Best NBA Manager</h1>
        <p>Group Members: Dalun Bian, Qilu Cao, Ming Chi, Fei Han, Can Pan, Zhijie Yang</p>
        
      </div>
    </div>
<div class="container marketing">

  <!-- Three columns of text below the carousel -->
    <h1>
        Step 1: Choose palyers to compare  
      </h1>
      <br/>
  <form name="choosePlayers" action="SimpleServletPath" method="post">
  <div class="row">

<%@page import="org.can.DBConnection"%>
<%@page import="org.can.Player"%>
<%
String position=request.getParameter("item");
DBConnection player=new DBConnection("SELECT name FROM Players where position='"+position+"'");
ResultSet rs=player.getData();

try{
	while(rs.next()){
	String name=rs.getString("name");
    out.print("<tr>");
    
    %>
    <div class="col-md-4 text-center">
      <img class="img-circle" src="http://placehold.it/140x140">
      
    <div class="checkbox">
      <label><input type="checkbox" value=<%out.print(name);%> name="player" ></label>
      <h2><%out.print(name); %></h2>
      <br>
    </div>
    </div>
    <% 
    out.print("</tr>");
    
    }
}catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

  player.close();

%>
  </div> 
  <h1>
        Step 2: Specify weights for performance:     
      </h1>
      <br/>
  <div class="input-group">
  <span class="input-group-addon" id="basic-addon1">Game performance</span>
  <input type="text" name="gamep" class="form-control" placeholder="Weight" aria-describedby="basic-addon1">
</div>
<br/>
<div class="input-group">
  <span class="input-group-addon" id="basic-addon1">Social performance</span>
  <input type="text" name="socialp" class="form-control" placeholder="Weight" aria-describedby="basic-addon1">
</div>
   
  <br/>  
   <button type="submit" class="btn btn-default">Submit</button></a>


  </form>
</div>

</body>
</html>













