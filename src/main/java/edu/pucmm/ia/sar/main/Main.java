package edu.pucmm.ia.sar.main;

import edu.pucmm.ia.groovy.servicios.BaseDatosServices;
import edu.pucmm.ia.sar.vista.VentanaApp;

/**
 * Created by vacax on 11/21/14.
 */
public class Main {

    public static void main(String[] args) {
        BaseDatosServices.getInstancia();
        new VentanaApp();
    }
}
