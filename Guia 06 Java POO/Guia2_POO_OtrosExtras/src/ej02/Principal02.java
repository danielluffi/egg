/*
 * Sin licencia.
 * Uso para capacitación
 * 2021 Año de la Prevención y Lucha contra el COVID-19.

Ejercicio 2
Definir la clase Tiempo, la cual tendrá la hora, minutos y segundos. Definir dos constructores: un
constructor vacío y otro con la hora, minutos y segundos ingresado por el usuario. Deberá definir
además, los métodos getters y setters correspondientes, y el método imprimirHoraCompleta().
Recordar crear una validación sobre las horas, minutos y segundos ingresados por el usuario. 
Te animas a simular el paso del tiempo en consola?


 */
package ej02;

import ej02.entidades.Tiempo;
import ej02.servicio.Control;

/**
 *
 * @author Adrian E. Camus
 */
public class Principal02 {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        // El Código va AQUI!!!
        
        Control ct = new Control();
        Tiempo t1 = ct.creaReloj();
        ct.reloj(t1);
    }

}
