package edu.pucmm.ia.groovy.servicios

import edu.pucmm.ia.groovy.encapsulacion.EstudianteJRDataSource
import groovy.sql.Sql
import net.sf.jasperreports.engine.JasperFillManager
import net.sf.jasperreports.engine.JasperPrint
import net.sf.jasperreports.engine.JasperReport
import net.sf.jasperreports.engine.util.JRLoader

/**
 * Created by vacax on 11/21/14.
 */
class ReporteServices {

    /**
     * Mostrando un reporte simple sin conexión y sin parametros.
     * El reporte está configurada para presentar todas las secciones cuando no existe datos.
     * @return
     */
    public JasperPrint getReporteSimple(){

        //Cargando el reporte desde el Jar del proyecto. Reporte compilado.
        JasperReport reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResource("/edu/pucmm/ia/groovy/reportes/PruebaReporte.jasper"));

        //Mandando a ejecutar el proyecto.
        JasperPrint print = JasperFillManager.fillReport(reporte, null);

        return print;
    }

    /**
     * Reporte que utiliza la conexión a H2.
     * @return
     */
    public JasperPrint getReporteConexion(){

        //Obteniendo la conexion.
        Sql con = BaseDatosServices.instancia.conexion;

        //Cargando el reporte desde el Jar del proyecto. Reporte compilado.
        JasperReport reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResource("/edu/pucmm/ia/groovy/reportes/PruebaEstudiante.jasper"));

        //Mandando a ejecutar el proyecto.
        JasperPrint print = JasperFillManager.fillReport(reporte, null ,con.connection);

        return print;

    }

    /**
     * Metodo para obtener un reporte indicando un parametro y la conexión H2.
     * @param matricula
     * @return
     */
    public JasperPrint getReporteParametro(String matricula){

        //Obteniendo la conexion.
        Sql con = BaseDatosServices.instancia.conexion;

        //Parametros.
        HashMap<String, Object> parametros=new HashMap<>();
        parametros.put("matricula", matricula) //Nombre del parametro del reporte para el key y el value el tipo que corresponde.

        //Cargando el reporte desde el Jar del proyecto. Reporte compilado.
        JasperReport reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResource("/edu/pucmm/ia/groovy/reportes/PruebaEstudianteParametro.jasper"));

        //Mandando a ejecutar el proyecto.
        JasperPrint print = JasperFillManager.fillReport(reporte, parametros ,con.connection);

        return print;

    }

    /**
     * Reporte que utiliza envia una coleccion de datos
     * @return
     */
    public JasperPrint getReporteJRDataSource(){

        //Obteniendo le objeto que implementa el JRDataSource.
        EstudianteJRDataSource datos = new EstudianteJRDataSource();

        //Cargando el reporte desde el Jar del proyecto. Reporte compilado.
        JasperReport reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResource("/edu/pucmm/ia/groovy/reportes/PruebaEstudiante.jasper"));

        //Mandando a ejecutar el proyecto.
        JasperPrint print = JasperFillManager.fillReport(reporte, null , datos);

        return print;

    }


}
