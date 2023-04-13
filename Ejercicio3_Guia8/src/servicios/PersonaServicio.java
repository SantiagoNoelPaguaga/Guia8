/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Persona;
import java.util.Scanner;

/**
 *
 * @author SantiagoPaguaga
 * En el paquete Servicios crear PersonaServicio con los
 * siguientes 3 métodos:  
 */
public class PersonaServicio {
      
      private static Scanner sc = new Scanner(System.in).useDelimiter("\n");
      
//    a) Método esMayorDeEdad(): indica si la persona es
//    mayor de edad. La función devuelve un booleano.
    
      public boolean esMayorDeEdad(Persona persona){
//         if(persona.getEdad() > 17){
//             return true;
//         } else {
//             return false;
//         }
           return persona.getEdad() > 17;
      }
      
// *  b) Metodo crearPersona(): el
// * método crear persona, le pide los valores de los atributos al usuario y
// * después se le asignan a sus respectivos atributos para llenar el objeto
// * Persona. Además, comprueba que el sexo introducido sea correcto, es decir, H,
// * M u O. Si no es correcto se deberá mostrar un mensaje 3
    
      char sexo;
        
      public Persona crearPersona(){
          Persona p = new Persona();
          System.out.println("Ingrese el nombre");
          p.setNombre(sc.next());
          System.out.println("Ingrese la edad");
          p.setEdad(sc.nextInt());
          System.out.println("Ingrese el peso en kg");
          p.setPeso(sc.nextDouble());
          System.out.println("Ingrese el altura en metros");
          p.setAltura(sc.nextDouble());
          
          do {              
              System.out.println("Ingrese el sexo, valores permitidos (H,M,O)");
              sexo = sc.next().toUpperCase().charAt(0);
              if(sexo == 'M' || sexo == 'H' || sexo == 'O'){
                  p.setSexo(sexo);
              }        
          } while (sexo != 'M' && sexo != 'H' && sexo != 'O');
   
          return p;
      }
      
// * c) Método
// * calcularIMC(): calculara si la persona está en su peso ideal (peso en
// * kg/(altura^2 en mt2)). Si esta fórmula da por resultado un valor menor que
// * 20, significa que la persona está por debajo de su peso ideal y la función
// * devuelve un -1. Si la fórmula da por resultado un número entre 20 y 25
// * (incluidos), significa que la persona está en su peso ideal y la función
// * devuelve un 0. Finalmente, si el resultado de la fórmula es un valor mayor
// * que 25 significa que la persona tiene sobrepeso, y la función devuelve un 1.
      
      public int calcularIMC(Persona persona){
          double resultado = persona.getPeso() / Math.pow(persona.getAltura(),2);
          
          if(resultado < 20){
              return -1;
          } else if(resultado >= 20 && resultado <= 25){
              return 0;
          } else {
              return 1;
          }
      }
      
      public String consultarDatos(Persona persona){
          return persona.toString();
      }
      
      public void porcentajeEdades(Persona[] personas){
          int mayores = 0;
          int menores = 0;
          
          for (int i = 0; i < personas.length; i++) {
              if(esMayorDeEdad(personas[i])){
                  mayores++;
              } else {
                  menores++;
              }
          }
          
          System.out.println("Porcentaje de personas mayores de edad: " + (double)mayores/personas.length*100);
          System.out.println("Porcentaje de personas menores de edad: " + (double)menores/personas.length*100);
          
      }
      
      public void porcentajePesos(Persona[] personas){
          int bajoPeso = 0;
          int pesoIdeal = 0;
          int sobrepeso = 0;
          
          for (int i = 0; i < personas.length; i++) {
              if(calcularIMC(personas[i]) == -1){
                  bajoPeso++;
              } else if(calcularIMC(personas[i]) == 0){
                  pesoIdeal++;
              } else {
                  sobrepeso++;
              }
          }
          
          System.out.println("Porcentaje de personas por debajo del peso ideal: " + (double)bajoPeso/personas.length*100);
          System.out.println("Porcentaje de personas con peso ideal: " + (double)pesoIdeal/personas.length*100);
          System.out.println("Porcentaje de personas con sobrepeso: " + (double)sobrepeso/personas.length*100);
          
          
      }
      
      
}
