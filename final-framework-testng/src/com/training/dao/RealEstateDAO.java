package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.FeatureBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class RealEstateDAO {
	
	Properties properties; 
	
	public RealEstateDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<FeatureBean> getfeature(){
		String sql = properties.getProperty("get.feature"); 
		
		GetConnection gc  = new GetConnection(); 
		List<FeatureBean> list1 = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list1 = new ArrayList<FeatureBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				FeatureBean temp = new FeatureBean(); 
				temp.setName(gc.rs1.getString(1));
				temp.setSlug(gc.rs1.getString(2));
				temp.setParentF(gc.rs1.getString(3));
				temp.setDescription(gc.rs1.getString(4));

				list1.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list1; 
	}
	
	public static void main(String[] args) {
		new RealEstateDAO().getfeature().forEach(System.out :: println);
	}
	
	
}
