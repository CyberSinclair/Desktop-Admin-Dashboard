/*
 * Name: Gayatri Rajgor
 * Student ID: w1648585
 * Software Development - Group Project
 */
package graph;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import sql.DatabaseManager;

/**
 *
 * @author gayat
 */
public class W1648585_Graph {
    
    //Returns a PieChart
    public static PieChart createGraph() throws SQLException {
        
        //Connection to DB
        DatabaseManager manager = new DatabaseManager();
        manager.connect();
        System.out.println("Connection made. Graph is printing...");
        
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList();
        
        //SQL Query set to retrieve data from specific table from DB
        ResultSet data = manager.query("SELECT Name, ProjectId " + "FROM Proj_Topic WHERE ProjectId = 633127 ");
        
        while (data.next()) {
            pieChartData.add(new PieChart.Data(data.getString("Name"), data.getInt("ProjectId")));
        }
        //Disconnect the connection from the database
        manager.disconnect();
        
        final PieChart chart = new PieChart(pieChartData);
        
        //Title of chart
        chart.setTitle("Graph of organisations assigned "
                + "to ProjectAcronym: UPWARDS" );
        
        return chart;
    }
    
}