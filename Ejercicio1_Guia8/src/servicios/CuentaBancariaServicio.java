/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.CuentaBancaria;
import java.util.Scanner;

/**
 *
 * @author SantiagoPaguaga
  a) Método para crear cuenta pidiéndole los datos al
 * usuario.
 * b) Método ingresar(double): recibe una cantidad de dinero a ingresar
 * y se le sumará al saldo actual. 
 * c) Método retirar(double): recibe una
 * cantidad de dinero a retirar y se le restara al saldo actual. Si la cuenta no
 * tiene la cantidad de dinero a retirar se retirará el máximo posible hasta
 * dejar la cuenta en 0. 
 * d) Método extraccionRapida: le permitirá sacar solo un
 * 20% de su saldo. Validar que el usuario no saque más del 20%.
 * e) Método
 * consultarSaldo: permitirá consultar el saldo disponible en la cuenta.
 * f) Método consultarDatos: permitirá mostrar todos los datos de la cuenta.
 */
public class CuentaBancariaServicio {
    
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
 
    
    public CuentaBancaria crearCuentaBancaria(){
//        System.out.println("Ingrese el número de cuenta");
//        int numeroCuenta = sc.nextInt();
//        System.out.println("Ingrese el DNI del cliente");
//        long dniCliente = sc.nextLong();
//        System.out.println("Ingrese el saldo actual de la cuenta");
//        double saldoActual = sc.nextDouble();
//        
//        return new CuentaBancaria(numeroCuenta,dniCliente,saldoActual);
            
        CuentaBancaria cb = new CuentaBancaria();
        System.out.println("Ingrese el número de cuenta");
        cb.setNumeroCuenta(sc.nextInt());
        System.out.println("Ingrese el DNI del cliente");
        cb.setDniCliente(sc.nextLong());
        System.out.println("Ingrese el saldo actual de la cuenta");
        cb.setSaldoActual(sc.nextDouble());
        
        return cb;
    }
          
    public void ingresarDinero(double dinero, CuentaBancaria cb){
        cb.setSaldoActual(cb.getSaldoActual() + dinero);
    }
    
    public void retirarDinero(double dinero, CuentaBancaria cb){
        if(cb.getSaldoActual() > dinero){
            cb.setSaldoActual(cb.getSaldoActual() - dinero);
        } else {
            cb.setSaldoActual(0);
        }
    }
    
    public void extraccionRapida(double dinero, CuentaBancaria cb){
        if(cb.getSaldoActual() * 0.2 >= dinero){
            cb.setSaldoActual(cb.getSaldoActual() - dinero);
        } else {
            System.out.println("No puede retirar más del 20% de su saldo");
        }
    }
    
    public void consultarSaldo(CuentaBancaria cb){
        System.out.println("Su saldo es: $" + cb.getSaldoActual());
    }
    
    public long consultarDNI(CuentaBancaria cb){
        return cb.getDniCliente();
    }
    
    public void consultarDatos(CuentaBancaria cb){
        System.out.println(cb.toString());
    }
}
