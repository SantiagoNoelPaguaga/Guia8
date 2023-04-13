/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3_guia8;

import entidades.Persona;
import servicios.PersonaServicio;

/**
 *
 * @author SantiagoPaguaga
 *  A continuación, en la clase main hacer lo siguiente: ●
 * Crear 4 objetos de tipo Persona con distintos valores, a continuación,
 * llamaremos todos los métodos para cada objeto, deberá comprobar si la persona
 * está en su peso ideal, tiene sobrepeso o está por debajo de su peso ideal e
 * indicar para cada objeto si la persona es mayor de edad. ● Por último,
 * guardaremos los resultados de los métodoss calcularIMC y eMayorDeEdad en
 * distintas variables(arrays), para después calcular un porcentaje de esas 4
 * personas cuantas están por debajo de su peso, cuantas en su peso ideal y
 * cuantos, por encima, y también calcularemos un porcentaje de cuantos son
 * mayores de edad y cuantos menores. Para esto, podemos crear unos métodos
 * adicionales.
 */
public class Ejercicio3_Guia8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonaServicio ps = new PersonaServicio();
        
        Persona[] personas = new Persona[4];
        
        for (int i = 0; i < personas.length; i++) {
            Persona p = ps.crearPersona();
            personas[i] = p;
        }
        
        for (Persona p : personas) {
            String aux = "";
            
            aux += ps.consultarDatos(p);
            if(ps.esMayorDeEdad(p)){
                aux += ", es mayor de edad";
            } else {
                aux += ", es menor de edad";
            }
            
            if(ps.calcularIMC(p) == -1){
                aux += ", está por debajo del peso ideal";
            } else if(ps.calcularIMC(p) == 0){
                aux += ", está en su peso ideal";
            } else {
                aux += ", tiene sobrepeso";
            }
            
            System.out.println(aux);
        }
        
        ps.porcentajeEdades(personas);
        ps.porcentajePesos(personas);
    }
    
}
