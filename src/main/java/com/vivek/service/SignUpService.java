package com.vivek.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.vivek.model.SignUp;

@Component
public class SignUpService {
	
	public boolean AddDetails(SignUp signUpObj) {
		//System.out.println(signUpObj);
		
		/*
		 * DB-url: jdbc:mysql://localhost:3306/foosballGame
		 * DB-userName:root
		 * DB-password:db.mysql@123
		 * 
		 * */
		
		String dbUrl = "jdbc:mysql://us-cdbr-iron-east-01.cleardb.net:3306/heroku_ca8610d1a73526d";
		String dbUserName="bb9fb9339e75e2";
		String dbPassword="17647790";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con;
			con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
			
			String query="SELECT UserId FROM foosballGameData where UserId = \""+ signUpObj.getUsername()+"\";";
			java.sql.Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				//System.out.println(rs.getString("UserId"));
				return false;
			}			
			String query1="insert into foosballGameData values(?,?,?,?,?,?,?,?,?); ";
			PreparedStatement prepareStat = con.prepareStatement(query1);
			prepareStat.setString(1, signUpObj.getFirstName());
			prepareStat.setString(2, signUpObj.getLastName());
			prepareStat.setString(3, signUpObj.getUsername());
			prepareStat.setString(4, signUpObj.getEmailId());
			prepareStat.setString(5, signUpObj.getPassword());
			prepareStat.setBoolean(6, false);
			prepareStat.setInt(7, 0);
			prepareStat.setInt(8, 0);
			prepareStat.setInt(9, 0);
			int x = prepareStat.executeUpdate();
			if(x>0) {
				System.out.println("details updated");
			}
			else {
				System.out.println("sign up error");
			}

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;		
	}

}
