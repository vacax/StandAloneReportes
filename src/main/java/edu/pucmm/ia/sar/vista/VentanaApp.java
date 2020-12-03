package edu.pucmm.ia.sar.vista;

import edu.pucmm.ia.groovy.servicios.ReporteServices;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by vacax on 11/21/14.
 */
public class VentanaApp extends JFrame {

    private JButton visualizarReporteButton;
    private JPanel miPanel;
    private JButton reporteConexionButton;
    private JButton reporteParametrosButton;
    private JButton exportarPDFButton;
    private JButton reporteJRDataSourceButton;

    private ReporteServices reporteServices;


    public VentanaApp(){
        super("Proyecto StandAlone para JasperReport");

        miPanel =new JPanel();

        visualizarReporteButton = new JButton("Visualización");
        reporteConexionButton = new JButton("Conexión Reporte");
        reporteParametrosButton = new JButton("Reporte Parametros");
        exportarPDFButton = new JButton("Exportar");
        reporteJRDataSourceButton = new JButton("JRDataSource");

        miPanel.add(visualizarReporteButton);
        miPanel.add(reporteConexionButton);
        miPanel.add(reporteParametrosButton);
        miPanel.add(exportarPDFButton);
        miPanel.add(reporteJRDataSourceButton);

        this.getContentPane().add(miPanel);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500,300);
        reporteServices=new ReporteServices();


        visualizarReporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Presionando el botón: "+e.getActionCommand());

                //Mostrando el reporte..
                JasperViewer.viewReport(reporteServices.getReporteSimple(), false);
            }
        });

        reporteConexionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Presionando el botón: "+e.getActionCommand());

                //Mostrando el reporte..
                JasperViewer.viewReport(reporteServices.getReporteConexion(), false);
            }
        });

        reporteParametrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Presionando el botón: "+e.getActionCommand());

                //Mostrando el reporte..
                JasperViewer.viewReport(reporteServices.getReporteParametro("50"), false);
            }
        });

        exportarPDFButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Presionando el botón: "+e.getActionCommand());

                //Mostrando el reporte..
                try {
                    JasperExportManager.exportReportToPdfFile(reporteServices.getReporteParametro("50"), "" + File.createTempFile("Reporte Exportado", ".pdf").getPath());
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        reporteJRDataSourceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Presionando el botón: "+e.getActionCommand());

                //Mostrando el reporte..
                JasperViewer.viewReport(reporteServices.getReporteJRDataSource(), false);
            }
        });

        //
        setVisible(true);
    }
}
