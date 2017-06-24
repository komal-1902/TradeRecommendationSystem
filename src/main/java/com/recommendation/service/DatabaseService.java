package com.recommendation.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseService {
	
	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	
	public DatabaseService(){
		try{
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "komal1902");
	        stmt = conn.createStatement();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String[] getSectorData(String sector){
		try{
			System.out.println("Get sector data");
			String[] trialSymbol = new String[50];
			int i = 0, length = 0;
	        pstmt = conn.prepareStatement("select symbol from stocks where sector = ?");
	        pstmt.setString(1, sector);
	        rs = pstmt.executeQuery();
	        while(rs.next()){
	        	trialSymbol[i++] = rs.getString("symbol");
				System.out.println(rs.getString("symbol"));
				length++;
	        }
	        System.out.println("Length of array : " + length);
			String[] symbol = new String[length];
			for(int j = 0; j < length; j++){
				symbol[j] = trialSymbol[j];
				System.out.println(symbol[j]);
			}

			return symbol;
	    }
		catch(Exception e){
			System.out.println("Error in get sector data" + e.getMessage());
			//e.printStackTrace();
			return null;
		}
	}
	
	public Boolean insertWatchlist(String username, String symbol){
		try{
			pstmt = conn.prepareStatement("insert into Watchlist values(?, ?)");
			pstmt.setString(1, username);
			pstmt.setString(2, symbol);
			pstmt.executeUpdate();
			return true;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public Boolean insertUserStocks(String username, String symbol){
		try{
			pstmt = conn.prepareStatement("insert into UserStocks values(?, ?)");
			pstmt.setString(1, username);
			pstmt.setString(2, symbol);
			pstmt.executeUpdate();
			return true;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public String[] getWatchlist(String username){
		try{
			String[] trialSymbol = new String[90];
			int i = 0;
	        pstmt = conn.prepareStatement("select symbol from Watchlist where username = ?");
	        pstmt.setString(1, username);
	        rs = pstmt.executeQuery();
	        while(rs.next()){

	        	trialSymbol[i++] = rs.getString("symbol");
	        	System.out.println("trials : " + trialSymbol[i-1]);
	        }
			String[] symbol = new String[i];
			for(int j = 0; j < symbol.length; j++){
				symbol[j] = trialSymbol[j];
				System.out.println(symbol[j]);
			}
			return symbol;
	    }
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public String[] getBoughtStocks(String username){
		try{
			String[] trialSymbol = new String[90];
			int i = 0;
	        pstmt = conn.prepareStatement("select symbol from UserStocks where username = ?");
	        pstmt.setString(1, username);
	        rs = pstmt.executeQuery();
	        while(rs.next()){

	        	trialSymbol[i++] = rs.getString("symbol");
	        	System.out.println("trials : " + trialSymbol[i-1]);
	        }
			String[] symbol = new String[i];
			for(int j = 0; j < symbol.length; j++){
				symbol[j] = trialSymbol[j];
				System.out.println(symbol[j]);
			}
			return symbol;
	    }
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public String getPassword(String username){
		System.out.println("Pls work");
		try{
			pstmt = conn.prepareStatement("select password from Users where username = ?");
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			rs.next();
			System.out.println( rs.getString("password"));
			return rs.getString("password");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
}
