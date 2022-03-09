package org.com.utility;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.com.runner.BaseClass;

public class ExcelUtility extends BaseClass{
	
	public static String CurrentDateAndTime=BaseClass.getCurrentDateAndTime();
	public static String TimeinMilli=getCurrentDateAndTimeSecondsMilli();

	public static XSSFWorkbook createSheet(XSSFWorkbook wbw, XSSFSheet sheet, List<String> list1,List<String> list2,List<String> list3,List<String> list4,List<String> list5,String resultPath) throws IOException{
		BaseClass bs = new BaseClass();
		sheet.setDisplayGridlines(false);

		CellStyle style0 = wbw.createCellStyle();
		Font font0=wbw.createFont();
		font0.setColor(IndexedColors.WHITE.getIndex());
		font0.setFontHeight((short)(25*20));
		font0.setBold(true);
		style0.setFont(font0);
		style0.setVerticalAlignment(VerticalAlignment.CENTER);
		style0.setAlignment(HorizontalAlignment.CENTER);
		
		if(sheet.getSheetName().equalsIgnoreCase("Passed")){
			style0.setFillForegroundColor(IndexedColors.GREEN.index);
		}else if(sheet.getSheetName().equalsIgnoreCase("Violations")){
			style0.setFillForegroundColor(IndexedColors.BROWN.index);
		}else if(sheet.getSheetName().equalsIgnoreCase("Incomplete")){
			style0.setFillForegroundColor(IndexedColors.DARK_YELLOW.index);
		}else{
			style0.setFillForegroundColor(IndexedColors.DARK_TEAL.index);
		}
		
		style0.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		Row title1 = sheet.createRow(0);
		Cell titleCell0 = title1.createCell(0);titleCell0.setCellStyle(style0);
		Cell titleCell1 = title1.createCell(1);titleCell1.setCellStyle(style0);
		Cell titleCell2 = title1.createCell(2);titleCell2.setCellStyle(style0);
		Cell titleCell3 = title1.createCell(3);titleCell3.setCellStyle(style0);
		Cell titleCell4 = title1.createCell(4);titleCell4.setCellStyle(style0);
		Cell titleCell5 = title1.createCell(5);titleCell5.setCellStyle(style0);
		titleCell0.setCellValue("Accessibility Test");
		title1.setHeightInPoints((2 * sheet.getDefaultRowHeightInPoints()));
		sheet.addMergedRegion(CellRangeAddress.valueOf("A1:F1"));

		CellStyle style = wbw.createCellStyle();
		
		if(sheet.getSheetName().equalsIgnoreCase("Passed")){
			style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.index);	
		}else if(sheet.getSheetName().equalsIgnoreCase("Violations")){
			style.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.index);
		}else if(sheet.getSheetName().equalsIgnoreCase("Incomplete")){
			style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.index);
		}else{
			style.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.index);
		}
		
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		Row info1 = sheet.createRow(1);
		Cell infoCell0 = info1.createCell(0);
		Cell infoCell01 = info1.createCell(1);
		sheet.addMergedRegion(CellRangeAddress.valueOf("A2:B2"));	
		
		String URL = "URL :-%s"+ bs.getWebDriver().getCurrentUrl();
	    StringBuilder builder = new StringBuilder();
	    for(int i=0;i<37;i++){
	        builder.append(" ");
	    }		
		infoCell0.setCellValue(URL.format(URL,builder.toString()));
		infoCell0.setCellStyle(style);

		Row info2 = sheet.createRow(2);
		Cell infoCell1 = info2.createCell(0);
		Cell infoCell11 = info2.createCell(1);
		sheet.addMergedRegion(CellRangeAddress.valueOf("A3:B3"));

		String date = "Date & Time :-%s" + new SimpleDateFormat("dd-MMM-yyyy : hh:mm:ss").format(new Date());
	    StringBuilder builder1 = new StringBuilder();
	    for(int i=0;i<19;i++){
	        builder1.append(" ");
	    }	
		
		infoCell1.setCellValue(date.format(date,builder1.toString()));
		infoCell1.setCellStyle(style);

		Row info3 = sheet.createRow(3);
		Cell infoCell2 = info3.createCell(0);
		Cell infoCell21 = info3.createCell(1);
		sheet.addMergedRegion(CellRangeAddress.valueOf("A4:B4"));
		
		String level = "Conformance Level :-%s"+ ConformanceLevel;
	    StringBuilder builder2 = new StringBuilder();
	    for(int i=0;i<4;i++){
	        builder2.append(" ");
	    }	
		
		infoCell2.setCellValue(level.format(level,builder2.toString()));
		infoCell2.setCellStyle(style);

		Row info4 = sheet.createRow(4);
		Cell infoCell3 = info4.createCell(0);
		Cell infoCell31 = info4.createCell(1);
		sheet.addMergedRegion(CellRangeAddress.valueOf("A5:B5"));
		
		String browser = "Browser (Ver) :-%s" + bs.Browser+" ("+BrowserVersion+")";
	    StringBuilder builder3 = new StringBuilder();
	    for(int i=0;i<15;i++){
	        builder3.append(" ");
	    }	
		
		infoCell3.setCellValue(browser.format(browser,builder3.toString()));
		infoCell3.setCellStyle(style);

		CellStyle style1 = wbw.createCellStyle();
		Font font=wbw.createFont();
		//		font.setColor(IndexedColors.WHITE.getIndex());
		font.setBold(true);
		style1.setFont(font);			

		if(sheet.getSheetName().equalsIgnoreCase("Passed")){
			style1.setFillForegroundColor(IndexedColors.GREEN.index);
		}else if(sheet.getSheetName().equalsIgnoreCase("Violations")){
			style1.setFillForegroundColor(IndexedColors.BROWN.index);
		}else if(sheet.getSheetName().equalsIgnoreCase("Incomplete")){
			style1.setFillForegroundColor(IndexedColors.DARK_YELLOW.index);
		}else{
			style1.setFillForegroundColor(IndexedColors.DARK_TEAL.index);
		}
		
		style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		Row header = sheet.createRow(5);

		Cell head0 = header.createCell(0);
		Cell head1= header.createCell(1);			
		Cell head2=header.createCell(2);
		Cell head3=header.createCell(3);
		Cell head4=header.createCell(4);
		Cell head5=header.createCell(5);

		head0.setCellValue("Sl#");
		head0.setCellStyle(style1);
		head1.setCellValue("Rules Applied");
		head1.setCellStyle(style1);
		head2.setCellValue("HTML Elements");
		head2.setCellStyle(style1);
		head3.setCellValue("CSS Selectors");
		head3.setCellStyle(style1);
		head4.setCellValue("Possible Impact");
		head4.setCellStyle(style1);
		head5.setCellValue("Failure Summary");
		head5.setCellStyle(style1);

		sheet.setColumnWidth(0, 1500);
		sheet.setColumnWidth(1, 22000);
		sheet.setColumnWidth(2, 25400);
		sheet.setColumnWidth(3, 14000);
		sheet.setColumnWidth(4, 4700);
		sheet.setColumnWidth(5, 30000);

		CellStyle style2 = wbw.createCellStyle();
		if(sheet.getSheetName().equalsIgnoreCase("Passed")){
			style2.setFillForegroundColor(IndexedColors.LIGHT_GREEN.index);	
		}else if(sheet.getSheetName().equalsIgnoreCase("Violations")){
			style2.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.index);
		}else if(sheet.getSheetName().equalsIgnoreCase("Incomplete")){
			style2.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.index);
		}else{
			style2.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.index);
		}
		
		style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		Font font1=wbw.createFont();
		font.setColor(IndexedColors.WHITE.getIndex());
		style2.setFont(font1);			
		style2.setWrapText(true);
		style2.setVerticalAlignment(VerticalAlignment.TOP);
		style2.setBorderBottom(BorderStyle.THIN);  
		style2.setBorderRight(BorderStyle.THIN);
		for (int i=5; i<list1.size()-1; i++) {
			if(i==0)
			{
				Row r = sheet.createRow(i+1);		

				Cell cell0 = r.createCell(0);
				cell0.setCellStyle(style2);	
				Cell cell1 = r.createCell(1);
				cell1.setCellStyle(style2);						
				Cell cell2 = r.createCell(2);
				cell2.setCellStyle(style2);	
				Cell cell3 = r.createCell(3);
				cell3.setCellStyle(style2);	
				Cell cell4 = r.createCell(4);
				cell4.setCellStyle(style2);	
				Cell cell5 = r.createCell(5);
				cell5.setCellStyle(style2);

				cell0.setCellValue(i-4);	
				cell1.setCellValue(list1.get(i));					
				cell2.setCellValue(list2.get(i));
				cell3.setCellValue(list3.get(i));
				cell4.setCellValue(list4.get(i));
				cell5.setCellValue(list5.get(i));


			}
			else
			{
				Row r = sheet.createRow(i+1);		

				Cell cell0 = r.createCell(0);
				cell0.setCellStyle(style2);	
				Cell cell1 = r.createCell(1);
				cell1.setCellStyle(style2);						
				Cell cell2 = r.createCell(2);
				cell2.setCellStyle(style2);	
				Cell cell3 = r.createCell(3);
				cell3.setCellStyle(style2);	
				Cell cell4 = r.createCell(4);
				cell4.setCellStyle(style2);	
				Cell cell5 = r.createCell(5);
				cell5.setCellStyle(style2);

				cell0.setCellValue(i-4);	
				cell1.setCellValue(list1.get(i));					
				cell2.setCellValue(list2.get(i));
				cell3.setCellValue(list3.get(i));
				cell4.setCellValue(list4.get(i));
				cell5.setCellValue(list5.get(i));
			}

		}

		return wbw;
	}


	static public void writeDataToSheet(String sheetName, List<String> list1,List<String> list2,List<String> list3,List<String> list4,List<String> list5,String resultPath) throws IOException{
		ZipSecureFile.setMinInflateRatio(0);
		
		//FileInputStream ref = new FileInputStream(path);

		//FileInputStream ref = new FileInputStream(ReportPath+"/AccessibilityReport"+Calendar.getInstance().getTime()+System.currentTimeMillis()+".xlsx");
		File path=new File(ReportPath+"/AxeReport_"+resultPath+CurrentDateAndTime+".xlsx");
		if(path.exists())
		{
			System.out.println("Report Sheet Created....");
			FileInputStream ref=new FileInputStream(path);
			XSSFWorkbook wbw=new XSSFWorkbook(ref);		
			XSSFSheet sheet =wbw.createSheet(sheetName);
			XSSFWorkbook newwbw= createSheet(wbw,sheet,list1, list2, list3, list4, list5, resultPath);
			try {
				FileOutputStream fos =new FileOutputStream(path);
				newwbw.write(fos);
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Report Sheet Already Exists....");
			FileOutputStream ref=new FileOutputStream(path);
			XSSFWorkbook wbw=new XSSFWorkbook();		
			XSSFSheet sheet =wbw.createSheet(sheetName);
			XSSFWorkbook newwbw= createSheet(wbw,sheet,list1, list2, list3, list4, list5, resultPath);

			try {
				FileOutputStream fos =new FileOutputStream(path);
				newwbw.write(fos);
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
