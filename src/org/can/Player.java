package org.can;

public class Player {
	private String name;
	private double injuryOdds;
	private double tacticGoodOdds;
	private double personalAbilityE;
	private double personalAbilityG;
	private double commercialEventsRateHighOdds;
	private double scandalWillAppearOdds;
	private String position;
	
	public Player(String name, double io, double tgo, double pae, double pag, double cerh, double swao, String po){
		this.name = name;
		this.injuryOdds = io;
		this.tacticGoodOdds = tgo;
		this.personalAbilityE = pae;
		this.personalAbilityG = pag;
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
	
	public double getPersonalAbilityEOdds(){
		return this.personalAbilityE;
	}
	
	public double getPersonalAbilityGOdds(){
		return this.personalAbilityG;
	}
	
	public double getPersonalAbilityAOdds(){
		return 1-this.personalAbilityE-this.personalAbilityG;
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
