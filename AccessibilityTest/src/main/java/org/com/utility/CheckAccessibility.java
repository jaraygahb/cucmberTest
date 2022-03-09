package org.com.utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.com.runner.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.deque.html.axecore.results.CheckedNode;
import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;

public class CheckAccessibility extends BaseClass
{
	public CheckAccessibility(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	int id=(int)Thread.currentThread().getId();
	
	public Results PrepareResult(String levelOfConformance) throws InterruptedException{
		System.out.println("Analysing Web Page.......................!");

		AxeBuilder axe = new AxeBuilder();

		if(!levelOfConformance.trim().equalsIgnoreCase("All")){
			List<String> tags = Arrays.asList(levelOfConformance);
			axe.withTags(tags);
		}

		Results result =  axe.analyze(getWebDriver());	
		return result;		
	}



	public void findAndPrintResult(Results result,String resultPath, String resultFor) throws IOException{
		try{
			List<String> getTarget= new ArrayList<String>(),getDescription= new ArrayList<String>(),getHtml = new ArrayList<String>(), getImpact = new ArrayList<String>(),getFailureSummary= new ArrayList<String>() ;
			//		List<String> description1= new ArrayList<String>(),description2= new ArrayList<String>(),description3= new ArrayList<String>(),description4= new ArrayList<String>();


			System.out.println("Fetching Results.......................!");
			if(resultFor.equalsIgnoreCase("passed")){
				PassedListSize=(result.getPasses().size());

				//			Map<String,String> mapOfElements1=new LinkedHashMap<>();
				for (Rule r : result.getPasses()) {				
					for(CheckedNode l:(r.getNodes()))
					{

						System.out.println("CSS element= "+l.getTarget() + "::" +"Description= "+r.getHelp()+ "desc"+r.getDescription() + "Passed");

						getDescription.add(r.getDescription());
						getHtml.add(l.getHtml());
						getTarget.add(l.getTarget().toString());
						getImpact.add(r.getImpact());
						getFailureSummary.add(l.getFailureSummary());

						PassedCompleteResult.put("CSS element= "+l.getTarget(),"Applied Rules= "+r.getDescription());
						//					mapOfElements1.put(l.getTarget().toString(),r.getHelp());
					}

				}

				ExcelUtility.writeDataToSheet("Passed", getDescription,getHtml,getTarget,getImpact,getFailureSummary, resultPath);

				getDescription.clear();
				getHtml.clear();
				getTarget.clear();
				getImpact.clear();
				getFailureSummary.clear();

			}else if(resultFor.equalsIgnoreCase("violation")){
				FailedListSize=(result.getViolations().size());

				//			Map<String,String> mapOfElements2=new LinkedHashMap<>();	

				for (Rule r : result.getViolations()) {
					for(CheckedNode l:(r.getNodes()))
					{

						System.out.println("CSS element= "+l.getTarget() + "::" +"Description= "+r.getHelp()+ "desc"+r.getDescription() + "Violations");

						getDescription.add(r.getDescription());
						getHtml.add(l.getHtml());
						getTarget.add(l.getTarget().toString());
						getImpact.add(r.getImpact());
						getFailureSummary.add(l.getFailureSummary());

						FailedCompleteResult.put("CSS element= "+l.getTarget(),"Applied Rules= "+r.getDescription());
						//					mapOfElements2.put(l.getTarget().toString(),r.getHelp());
					}   
				}
				ExcelUtility.writeDataToSheet("Violations", getDescription,getHtml,getTarget,getImpact,getFailureSummary, resultPath);

				getDescription.clear();
				getHtml.clear();
				getTarget.clear();
				getImpact.clear();
				getFailureSummary.clear();



			}else if(resultFor.equalsIgnoreCase("incomplete")){
				IncompleteListSize=(result.getIncomplete().size());

				//			Map<String,String> mapOfElements3=new LinkedHashMap<>();

				for (Rule r : result.getIncomplete()) {
					for(CheckedNode l:(r.getNodes()))
					{
						System.out.println("CSS element= "+l.getTarget() + "::" +"Description= "+r.getHelp()+ "desc"+r.getDescription() + "Incomplete");

						getDescription.add(r.getDescription());
						getHtml.add(l.getHtml());
						getTarget.add(l.getTarget().toString());
						getImpact.add(r.getImpact());
						getFailureSummary.add(l.getFailureSummary());

						IncompleteCompleteResult.put("CSS element= "+l.getTarget(),"Applied Rules= "+r.getDescription());
						//					mapOfElements3.put(l.getTarget().toString(),r.getHelp());
					}   
				}
				ExcelUtility.writeDataToSheet("Incomplete", getDescription,getHtml,getTarget,getImpact,getFailureSummary, resultPath);

				getDescription.clear();
				getHtml.clear();
				getTarget.clear();
				getImpact.clear();
				getFailureSummary.clear();

			}else if(resultFor.equalsIgnoreCase("inapplicable")){
				InapplicableListSize=(result.getInapplicable().size());

				//			Map<String,String> mapOfElements4=new LinkedHashMap<>();

				for (Rule r : result.getInapplicable()) {
					for(CheckedNode l:(r.getNodes()))
					{
						System.out.println("CSS element= "+l.getTarget() + "::" +"Description= "+r.getHelp()+ "desc"+r.getDescription() + "Inapplicable");

						getDescription.add(r.getDescription());
						getHtml.add(l.getHtml());
						getTarget.add(l.getTarget().toString());
						getImpact.add(r.getImpact());
						getFailureSummary.add(l.getFailureSummary());

						InapplicableCompleteResult.put("CSS element= "+l.getTarget(),"Applied Rules= "+r.getDescription());
						//					mapOfElements4.put(l.getTarget().toString(),r.getHelp());
					}   
				}
				ExcelUtility.writeDataToSheet("Inapplicable", getDescription,getHtml,getTarget,getImpact,getFailureSummary, resultPath);

				getDescription.clear();
				getHtml.clear();
				getTarget.clear();
				getImpact.clear();
				getFailureSummary.clear();
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	
	
	
	
	//	AxeRunOnlyOptions runOnlyOptions = new AxeRunOnlyOptions();	
	//	runOnlyOptions.setType("tag");
	//	runOnlyOptions.setValues(Arrays.asList(levelOfConformance,"frame-tested=false"));
	//	runOnlyOptions.setValues(Arrays.asList(levelOfConformance));		
	//	AxeRunOptions options = new AxeRunOptions();	
	//	options.setRunOnly(runOnlyOptions);
}