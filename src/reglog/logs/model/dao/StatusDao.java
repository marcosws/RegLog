package reglog.logs.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reglog.logs.model.connection.ConnectionFactory;
import reglog.logs.model.entity.Status;

public class StatusDao {
	
	private Connection connection;
	
	
	public Status select(int id) {
		
		this.connection = new ConnectionFactory().getConnection();
		try{
			PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM TB_STATUS WHERE ID_STATUS = ?");
			ResultSet resultSet = preparedStatement.executeQuery();
			preparedStatement.setInt(1, id);
		    resultSet.next();       
			Status status = new Status();  
			status.setIdStatus(resultSet.getInt("ID_STATUS"));
			status.setNameStatus(resultSet.getString("NAME_STATUS"));
			this.connection.close();
			return status;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	public List<Status> select(){
		
		this.connection = new ConnectionFactory().getConnection();
		try{
			List<Status> statusList = new ArrayList<Status>();
			PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM TB_STATUS");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){        
				Status status = new Status();  
				status.setIdStatus(resultSet.getInt("ID_STATUS"));
				status.setNameStatus(resultSet.getString("NAME_STATUS"));
				statusList.add(status);                   
			}
			this.connection.close();
			return statusList;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
		
	}

}
