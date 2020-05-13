/*
 * Name: David Sinclair
 * Student ID: w1690566
 * Software Development - Group Project
 */
package graph;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import sql.DatabaseConstants;
import sql.DatabaseManager;

/**
 *
 * @author David Sinclair
 */
public class W1690566_Graph {
    
    //At the moment, returns just a PieChart object, you can alter the return type to another type of chart, research JavaFX Charts
    public static PieChart createGraph() throws SQLException {
        
        //Example of how you can use DatabaseManager to open a connection to the database.
        DatabaseManager manager = new DatabaseManager();
        
        
        manager.connect();
        
        
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList();
        
        //Querying database
        ResultSet data = manager.query("SELECT topics,ecMaxContribution,projectUrl,projectRcn "
                + "FROM Project WHERE ecMaxContribution >= 113184515.20;");
        
        while (data.next()) {
            pieChartData.add(new PieChart.Data(data.getString("topics"), data.getInt("ecMaxContribution")));
           
        }
        //Disconnecting from the database
        manager.disconnect();
        
        //This creates a pie chart data list
        
        
        //PieChart object created and assigned the data
        final PieChart chart = new PieChart(pieChartData);
        
        //Chart is set a title
        chart.setTitle("David's project Graph");
        
        //PieChart object is returned and eventually displayed on grid, leave the display part to me, just make sure you return a chart object.
        return chart;
    }
    
}