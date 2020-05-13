/*
 * Name: Callum Bass
 * Student ID: w1682693
 * Software Development - Group Project
 */
package graph;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import sql.DatabaseManager;

/**
 *
 * @author Callum Bass <w1682693>
 */
public class W1687385_Group1 {
    
    public static BarChart createGraph() throws SQLException {
    NumberAxis xAxis = new NumberAxis();
     CategoryAxis yAxis = new CategoryAxis();
     String itemA = "ProjectId";
     String itemB = "Funding_Scheme";
     String itemC = "Title";
    
     int i=1;
     int j=2;
  XYChart.Data<String, Number> data =  new XYChart.Data<>();
    
  BarChart<String,Number> bchart=new BarChart<>(yAxis, xAxis);
  bchart.setPrefSize(500, 400);
  bchart.setTitle("khalood's graph");
     xAxis.setLabel("......");
     xAxis.setTickLabelRotation(45);
     yAxis.setTickLabelRotation(45);
     yAxis.setLabel("funding scheme");
     XYChart.Series series1 = new XYChart.Series();
     XYChart.Series series2 = new XYChart.Series();
     series1.setName("Data"); // 
     
     DatabaseManager manager = new DatabaseManager();
        
        
        manager.connect();
        
        try{
         String mysql;
      //mysql = "SELECT * from Funding_Scheme";
         ResultSet rset = manager.query("SELECT FundingSchemeId, COUNT(FundingSchemeId) as Count FROM Funding_Scheme GROUP BY FundingSchemeId");
         while(rset.next()){
           data = new XYChart.Data<>(rset.getString(i),rset.getDouble(j));
           series1.getData().add(data);
           
          
          
         } i++;j++;
       
        }catch(SQLException e){
            
        
        }
     bchart.getData().addAll(series1);
    return bchart;
    }
    
}
