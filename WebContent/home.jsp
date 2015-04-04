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
		<link href="css/modern-business.css" rel="stylesheet">
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

<!-- Header Carousel -->
    <header id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
             <div class="item active">
                <div class="fill" style="background-image:url('http://www.sportsintofaith.com/isfs/wp-content/uploads/2014/01/Basketball-Court1.jpg');"></div>
                <div class="carousel-caption">
                    <h2>Best NBA Manager</h2>
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('http://d13beo3f7vpmvd.cloudfront.net/wp-content/uploads/2015/02/reddit-nba.jpg');"></div>
                <div class="carousel-caption">
                    <h2>Best NBA Manager</h2>
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('http://wallpic.us/wp-content/uploads/2014/04/Basketball-NBA-Logo-Wallpaper-Desktop.jpg');"></div>
                <div class="carousel-caption">
                    <h2>Best NBA Manager</h2>
                </div>
            </div>

        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>
    </header>


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
<script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Script to Activate the Carousel -->
    <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>
</body>
</html>













