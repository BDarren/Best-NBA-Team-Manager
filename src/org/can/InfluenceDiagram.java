package org.can;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import smile.Network;
import smile.SMILEException;


public class InfluenceDiagram {
	
	public HashMap<String, Double> constructDiagram(List<Player> playerList, double weight){
		HashMap<String, Double> res = new HashMap<String, Double>();
		try {
			
			Network net = new Network();
			Random generator = new Random();
			
			net.addNode(Network.NodeType.List, "Player");
			net.addNode(Network.NodeType.Cpt, "Tactic_Agreement");
			net.addNode(Network.NodeType.Cpt, "Injury");
			net.addNode(Network.NodeType.TruthTable, "Personal_Ability");
			net.addNode(Network.NodeType.Cpt, "Future_Game_Performance");
			
			net.addNode(Network.NodeType.Cpt, "Commercial_Event");
			net.addNode(Network.NodeType.Cpt, "Scandal");
			net.addNode(Network.NodeType.Cpt, "Future_Social_Performance");
			
			net.addNode(Network.NodeType.Table, "Total_Expected_Value");
			
			int length = playerList.size();
			
			double[] aTacticAgreementDef = new double[2*length];
			double[] aInjuryDef = new double[2*length];
			double[] aPersonalAbilityDef = new double[5*length];
			for(int i=0; i<aPersonalAbilityDef.length; i++){
				aPersonalAbilityDef[i] = 0;
			}
			//double[] aFutureGamePerformanceDef = {};
			double[] aFutureGamePerformanceDef = new double[60];
			for(int i=0; i<60; i++){
				if((i+1)%3==0){
					aFutureGamePerformanceDef[i] = 1-aFutureGamePerformanceDef[i-1]-aFutureGamePerformanceDef[i-2];
				}
				else{
					aFutureGamePerformanceDef[i] = generator.nextDouble()*(0.5);
				}
			}
			
			double[] aCommercialEventDef = new double[2*length];
			double[] aScandalDef = new double[2*length];
			//double[] aFutureSocialPerformanceDef = {};
			double[] aFutureSocialPerformanceDef = new double[12];
			for(int i=0; i<12; i++){
				if((i+1)%3==0){
					aFutureSocialPerformanceDef[i] = 1-aFutureSocialPerformanceDef[i-1]-aFutureSocialPerformanceDef[i-2];
				}
				else{
					aFutureSocialPerformanceDef[i] = generator.nextDouble()*(0.5);
				}
			}
			double goodValueSum = 4000;
			double fairValueSum = 2000;
			double poorValueSum = 1000;
			double goodGP = goodValueSum*weight;
			double goodSP = goodValueSum*(1-weight);
			double fairGP = fairValueSum*weight;
			double fairSP = fairValueSum*(1-weight);
			double poorGP = poorValueSum*weight;
			double poorSP = poorValueSum*(1-weight);

			
			
			
			double[] aTotalExpectedValueDef = {goodGP+goodSP,goodGP+fairSP,goodGP+poorSP,fairGP+goodSP,fairGP+fairSP,fairGP+poorSP,poorGP+goodSP,poorGP+fairSP,poorGP+poorSP};
			
			Player p;
			
			for(int i=0; i<length; i++){
				p = playerList.get(i);
				net.addOutcome("Player", p.getName());	
				aTacticAgreementDef[2*i] = p.getTacticGoodOdds();
				aTacticAgreementDef[2*i+1] = p.getTacitBadOdds();
				aInjuryDef[2*i] = p.getInjuryOdds();
				aInjuryDef[2*i+1] = p.getNotInjueryOdds();
				aCommercialEventDef[2*i] = p.getCommercialEventRateHighOdds();
				aCommercialEventDef[2*i+1] = p.getCommercialEventRateLowOdds();
				aScandalDef[2*i] = p.getScandalWillAppearOdds();
				aScandalDef[2*i+1] = p.getScandalWillNotAppearOdds();
				String PA = p.getPersonalAbility();
				if(PA.equals("Outstanding")){
					aPersonalAbilityDef[5*i] = 1;
				}
				else if(PA.equals("Excellent")){
					aPersonalAbilityDef[5*i+1] = 1;
				}
				else if (PA.equals("Good")){
					aPersonalAbilityDef[5*i+2] = 1;
				}
				else if (PA.equals("Average")){
					aPersonalAbilityDef[5*i+3] = 1;
				}
				else if (PA.equals("Below_Average")){
					aPersonalAbilityDef[5*i+4] = 1;
				}
				
			}					
			net.deleteOutcome("Player", 0);
			net.deleteOutcome("Player", 0);
			
			net.setOutcomeId("Tactic_Agreement", 0, "Good");
			net.setOutcomeId("Tactic_Agreement", 1, "Bad");
			
			net.setOutcomeId("Injury", 0, "Yes");
			net.setOutcomeId("Injury", 1, "No");
			
			net.setOutcomeId("Personal_Ability", 0, "Outstanding");
			net.setOutcomeId("Personal_Ability", 1, "Excellent");
			net.addOutcome("Personal_Ability", "Good");
			net.addOutcome("Personal_Ability", "Average");
			net.addOutcome("Personal_Ability", "Below_Average");

			
			net.setOutcomeId("Future_Game_Performance", 0, "Good");
			net.setOutcomeId("Future_Game_Performance", 1, "Fair");
			net.addOutcome("Future_Game_Performance", "Poor");

			
			net.setOutcomeId("Commercial_Event", 0, "Rate_High");
			net.setOutcomeId("Commercial_Event", 1, "Rate_Low");
			
			net.setOutcomeId("Scandal", 0, "Will_Appear");
			net.setOutcomeId("Scandal", 1, "Will_Not_Appear");
			
			net.setOutcomeId("Future_Social_Performance", 0, "Good");
			net.setOutcomeId("Future_Social_Performance", 1, "Fair");
			net.addOutcome("Future_Social_Performance", "Poor");
			
			net.addArc("Player", "Tactic_Agreement");
			net.setNodeDefinition("Tactic_Agreement", aTacticAgreementDef);
			net.addArc("Player", "Injury");
			net.setNodeDefinition("Injury", aInjuryDef);
			net.addArc("Player", "Personal_Ability");
			net.setNodeDefinition("Personal_Ability", aPersonalAbilityDef);
			
			
			net.addArc("Player", "Commercial_Event");
			net.setNodeDefinition("Commercial_Event", aCommercialEventDef);
			net.addArc("Player", "Scandal");
			net.setNodeDefinition("Scandal", aScandalDef);
			
			net.addArc("Tactic_Agreement", "Future_Game_Performance");
			net.addArc("Injury", "Future_Game_Performance");
			net.addArc("Personal_Ability", "Future_Game_Performance");
			net.setNodeDefinition("Future_Game_Performance", aFutureGamePerformanceDef);
			
			net.addArc("Commercial_Event", "Future_Social_Performance");
			net.addArc("Scandal", "Future_Social_Performance");
			net.setNodeDefinition("Future_Social_Performance", aFutureSocialPerformanceDef);
			
			net.addArc("Future_Game_Performance", "Total_Expected_Value");
			net.addArc("Future_Social_Performance", "Total_Expected_Value");
			net.setNodeDefinition("Total_Expected_Value", aTotalExpectedValueDef);
			
			net.writeFile("Influence Diagram auto.xdsl");
			
			net.updateBeliefs();
			
			for (int i = 0; i < net.getOutcomeCount("Player"); i++) {
				String parentOutcomeId = net.getOutcomeId("Player", i);
				double expectedUtility = net.getNodeValue("Total_Expected_Value")[i];
				res.put(parentOutcomeId, expectedUtility);
				     
				//System.out.print("  - \"Player\" = " + parentOutcomeId + ": ");
				//System.out.println("Expected Utility = " + expectedUtility);
			}
				
			
		}
		catch (SMILEException e) {
			   System.out.println(e.getMessage());
		}
		return res;
	}
}
