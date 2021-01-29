package reglog.logs.model.connection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionFactory {
	
	public ConnectionFactory() {
		
		Connection connection = this.getConnection();
		List<String> tablesDb = new ArrayList<String>();
		List<String> tablesList = new ArrayList<String>();
		tablesList.add("TB_CLASSNAME");
		tablesList.add("TB_LOG");
		tablesList.add("TB_STATUS");
		tablesList.add("TB_USER");
		tablesList.add("TB_WORKSTATION");
 		tablesDb = this.getTables(connection);
 		if(!tablesDb.containsAll(tablesList)) {
 			
           this.executeSQL(SQLTables.SQL_TB_USER);
           this.executeSQL(SQLTables.SQL_TB_CLASSNAME);
           this.executeSQL(SQLTables.SQL_TB_WORKSTATION);
           this.executeSQL(SQLTables.SQL_TB_STATUS);
           this.executeSQL(SQLTables.SQL_TB_LOG);
           this.executeSQL(SQLTables.SQL_NAME_STATUS_FAILED);
           this.executeSQL(SQLTables.SQL_NAME_STATUS_PASSED);
           this.executeSQL(SQLTables.SQL_NAME_STATUS_INFORMATION);
           this.executeSQL(SQLTables.SQL_NAME_STATUS_TITLE);
           
 		}
	}
	
	public Connection getConnection(){
        
	    try {
	    	Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			return DriverManager.getConnection("jdbc:derby:reglog;create=true");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}	
	    return null;
	    
    }
	
	private void executeSQL(String sql) {
		Connection connection = this.getConnection();
	
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			preparedStatement.close();
	        connection.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	private List<String> getTables(Connection connection){
		
		List<String> tables = new ArrayList<String>();
		DatabaseMetaData databaseMetaData;
		try {
			databaseMetaData = connection.getMetaData();
			ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[] { "TABLE" });
			while(resultSet.next()){
				String tableName = resultSet.getString("TABLE_NAME").toUpperCase();
				tables.add(tableName);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return tables;
	}

}
