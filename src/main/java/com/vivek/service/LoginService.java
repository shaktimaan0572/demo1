package com.vivek.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.vivek.model.Login;

@Component
public class LoginService {
	
	public int checkDetails(Login loginObject) {
		int error= 0;
		
		String dbUrl = "jdbc:mysql://us-cdbr-iron-east-01.cleardb.net:3306/heroku_ca8610d1a73526d";
		String dbUserName="bb9fb9339e75e2";
		String dbPassword="17647790";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con;
			con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
			
			String query1="SELECT UserId FROM foosballGameData where UserId = \""+ loginObject.getUsername()+"\";";
			java.sql.Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query1);
			
			if(!rs.next()) {
				//System.out.println(rs.getString("UserId"));
				error=1;
				return error;
			}
			String query2="SELECT password FROM foosballGameData where UserId = \""+ loginObject.getUsername()+"\";";
			st = con.createStatement();
			rs = st.executeQuery(query2);
			rs.next();
			if(!rs.getString("password").equals(loginObject.getPassword())) {
				error=2;
				return error;
			}			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return error;
	}

}
