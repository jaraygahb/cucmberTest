/*
All rights reserved
*/
package org.com.utility;

public class AnalysisResults {

	public String cssTarget="";
	public String help="";
	public String description="";
	public String htmlElement="";
	public String impact="";
	public String failureSummary="";
	
	
	public AnalysisResults(String cssTarget,String help,String description,String htmlElement,String impact,String failureSummary) {
		this.cssTarget = cssTarget;
		this.help = help;
		this.description = description;
		this.htmlElement = htmlElement;
		this.impact = impact;
		this.failureSummary = failureSummary;
	}

	public String getCSSTarget(){
		return this.cssTarget;
	}
	
	public void setCSSTarget(String cssTarget){
		this.cssTarget = cssTarget;
	}
	
	public String getHelp(){
		return this.help;
	}
	
	public void setHelp(String help){
		this.help = help;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public String getHtmlElement(){
		return this.htmlElement;
	}
	
	public void setHtmlElement(String htmlElement){
		this.htmlElement = htmlElement;
	}
	public String getImpact(){
		return this.impact;
	}
	
	public void setImpact(String impact){
		this.impact = impact;
	}
	public String getFailureSummary(){
		return this.failureSummary;
	}
	
	public void setFailureSummary(String failureSummary){
		this.failureSummary = failureSummary;
	}
	
}
