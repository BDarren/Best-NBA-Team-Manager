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
			//Random generator = new Random();
			
			net.addNode(Network.NodeType.List, "Player");
			net.addNode(Network.NodeType.Cpt, "Tactic_Agreement");
			net.addNode(Network.NodeType.Cpt, "Attendence");
			net.addNode(Network.NodeType.Cpt, "Personal_Ability");
			net.addNode(Network.NodeType.Cpt, "Future_Game_Performance");
			
			net.addNode(Network.NodeType.Cpt, "Commercial_Event");
			net.addNode(Network.NodeType.Cpt, "Scandal");
			net.addNode(Network.NodeType.Cpt, "Future_Social_Performance");
			
			net.addNode(Network.NodeType.Table, "Game_Performance_Value");
			net.addNode(Network.NodeType.Table, "Social_Performance_Value");
			
			net.addNode(Network.NodeType.Table, "Total_Expected_Value");
			
			int length = playerList.size();
			
			double[] aTacticAgreementDef = new double[2*length];
			double[] aInjuryDef = new double[2*length];
			double[] aPersonalAbilityDef = new double[3*length];

			double[] aFutureGamePerformanceDef = {0.4814814814814814,0.4814814814814814,0.03703703703703704,0.07575757575757576,
					0.5303030303030303,0.3939393939393939,0.005847953216374269,0.1988304093567251,0.7953216374269005,0.6231884057971014,
					0.3623188405797101,0.0144927536231884,0.1168384879725086,0.5601374570446736,0.3230240549828178,0.003787878787878788,
					0.2196969696969697,0.7765151515151515,0.4444444444444444,0.4444444444444444,0.1111111111111111,0.08333333333333333,
					0.8333333333333334,0.08333333333333333,0.03333333333333333,0.3333333333333334,0.6333333333333333,0.08333333333333333,
					0.8333333333333334,0.08333333333333333,0.2083333333333333,0.4583333333333333,0.3333333333333333,0.0196078431372549,
					0.1372549019607843,0.8431372549019608};
			/*double[] aFutureGamePerformanceDef = new double[36];
			for(int i=0; i<36; i++){
				if((i+1)%3==0){
					aFutureGamePerformanceDef[i] = 1-aFutureGamePerformanceDef[i-1]-aFutureGamePerformanceDef[i-2];
				}
				else{
					aFutureGamePerformanceDef[i] = generator.nextDouble()*(0.5);
				}
			}*/
			
			double[] aCommercialEventDef = new double[2*length];
			double[] aScandalDef = new double[2*length];
			double[] aFutureSocialPerformanceDef = {0.7,0.2,0.1,0.05,0.1,0.85,0.8,0.15,0.05,0.25,0.5,0.25};
			/*double[] aFutureSocialPerformanceDef = new double[12];
			for(int i=0; i<12; i++){
				if((i+1)%3==0){
					aFutureSocialPerformanceDef[i] = 1-aFutureSocialPerformanceDef[i-1]-aFutureSocialPerformanceDef[i-2];
				}
				else{
					aFutureSocialPerformanceDef[i] = generator.nextDouble()*(0.5);
				}
			}*/

			
			
			double[] aGameExpectedValueDef = {99,80,65};
			double[] aSocialExpectedValueDef = {99,80,65};
			
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
				aPersonalAbilityDef[3*i] = p.getPersonalAbilityEOdds();
				aPersonalAbilityDef[3*i+1] = p.getPersonalAbilityGOdds();
				aPersonalAbilityDef[3*i+2] = p.getPersonalAbilityAOdds();				
			}					
			net.deleteOutcome("Player", 0);
			net.deleteOutcome("Player", 0);
			
			net.setOutcomeId("Tactic_Agreement", 0, "Good");
			net.setOutcomeId("Tactic_Agreement", 1, "Fair");
			
			net.setOutcomeId("Attendence", 0, "Yes");
			net.setOutcomeId("Attendence", 1, "No");
			
			net.setOutcomeId("Personal_Ability", 0, "Excellent");
			net.setOutcomeId("Personal_Ability", 1, "Good");
			net.addOutcome("Personal_Ability", "Average");

			
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
			net.addArc("Player", "Attendence");
			net.setNodeDefinition("Attendence", aInjuryDef);
			net.addArc("Player", "Personal_Ability");
			net.setNodeDefinition("Personal_Ability", aPersonalAbilityDef);
			
			
			net.addArc("Player", "Commercial_Event");
			net.setNodeDefinition("Commercial_Event", aCommercialEventDef);
			net.addArc("Player", "Scandal");
			net.setNodeDefinition("Scandal", aScandalDef);
			
			net.addArc("Tactic_Agreement", "Future_Game_Performance");
			net.addArc("Attendence", "Future_Game_Performance");
			net.addArc("Personal_Ability", "Future_Game_Performance");
			net.setNodeDefinition("Future_Game_Performance", aFutureGamePerformanceDef);
			
			net.addArc("Commercial_Event", "Future_Social_Performance");
			net.addArc("Scandal", "Future_Social_Performance");
			net.setNodeDefinition("Future_Social_Performance", aFutureSocialPerformanceDef);
			
			net.addArc("Future_Game_Performance", "Game_Performance_Value");
			net.setNodeDefinition("Game_Performance_Value", aGameExpectedValueDef);
			net.addArc("Future_Social_Performance", "Social_Performance_Value");
			net.setNodeDefinition("Social_Performance_Value", aSocialExpectedValueDef);
			
			//net.addArc("Game_Performance_Value", "Total_Expected_Value");
			//net.addArc("Social_Performance_Value", "Total_Expected_Value");
			//net.setNodeDefinition("Total_Expected_Value", aTotalExpectedValueDef);
			
			//net.writeFile("Influence Diagram auto.xdsl");
			
			net.updateBeliefs();
			
			for (int i = 0; i < net.getOutcomeCount("Player"); i++) {
				String parentOutcomeId = net.getOutcomeId("Player", i);
				double GameexpectedUtility = net.getNodeValue("Game_Performance_Value")[i];
				double SocialexpectedUtility = net.getNodeValue("Social_Performance_Value")[i];
				double expectedUtility = GameexpectedUtility*weight+SocialexpectedUtility*(1-weight);
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
