package practica14;

import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.style.Styler.ChartTheme;
import org.knowm.xchart.style.colors.ChartColor;
import org.knowm.xchart.style.colors.XChartSeriesColors;
import org.knowm.xchart.SwingWrapper;
import java.util.List;
import java.util.LinkedList;

/**
 * Clase para crear una grafica a partir de un CSV con puntos y hacer regresion lineal
 */
public class Graficacion {

    public static void main(String[] args) {
        XYChart chart = new XYChartBuilder()
                            .title("Regresión lineal")
                            .width(800)
                            .height(600)
                            .xAxisTitle("X")
                            .yAxisTitle("Y")
                            .theme(ChartTheme.Matlab)
                            .build();
     
        chart.getStyler().setPlotBackgroundColor(ChartColor.getAWTColor(ChartColor.GREY));
        chart.getStyler().setChartTitleVisible(true);
        chart.getStyler().setLegendPosition(LegendPosition.InsideSW);
        chart.getStyler().setPlotGridLinesVisible(false);
        chart.getStyler().setMarkerSize(6);

        // Leer datos
        List<String[]> datos = new LinkedList<>();
        try {
            datos = LectorCSV.leer("src/main/resources/317309575.csv");
        }
        catch(Exception e) {
            System.out.println(e);
            return;
        }

        double[] xData = new double[datos.size()];
        double[] yData = new double[datos.size()];

        int i=0;
        for(String[] linea: datos) {
            xData[i] = (double) Double.parseDouble(linea[0]);
            yData[i] = (double) Double.parseDouble(linea[1]);
            i++;
        }
        

        // Regresion lineal
        double sumaX = 0, sumaY = 0, multXY = 0, cuadradoX = 0;
        int n = xData.length;
        for (int k=0; k<xData.length; k++) {
            sumaX += xData[k];
            sumaY += yData[k];

            multXY += xData[k] * yData[k];
            cuadradoX += Math.pow(xData[k], 2);
        }

        double m = (n*multXY - sumaX * sumaY) / (n * cuadradoX - Math.pow(sumaX, 2));
        double b = (sumaY - m * sumaX) / n;

        // Puntos de recta
        double x1 = xData[0],
            x2 = xData[xData.length - 1],
            y1 = (m * x1) + b,
            y2 = (m * x2) + b;

        XYSeries sampleSeries = chart.addSeries("Observaciones", xData, yData);
        sampleSeries.setXYSeriesRenderStyle(XYSeriesRenderStyle.Scatter);
        sampleSeries.setMarkerColor(XChartSeriesColors.RED);

        XYSeries lineSeries = chart.addSeries(
                                              "Línea", new double[]{x1, x2}, new double[]{y1, y2} );
        lineSeries.setXYSeriesRenderStyle(XYSeriesRenderStyle.Line);
        lineSeries.setLineColor(XChartSeriesColors.BLUE);
        lineSeries.setLineWidth(3);

        new SwingWrapper<XYChart>(chart).displayChart();
    }

}
