/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.NIF;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author SantiagoPaguaga
 *     NIFService se dispondrá de los
     * siguientes métodos:    La letra correspondiente al dígito verificador se
     * calculará a traves de un método que funciona de la siguiente manera: Para
     * calcular la letra se toma el resto de dividir el número de DNI por 23 (el
     * resultado debe ser un número entre 0 y 22). El método debe buscar en un
     * array (vector) de caracteres la posición que corresponda al resto de la
     * división para obtener la letra correspondiente. La tabla de caracteres es
     * la siguiente: 
 */
public class NIFService {
    
      private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    
//    a) Métodos getters y setters para el número de DNI y
//    la letra.
    
      public void modificarDNI(NIF nif){
          System.out.println("Ingrese el nuevo dni");
          nif.setDni(sc.nextLong());
      }
      
      public char consultarLetra(NIF nif){
          return nif.getLetra();
      }
      
       public long consultarDNI(NIF nif){
          return nif.getDni();
      }
    
//       b) Método crearNif(): le pide al usuario el DNI y con ese DNI
//     * calcula la letra que le corresponderá. Una vez calculado, le asigna la
//     * letra que le corresponde según
       
       public NIF crearNif(){
           System.out.println("Ingrese el DNI");
           long dni = sc.nextLong();
           
           char letra = calcularLetra(dni);
           
           return new NIF(dni, letra);
       }
       
       public char calcularLetra(long dni){
           char[] vector = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
           
           int posicionLetra = (int)dni % vector.length;
           
           return vector[posicionLetra];
       }
       
//       c) Método mostrar(): que nos permita
//     * mostrar el NIF (ocho dígitos, un guion y la letra en mayúscula; por
//     * ejemplo: 00395469-F).
       
       public void mostrar(NIF nif){
           System.out.println("NIF: " + consultarDNI(nif) + "-" + consultarLetra(nif));
       }
}
