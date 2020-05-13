
package graph;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.chart.PieChart;
import sql.DatabaseManager;

/**
 *
 * @author Atiya
 */
public class W1690091_Graph {
    
    //Returns a PieChart
    public static PieChart createGraph() throws SQLException {
        
        
         List<String> names = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
    
        //Connection to DB
        DatabaseManager manager = new DatabaseManager();
        manager.connect();
        
        ResultSet queryRes = null;

        try { 
           
            queryRes = manager.query("SELECT ActivityType, COUNT(*) FROM `organisation` group by ActivityType"); //not here 
            int n = 0;
            System.out.println("query");
            values.clear();
            names.clear();
            while (queryRes.next()) 
            {
                names.add(queryRes.getString(1));
                values.add(queryRes.getInt(2));
            
            }
            
        } catch (SQLException e) {

            System.out.println("ERROR: cannot execute query....");
            e.printStackTrace();
            

        }
        
        manager.disconnect();
        
        PieChart pieChart = new PieChart();
        for (int i = 0; i < names.size(); i++) {
             PieChart.Data slice = new PieChart.Data(names.get(i), values.get(i));
             pieChart.getData().add(slice);
        }
        
        return pieChart;
    }
    
}
