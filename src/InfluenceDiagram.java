import java.util.List;

import smile.Network;
import smile.SMILEException;


public class InfluenceDiagram {
	
	public void constructDiagram(List<Player> playerList){
		try {
			Network net = new Network();
			
			net.addNode(Network.NodeType.List, "Player");
			net.addNode(Network.NodeType.Cpt, "Tactic Agreement");
			net.addNode(Network.NodeType.Cpt, "Injury");
			net.addNode(Network.NodeType.TruthTable, "Personal Ability");
			net.addNode(Network.NodeType.Cpt, "Future Game Performance");
			
			net.addNode(Network.NodeType.Cpt, "Commercial Event");
			net.addNode(Network.NodeType.Cpt, "Scandal");
			net.addNode(Network.NodeType.Cpt, "Future Social Performance");
			
			net.addNode(Network.NodeType.Table, "Total Expected Value");
			
			int length = playerList.size();
			
			double[] aTacticAgreementDef = new double[2*length];
			double[] aInjuryDef = new double[2*length];
			double[] aPersonalAbilityDef = new double[5*length];
			for(int i=0; i<aPersonalAbilityDef.length; i++){
				aPersonalAbilityDef[i] = 0;
			}
			double[] aFutureGamePerformanceDef = {};
			
			double[] aCommercialEventDef = new double[2*length];
			double[] aScandalDef = new double[2*length];
			double[] aFutureSocialPerformanceDef = {};
			
			double[] aTotalExpectedValueDef = {};
			
			Player p;
			
			for(int i=0; i<length; i++){
				p = playerList.get(i);
				net.addOutcome("Player", p.getName());	
				aTacticAgreementDef[2*i] = p.getTacticGoodOdds();
				aTacticAgreementDef[2*i+1] = p.getTacitBadOdds();
				aInjuryDef[2*i] = p.getInjuryOdds();
				aInjuryDef[2*i+1] = p.getNotInjueryOdds();
				aCommercialEventDef[2+i] = p.getCommercialEventRateHighOdds();
				aCommercialEventDef[2+i+1] = p.getCommercialEventRateLowOdds();
				aScandalDef[2*i] = p.getScandalWillAppearOdds();
				aScandalDef[2*i+1] = p.getScandalWillNotAppearOdds();
				if(p.getPersonalAbility()=="Outstanding"){
					aPersonalAbilityDef[5*i] = 1;
				}
				else if(p.getPersonalAbility()=="Excellent"){
					aPersonalAbilityDef[5*i+1] = 1;
				}
				else if (p.getPersonalAbility()=="Good"){
					aPersonalAbilityDef[5*i+2] = 1;
				}
				else if (p.getPersonalAbility()=="Average"){
					aPersonalAbilityDef[5*i+3] = 1;
				}
				else if (p.getPersonalAbility()=="Below_Average"){
					aPersonalAbilityDef[5*i+4] = 1;
				}
				
			}					
			net.deleteOutcome("Player", 0);
			net.deleteOutcome("Player", 0);
			
			net.setOutcomeId("Tactic Agreement", 0, "Good");
			net.setOutcomeId("Tactic Agreement", 1, "Bad");
			
			net.setOutcomeId("Injury", 0, "Yes");
			net.setOutcomeId("Injury", 1, "No");
			
			net.setOutcomeId("Personal Ability", 0, "Outstanding");
			net.setOutcomeId("Personal Ability", 1, "Excellent");
			net.setOutcomeId("Personal Ability", 2, "Good");
			net.setOutcomeId("Personal Ability", 3, "Average");
			net.setOutcomeId("Personal Ability", 4, "Below Average");
			
			net.setOutcomeId("Future Game Performance", 0, "Good");
			net.setOutcomeId("Future Game Performance", 1, "Fair");
			net.setOutcomeId("Future Game Performance", 2, "Poor");
			
			net.setOutcomeId("Commercial Event", 0, "Rate_High");
			net.setOutcomeId("Commercial Event", 1, "Rate_Low");
			
			net.setOutcomeId("Scandal", 0, "Will_Appear");
			net.setOutcomeId("Scandal", 1, "Will_Not_Appear");
			
			net.setOutcomeId("Future Social Performance", 0, "Good");
			net.setOutcomeId("Future Social Performance", 0, "Fair");
			net.setOutcomeId("Future Social Performance", 0, "Poor");
			
			net.addArc("Player", "Tactic Agreement");
			net.setNodeDefinition("Tactic Agreement", aTacticAgreementDef);
			net.addArc("Player", "Injury");
			net.setNodeDefinition("Injury", aInjuryDef);
			net.addArc("Player", "Personal Ability");
			net.setNodeDefinition("Personal Ability", aPersonalAbilityDef);
			
			
			net.addArc("Player", "Commercial Event");
			net.setNodeDefinition("Commercial Event", aCommercialEventDef);
			net.addArc("Player", "Scandal");
			net.setNodeDefinition("Scandal", aScandalDef);
			
			net.addArc("Tactic Agreement", "Future Game Performance");
			net.addArc("Injury", "Future Game Performance");
			net.addArc("Personal Ability", "Future Game Performance");
			net.setNodeDefinition("Future Game Performance", aFutureGamePerformanceDef);
			
			net.addArc("Commercial Event", "Future Social Performance");
			net.addArc("Scandal", "Future Social Performance");
			net.setNodeDefinition("Future Social Performance", aFutureSocialPerformanceDef);
			
			net.addArc("Future Game Performance", "Total Expected Value");
			net.addArc("Future Social Performance", "Total Expected Value");
			net.setNodeDefinition("Total Expected Value", aTotalExpectedValueDef);
						
			
			
			   
		}
		catch (SMILEException e) {
			   System.out.println(e.getMessage());
		}
		
	}
}
