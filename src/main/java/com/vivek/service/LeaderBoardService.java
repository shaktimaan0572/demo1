package com.vivek.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.mysql.cj.xdevapi.Statement;
import com.vivek.model.LeaderBoardColumnObj;

@Component
public class LeaderBoardService {
	
	public LinkedList getDetails() {
		LinkedList<LeaderBoardColumnObj> dataList = new LinkedList();
		
		String dbUrl = "jdbc:mysql://us-cdbr-iron-east-01.cleardb.net:3306/heroku_ca8610d1a73526d";
		String dbUserName="bb9fb9339e75e2";
		String dbPassword="17647790";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
			String query1="select UserId,FirstName,LastName,score from foosballGameData order by score desc;";
			java.sql.Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query1);
			while(rs.next()) {
				LeaderBoardColumnObj obj = 
						new LeaderBoardColumnObj(rs.getString("userId"),
												 (rs.getString("FirstName")+" "+ rs.getString("LastName")),
												 rs.getInt("score"));
				dataList.add(obj);
				
			}
			

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataList;
	}

}
