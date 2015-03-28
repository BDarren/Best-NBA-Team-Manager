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
		<link rel="alternate" type="application/rss+xml" title="RSS 2.0" href="http://www.datatables.net/rss.xml">
		<link rel="stylesheet" type="text/css" href="/media/css/site.css?_=49e03a77423748a3bf40c035be088f3b">
		<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/plug-ins/f2c75b7247b/integration/bootstrap/3/dataTables.bootstrap.css">
		<link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
			
		<script type="text/javascript" src="/media/js/site.js?_=1b28ecea55524280aab311976b223951"></script>
		<script type="text/javascript" src="/media/js/dynamic.php?comments-page=examples%2Fstyling%2Fbootstrap.html" async=""></script>
		<script type="text/javascript" language="javascript" src="//code.jquery.com/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" language="javascript" src="//cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript" language="javascript" src="//cdn.datatables.net/plug-ins/f2c75b7247b/integration/bootstrap/3/dataTables.bootstrap.js"></script>
		<script type="text/javascript" language="javascript" src="../resources/demo.js"></script>
		<script type="text/javascript" class="init">

	$(document).ready(function() {
		$('#example').dataTable();
	} );

		</script>
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="css/styles.css" rel="stylesheet">
		<!-- Latest compiled and minified CSS -->

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
  <table  id="example" class="table table-striped table-bordered">
    <thead>
      <tr>
        <th>Name</th>
        <th> InjuryOdds</th>
        <th>TacticGoodOdds</th>
        <th>PersonalAbility</th>
        <th>CommercialEventsRateHighOdds</th>
        <th>ScandalWillAppearOdds</th>
        <th>Position</th>
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
        <td><%=e.getPosition() %></td>
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