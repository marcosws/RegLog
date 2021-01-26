package reglog.logs.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reglog.logs.model.connection.ConnectionFactory;
import reglog.logs.model.entity.Workstation;

public class WorkstationDao {
	
	private Connection connection;
	
	public void insert(Workstation workstation) {
		
		this.connection = new ConnectionFactory().getConnection();
        String sql = "INSERT INTO TB_WORKSTATION(NAME_WORKSTATION) VALUES(?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);	
            preparedStatement.setString(1, workstation.getWorkstationName());
            preparedStatement.execute();
            preparedStatement.close();	
            this.connection.close();
        }
        catch(SQLException e){
        
        }

	}
	
	public Workstation select(int id) {
		
		this.connection = new ConnectionFactory().getConnection();
        try {
        	PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM TB_WORKSTATION WHERE ID_WORKSTATION = ?");
        	preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
        	Workstation workstation = new Workstation();  
        	workstation.setIdWorkstation(resultSet.getInt("ID_WORKSTATION"));
            workstation.setWorkstationName(resultSet.getString("NAME_WORKSTATION"));
			return workstation;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	public List<Workstation> select(){
		
		 this.connection = new ConnectionFactory().getConnection();
	        try{
	            List<Workstation> workstations = new ArrayList<Workstation>();
	            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM TB_WORKSTATION");
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while(resultSet.next()){
	                    
	            	Workstation workstation = new Workstation();  
	            	workstation.setIdWorkstation(resultSet.getInt("ID_WORKSTATION"));
	                workstation.setWorkstationName(resultSet.getString("NAME_WORKSTATION"));
	                workstations.add(workstation);
	                    
	            }
	            this.connection.close();
	            return workstations;
	        }
	        catch(SQLException e){
	        	e.printStackTrace();
	        }
	        return null;
		
	}


}
