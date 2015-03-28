package org.can;

public class Player {
	private String name;
	private double injuryOdds;
	private double tacticGoodOdds;
	private String personalAbility;
	private double commercialEventsRateHighOdds;
	private double scandalWillAppearOdds;
	private String position;
	
	public Player(String name, double io, double tgo, String pa, double cerh, double swao, String po){
		this.name = name;
		this.injuryOdds = io;
		this.tacticGoodOdds = tgo;
		this.personalAbility = pa;
		this.commercialEventsRateHighOdds = cerh;
		this.scandalWillAppearOdds = swao;
		this.position = po;
	}
	
	public String getName(){
		return this.name;
	}
	
	public double getInjuryOdds(){
		return this.injuryOdds;
	}
	
	public double getNotInjueryOdds(){
		return 1-this.injuryOdds;
	}
	
	public double getTacticGoodOdds(){
		return this.tacticGoodOdds;
	}
	
	public double getTacitBadOdds(){
		return 1-this.tacticGoodOdds;
	}
	
	public String getPersonalAbility(){
		return this.personalAbility;
	}
	
	public double getCommercialEventRateHighOdds(){
		return this.commercialEventsRateHighOdds;
	}
	
	public double getCommercialEventRateLowOdds(){
		return 1-this.commercialEventsRateHighOdds;
	}
	
	public double getScandalWillAppearOdds(){
		return this.scandalWillAppearOdds;
	}
	
	public double getScandalWillNotAppearOdds(){
		return 1-this.scandalWillAppearOdds;
	}
	
	public String getPosition(){
		return this.position;
	}

}
