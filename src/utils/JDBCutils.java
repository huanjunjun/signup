package utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.activation.DataSource;

import org.junit.Test;

import com.mchange.v2.c3p0.*;


public class JDBCutils {
	
      private static final ComboPooledDataSource datasource = new ComboPooledDataSource();
	@Test
      public static Connection getConnection() throws SQLException {
		return datasource.getConnection();
	
	}
	@Test
      
      public static ComboPooledDataSource getDataSource() {
		return datasource;
	}

}
