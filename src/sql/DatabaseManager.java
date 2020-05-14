/*
 * Name: Callum Bass
 * Student ID: w1682693
 * Software Development - Group Project
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author londo
 */

//This class can be used to create a manager object, handling all connections and queries.
public class DatabaseManager {
    
    public Connection connection;
    
    public DatabaseManager() {
    }
    
    //Method created to connect with user definied params
    public void connectWithCredentials(String url, String name, String user, String pass) {
        if (connection == null) {
            try {
                
                connection = DriverManager.getConnection("jdbc:mysql://" + url + "/" + name + "?" +
                                   "user=" + user + "&password=" + pass + "&useLegacyDatetimeCode=false&serverTimezone=UTC");
                
            } catch (SQLException  e) {
                e.printStackTrace();
            }
        }
    }
    
    // connect to database with constant credentials
    public void connect() {
        if (connection == null) {
            try {
                
                connection = DriverManager.getConnection("jdbc:mysql://" + DatabaseConstants.DATABASE_URL + "/" + DatabaseConstants.DATABASE_NAME + "?" +
                                   "user=" + DatabaseConstants.USERNAME + "&password=" + DatabaseConstants.PASSWORD + "&useLegacyDatetimeCode=false&serverTimezone=UTC");
                
            } catch (SQLException  e) {
                e.printStackTrace();
            }
        }
    }

    // disconnect database
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    //Create a query with a string statement
    public ResultSet query(String statement) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(statement);
        return resultSet;
    }
    
    //Create a query with a prepared statement
    public ResultSet query(PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        return resultSet;
    }
    
    
}
