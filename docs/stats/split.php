<?php
$nameFile = file('season.11.csv');


for($i = 0; $i < 5; $i++){
	$filename = "season.1".($i+1).".csv";
	$thisYear = file($filename);
	foreach(
?>
