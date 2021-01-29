package reglog.logs.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

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

}
