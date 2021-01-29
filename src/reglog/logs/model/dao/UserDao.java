package reglog.logs.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reglog.logs.model.connection.ConnectionFactory;
import reglog.logs.model.entity.User;

public class UserDao {
	
	private Connection connection;
	
	public void insert(User user) {
		
		this.connection = new ConnectionFactory().getConnection();
        String sql = "INSERT INTO TB_USER(NAME_USER) VALUES(?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);	
            preparedStatement.setString(1, user.getNameUser());
            preparedStatement.execute();
            preparedStatement.close();	
            this.connection.close();
        }
        catch(SQLException e){
        	
        }

	}
	public User select(int id){
		
		this.connection = new ConnectionFactory().getConnection();
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM TB_USER WHERE ID_USER = ?");
			preparedStatement.setInt(1, id);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        resultSet.next();    
	        User user = new User();  
	        user.setIdUser(resultSet.getInt("ID_USER"));
	        user.setNameUser(resultSet.getString("NAME_USER"));
	        this.connection.close();
	        return user;
	    }
	    catch(SQLException e){
	    	e.printStackTrace();
	    }
	    return null;
		
	}
	public List<User> select(){
		
		 this.connection = new ConnectionFactory().getConnection();
	        try{
	            List<User> users = new ArrayList<User>();
	            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM TB_USER");
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while(resultSet.next()){
	                    
	                User user = new User();  
	                user.setIdUser(resultSet.getInt("ID_USER"));
	                user.setNameUser(resultSet.getString("NAME_USER"));
	                users.add(user);
	                    
	            }
	            this.connection.close();
	            return users;
	        }
	        catch(SQLException e){
	        	e.printStackTrace();
	        }
	        return null;
		
	}

}
