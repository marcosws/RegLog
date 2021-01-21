package reglog.logs.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reglog.logs.model.connection.ConnectionFactory;
import reglog.logs.model.entity.Log;

public class LogDao {

	private Connection connection;
	
	public void insert(Log log) {
		
		this.connection = new ConnectionFactory().getConnection();
        String sql = "INSERT INTO TB_LOG(TEXT_LOG, EXEC_DATETIME, ID_USER, ID_WORKSTATION, ID_CLASSNAME, ID_STATUS) VALUES(?,?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);	
            preparedStatement.setString(1, log.getLogText());
            preparedStatement.setTimestamp(2, log.getDateTime());
            preparedStatement.setInt(3, log.getIdUser());
            preparedStatement.setInt(4, log.getIdWorkstation());
            preparedStatement.setInt(5, log.getIdClassName());
            preparedStatement.setInt(6, log.getIdStatus());
            
            preparedStatement.execute();
            preparedStatement.close();	
            this.connection.close();
        }
        catch(SQLException e){
        	e.printStackTrace();
        }
		
	}
	public void delete() { 
		
		this.connection = new ConnectionFactory().getConnection();
		String sql = "TRUNCATE TABLE TB_LOG";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);	
            preparedStatement.execute();
            preparedStatement.close();	
            this.connection.close();
        }
        catch(SQLException e){
        	e.printStackTrace();
        }
        
	}
	public List<Log> select(){
		
		 this.connection = new ConnectionFactory().getConnection();
	        try{
	            List<Log> logs = new ArrayList<Log>();
	            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM TB_LOG");
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while(resultSet.next()){
	                    
	            	Log log = new Log();  
	            	log.setIdLog(resultSet.getInt("ID_LOG"));
	            	log.setLogText(resultSet.getString("TEXT_LOG"));
	            	log.setDateTime(resultSet.getTimestamp("EXEC_DATETIME"));
	            	log.setIdUser(resultSet.getInt("ID_USER"));
	            	log.setIdWorkstation(resultSet.getInt("ID_WORKSTATION"));
	            	log.setIdClassName(resultSet.getInt("ID_CLASSNAME"));
	            	log.setIdStatus(resultSet.getInt("ID_STATUS"));
	            	logs.add(log);
	                    
	            }
	            this.connection.close();
	            return logs;
	        }
	        catch(SQLException e){
	        	e.printStackTrace();
	        }
	        return null;
		
	}

}
