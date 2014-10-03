import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class PieChart extends JFrame {
  private Brain brain;
  private JFrame window;
  private static final long serialVersionUID = 1L;
  
  Food a = new Food("Food");
  Beverage b = new Beverage("Beverage");
  Clothing c = new Clothing("Clothing");
  Entertainment d = new Entertainment("Entertainment");
  Taxes e = new Taxes("Taxes");
  
  public PieChart(Brain b, JFrame j, String chartTitle) {
        super("SmartWallet");
        
        brain = b;
        window = j;
        // This will create the dataset 
        PieDataset dataset = createDataset();
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, chartTitle);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        //chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        chartPanel.setSize(500, 500);
        // add it to our application
        setContentPane(chartPanel);

    }
    
    
 


/**
     * Creates a sample dataset 
     */

    private  PieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Food", brain.CategorySpendings(a)*100/brain.getSpend());
        result.setValue("Beverage", brain.CategorySpendings(b)*100/brain.getSpend());
        result.setValue("Clothing", brain.CategorySpendings(c)*100/brain.getSpend());
        result.setValue("Entertainment", brain.CategorySpendings(d)*100/brain.getSpend());
        result.setValue("Taxes", brain.CategorySpendings(e)*100/brain.getSpend());
        return result;
        
    }
    
    
/**
     * Creates a chart
     */

    private JFreeChart createChart(PieDataset dataset, String title) {
        
        JFreeChart chart = ChartFactory.createPieChart3D(title,          // chart title
            dataset,                // data
            true,                   // include legend
            true,
            false);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;
        
    }
} 