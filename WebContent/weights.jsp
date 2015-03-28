<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List" %>
<%@ page import="org.can.DBConnection"%>
<%@ page import="org.can.Player"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="smile.SMILEException"%>
<%@ page import="smile.Network"%>
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
  <h2>Comparison</h2> 
  <form name="setWeight" action="Weight" method="post">        
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Name</th>
        <th>InjuryOdds</th>
        <th>TacticGoodOdds</th>
        <th>PersonalAbility</th>
        <th>CommercialEventsRateHighOdds</th>
        <th>ScandalWillAppearOdds</th>
        <th>Score</th>
        
      </tr>
    </thead>
    <tbody>
    <% List<Player> players  = (List<Player>)request.getAttribute("playerList");
    	HashMap<String, Double> score = (HashMap<String, Double>)request.getAttribute("score");
			for(Player e: players){%>
      <tr>
        <td><%=e.getName() %></td>
        <td><%=e.getInjuryOdds() %></td>
        <td><%=e.getTacticGoodOdds() %></td>
        <td><%=e.getPersonalAbility() %></td>
        <td><%=e.getCommercialEventRateHighOdds() %></td>
        <td><%=e.getScandalWillAppearOdds() %></td>
        <td><%=score.get(e.getName()) %></td>
        
        
      </tr>
      <% 
			}
		%>
    </tbody>
  </table>
  <button type="submit" class="btn btn-default">Show results</button></a>
  </form>
</div>

</body>
</html>