package model;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mchange.v2.c3p0.impl.NewPooledConnection;

import domain.user;
import utils.JDBCutils;

/**
 * c处理数据
 * 
 * @author Administrator
 *
 */
public class usermodel {
	// 连接数据库
	public boolean login(user user1) throws SQLException {
//		QueryRunner queryRunner = new QueryRunner(JDBCutils.getDataSource());
//		user existUser = queryRunner.query("SELECT * FROM USER WHERE  username = ? and password =? ",
//		new BeanHandler<user>(user.class), user1.getUsernameString(), user1.getPasswordString());
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet  rSet=null;
        
        user existUser=null;
        
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost/db1?serverTimezone=GMT",
			        "root","123456");
			
			String sqlString="select *  from user where username=? and password = ? ";
			
			preparedStatement=connection.prepareStatement(sqlString);
			
			preparedStatement.setString(1, user1.getUsernameString());
			preparedStatement.setString(2, user1.getPasswordString());
			
			rSet=preparedStatement.executeQuery();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        	if(rSet.next())
			{
				return true;
			}
			else {
				return false;
			}
		

	}
}
