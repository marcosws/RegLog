package reglog.logs.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reglog.logs.model.connection.ConnectionFactory;
import reglog.logs.model.entity.ClassName;


public class ClassNameDao {
	
	private Connection connection;
	
	public void insert(ClassName className) {
		
		this.connection = new ConnectionFactory().getConnection();
        String sql = "INSERT INTO TB_CLASSNAME(NAME_CLASSNAME) VALUES(?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);	
            preparedStatement.setString(1, className.getNameClass());
            preparedStatement.execute();
            preparedStatement.close();	
            this.connection.close();
        }
        catch(SQLException e){
        	
        }

	}
	public ClassName select(int id){
		
		this.connection = new ConnectionFactory().getConnection();
		try{
			PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM TB_CLASSNAME WHERE ID_CLASSNAME = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			ClassName className = new ClassName();  
			className.setIdClassName(resultSet.getInt("ID_CLASSNAME"));
			className.setNameClass(resultSet.getString("NAME_CLASSNAME"));
			this.connection.close();
			return className;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
		
	}
	public List<ClassName> select(){
		
		 this.connection = new ConnectionFactory().getConnection();
	        try{
	            List<ClassName> classNames = new ArrayList<ClassName>();
	            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM TB_CLASSNAME");
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while(resultSet.next()){
	                    
	            	ClassName className = new ClassName();  
	            	className.setIdClassName(resultSet.getInt("ID_CLASSNAME"));
	            	className.setNameClass(resultSet.getString("NAME_CLASSNAME"));
	                classNames.add(className);
	                    
	            }
	            this.connection.close();
	            return classNames;
	        }
	        catch(SQLException e){
	        	e.printStackTrace();
	        }
	        return null;
		
	}


}
