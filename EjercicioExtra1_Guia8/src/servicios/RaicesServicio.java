/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Raices;
import java.util.Scanner;

/**
 *
 * @author SantiagoPaguaga
 * 
 *  Luego, en RaicesServicio las operaciones que se podrán realizar son las
 * siguientes:  .  f) Método calcular(): esté método llamará tieneRaices() y
 * a tieneRaíz(), y mostrará por pantalla las posibles soluciones que tiene
 * nuestra ecuación con los métodos obtenerRaices() o obtenerRaiz(), según lo
 * que devuelvan nuestros métodos y en caso de no existir solución, se mostrará
 * un mensaje. Nota: Fórmula ecuación 2o grado: (-b±√((b^2)-(4*a*c)))/(2*a) Solo
 * varía el signo delante de -b
     * 
     * 
     * Raiz cuadrada de 4 ----> 2 ; -2
 */
public class RaicesServicio {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
   
    public Raices crearRaices(){
        
        System.out.println("Ingrese el coeficiente A");
        int a = sc.nextInt();
        System.out.println("Ingrese el coeficiente B");
        int b = sc.nextInt();
        System.out.println("Ingrese el coeficiente C");
        int c = sc.nextInt();
        
        return new Raices(a, b, c);
        
    }
    
    
// * a) Método getDiscriminante(): devuelve el valor del discriminante
// * (double). El discriminante tiene la siguiente fórmula: (b^2)-4*a*c 
    
    public double getDiscriminante(Raices raices){
        return Math.pow(raices.getB(), 2) - 4 * raices.getA() * raices.getC();
    }
    
// * b) Método tieneRaices(): devuelve un booleano indicando si tiene dos soluciones, para
// * que esto ocurra, el discriminante debe ser mayor que 0.
    
    public boolean tieneRaices(Raices raices){
//        if(getDiscriminante(raices) > 0){
//            return true;
//        } else {
//            return false;
//        }
        
        return getDiscriminante(raices) > 0;
    }
    
// * c) Método tieneRaiz(): devuelve un booleano indicando si tiene una única solución, para
// * que esto ocurra, el discriminante debe ser igual que 0
    
        public boolean tieneRaiz(Raices raices){
//        if(getDiscriminante(raices) == 0){
//            return true;
//        } else {
//            return false;
//        }
        
        return getDiscriminante(raices) == 0;
    }
        
// * d) Método obtenerRaices(): llama a tieneRaíces() y si devolvió́true, imprime las 2
// * posibles soluciones. (-b±√((b^2)-(4*a*c)))/(2*a)
        
        public void obtenerRaices(Raices raices){
            if(tieneRaices(raices)){
                System.out.println("Raíz 1: " + (-raices.getB() + Math.sqrt(getDiscriminante(raices)))/(2 * raices.getA()));
                System.out.println("Raíz 2: " + (-raices.getB() - Math.sqrt(getDiscriminante(raices)))/(2 * raices.getA()));
            }
        }
        
// * e) Método obtenerRaiz(): llama a tieneRaiz() y si
// * devolvió́true imprime una única raíz. Es en el caso en que se tenga una única
// * solución posible. (-b/(2*a)) el término del discriminante devuelve 0, por lo tanto se puede eliminar
        
       public void obtenerRaiz(Raices raices){
            if(tieneRaiz(raices)){
                System.out.println("Raíz 1: " + (-raices.getB() /(2 * raices.getA())));
            }
        } 
       
// * f) Método calcular(): esté método llamará tieneRaices() y
// * a tieneRaíz(), y mostrará por pantalla las posibles soluciones que tiene
// * nuestra ecuación con los métodos obtenerRaices() o obtenerRaiz(), según lo
// * que devuelvan nuestros métodos y en caso de no existir solución, se mostrará
// * un mensaje. Nota: Fórmula ecuación 2o grado: (-b±√((b^2)-(4*a*c)))/(2*a) Solo
// * varía el signo delante de -b
       
       public void calcular(Raices raices){
           if(tieneRaices(raices)){
               obtenerRaices(raices);
           } else if(tieneRaiz(raices)){
               obtenerRaiz(raices);
           } else {
               System.out.println("No tiene solución");
           }
       }
}
