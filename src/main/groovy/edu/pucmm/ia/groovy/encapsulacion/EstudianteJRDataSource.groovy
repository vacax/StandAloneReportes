package edu.pucmm.ia.groovy.encapsulacion

import net.sf.jasperreports.engine.JRDataSource
import net.sf.jasperreports.engine.JRException
import net.sf.jasperreports.engine.JRField

/**
 * Created by vacax on 11/22/14.
 */
class EstudianteJRDataSource implements JRDataSource {

    private List<Estudiante> listado;
    private int indice=-1;

    public EstudianteJRDataSource(){
        listado=new ArrayList<>();
        /*
        Puede ser cargado de la base de datos
         */
        (1..50).each {
            listado << new Estudiante(matricula: "$it", nombre: "Nombre $it", apellido: "Apellido $it");
        }
    }

    @Override
    boolean next() throws JRException {
        indice++;
        if(indice<listado.size()){
            return true;
        }
        return false;
    }

    @Override
    Object getFieldValue(JRField fila) throws JRException {
        Object tmp = null;
        if(fila.name=="matricula"){
           tmp = listado.get(indice).matricula
        }else if(fila.name=="nombre"){
            tmp = listado.get(indice).nombre
        }else if(fila.name=="apellido"){
            tmp = listado.get(indice).apellido
        }

        return tmp;
    }
}
