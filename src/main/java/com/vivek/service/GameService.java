package com.vivek.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class GameService {
	
	public void updateScore(int gamePoints ,int win, String userId) {
		String dbUrl = "jdbc:mysql://us-cdbr-iron-east-01.cleardb.net:3306/heroku_ca8610d1a73526d";
		String dbUserName="bb9fb9339e75e2";
		String dbPassword="17647790";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con;
			con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
			
			
			String query ="UPDATE foosballGameData SET score = score + ? , win = win + ? , matches = matches + ? WHERE UserId = ?;";			
			PreparedStatement prepareStat = con.prepareStatement(query);
			prepareStat.setInt(1, gamePoints);
			prepareStat.setInt(2, win);
			prepareStat.setInt(3, 1);
			prepareStat.setString(4, userId);
			
			
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

		
		
	}

}
