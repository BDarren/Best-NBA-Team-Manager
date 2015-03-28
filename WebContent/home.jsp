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
          <a class="navbar-brand" href="#">INFSCI 2130</a>
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
<div class="container">

    <h1>
        Please select a position:  
      </h1>
  <form action="index.jsp">
  <select name="item">
    <option value="C">C</option>
    <option value="PF">PF</option>
    <option value="SF">SF</option>
    <option value="SG">SG</option>
    <option value="PG">PG</option>
  </select>
  <br/>
  <br/>
  <input type="submit" class="btn btn-default" value="Submit">
</form>    
  
</div>

</body>
</html>













