package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.FeatureBean;
import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dao.RealEstateDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-login")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "db-feature")
	public Object [][] getDBfeatureData() {

		List<FeatureBean> list1 = new RealEstateDAO().getfeature(); 
		
		Object[][] result = new Object[list1.size()][]; 
		int count = 0; 
		for(FeatureBean temp : list1){
			Object[]  obj = new Object[4]; 
			obj[0] = temp.getName(); 
			obj[1] = temp.getSlug(); 
			obj[2] = temp.getParentF();
			obj[3] = temp.getDescription();
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs-login")
	public Object[][] getExcelDataLogin(){
//		String fileName ="C:\\Users\\SelvakumarVelu\\Desktop\\Manipal\\project\\H_RealEstate TestDataLogin.xlsx"; 
		String fileName ="C:\\Users\\SelvakumarVelu\\Desktop\\Manipal\\project\\High_level\\Run\\H_RealEstate TestData.xlsx"; 
		String sheetName="login";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "excel-inputs-HTestsRETC_82")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\SelvakumarVelu\\Desktop\\Manipal\\project\\High_level\\Run\\H_RealEstate TestData.xlsx"; 
		String sheetName="RETC_082";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "excel-inputs-HTestsRETC_83")
	public Object[][] getExcelData83(){
		String fileName ="C:\\Users\\SelvakumarVelu\\Desktop\\Manipal\\project\\High_level\\Run\\H_RealEstate TestData.xlsx"; 
		String sheetName="RETC_083";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "excel-inputs-HTestsRETC_84")
	public Object[][] getExcelData84(){
		String fileName ="C:\\Users\\SelvakumarVelu\\Desktop\\Manipal\\project\\High_level\\Run\\H_RealEstate TestData.xlsx"; 
		String sheetName="RETC_084";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
