package InformeFinal;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import Service.Conexion;

// TODO: Auto-generated Javadoc
/**
 * The Class LineChartEx.
 */
public class LineChartEx extends JFrame {

	/** The c. */
	private Conexion c = new Conexion();

	/**
	 * Instantiates a new line chart ex.
	 */
	public LineChartEx() {

		initUI();
	}

	/**
	 * Inits the UI.
	 */
	private void initUI() {

		XYDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);
		XYPlot plot = chart.getXYPlot();

		String[] months = new String[] { "", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
				"Septiembre", "Octubre", "Noviembre", "Diciembre", "" };
		SymbolAxis xAxis = new SymbolAxis("Meses", months);
		xAxis.setTickUnit(new NumberTickUnit(1));
		plot.setDomainAxis(xAxis);

		NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
		yAxis.setTickUnit(new NumberTickUnit(1));

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);

		add(chartPanel);

		pack();
		setTitle("Informe Final");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Creates the dataset.
	 *
	 * @return the XY dataset
	 */
	private XYDataset createDataset() {
		var series = new XYSeries("2023");

		try {
			Connection conn = c.obtener();
			java.sql.Statement statement = conn.createStatement();

			String query = "SELECT MONTH(fechaHora) AS mes, COUNT(*) AS sales FROM Venta WHERE YEAR(fechaHora) = 2023 GROUP BY MONTH(fechaHora)";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				int month = resultSet.getInt("mes");
				int sales = resultSet.getInt("sales");
				series.add(month, sales);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		var dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		return dataset;
	}

	/**
	 * Creates the chart.
	 *
	 * @param dataset the dataset
	 * @return the j free chart
	 */
	private JFreeChart createChart(XYDataset dataset) {

		JFreeChart chart = ChartFactory.createXYLineChart("Compras de Vehiculos 2023", "Meses", "Nº Compras", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		XYPlot plot = chart.getXYPlot();

		var renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(1.5f));

		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.white);

		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);

		chart.getLegend().setFrame(BlockBorder.NONE);

		chart.setTitle(new TextTitle("Compras de Vehiculos 2023", new Font("Serif", java.awt.Font.BOLD, 18)));

		return chart;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {

			var ex = new LineChartEx();
			ex.setVisible(true);
		});
	}
}