package com.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.tomcat.jdbc.pool.DataSource;
public class DbConnection {

	private Connection connection = null;
	private static org.apache.tomcat.jdbc.pool.DataSource dataSource;
	
	public Connection getConnect() {

		    Future<Connection> future = null;
			try {
				dataSource=this.getI();
				future = dataSource.getConnectionAsync();
		    while(!future.isDone()) {
		        System.out.println("Connection is not yet available. Do some background work");
		        Thread.sleep(100); //simulate work       
		    }   
			connection=future.get();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException x) {    
	            Thread.currentThread().interrupted();       
	        } catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
		return connection;
	}
	
	private DataSource getI() throws NamingException{
		if(dataSource ==null){
			Context init = new InitialContext();
			Context envContext =(Context)init.lookup("java:comp/env");
			dataSource=(DataSource)envContext.lookup("jdbc/pgsql");
		}
		return dataSource;
	}
}
