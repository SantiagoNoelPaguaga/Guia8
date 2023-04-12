/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1_guia8;

import entidades.CuentaBancaria;
import java.util.Scanner;
import servicios.CuentaBancariaServicio;

/**
 *
 * @author SantiagoPaguaga
 */
public class Ejercicio1_Guia8 {

    /**
     * @param args the command line arguments
     * Realizar una clase llamada
     * CuentaBancaria en el paquete Entidades con los siguientes atributos:
     * numeroCuenta(entero), dniCliente(entero largo), saldoActual. Agregar
     * constructor vacío, con parámetros, getters y setters. Agregar la clase
     * CuentaBancariaServicio en el paquete Servicios que contenga: a) Método
     * para crear cuenta pidiéndole los datos al usuario. b) Método
     * ingresar(double): recibe una cantidad de dinero a ingresar y se le sumará
     * al saldo actual. c) Método retirar(double): recibe una cantidad de dinero
     * a retirar y se le restara al saldo actual. Si la cuenta no tiene la
     * cantidad de dinero a retirar se retirará el máximo posible hasta dejar la
     * cuenta en 0. d) Método extraccionRapida: le permitirá sacar solo un 20%
     * de su saldo. Validar que el usuario no saque más del 20%. e) Método
     * consultarSaldo: permitirá consultar el saldo disponible en la cuenta. f)
     * Método consultarDatos: permitirá mostrar todos los datos de la cuenta.
     */
    public static void main(String[] args) {
        CuentaBancariaServicio cs = new CuentaBancariaServicio();
        Scanner sc = new Scanner(System.in);
        int op;
        int contador = 0;
        long dni;
        
        System.out.println("¿Cuántas cuentas bancarias desea ingresar");
        int cantidad = sc.nextInt();
        CuentaBancaria[] banco = new CuentaBancaria[cantidad];
        
        do {            
            System.out.println("Ingrese la opción deseada");
            System.out.println("1. Crear una nueva cuenta bancaria");
            System.out.println("2. Realizar depósito");
            System.out.println("3. Extraer dinero");
            System.out.println("4. Extracción rápida");
            System.out.println("5. Consultar Saldo");
            System.out.println("6. Consultar datos de la cuenta bancaria");
            System.out.println("7. Salir");
            
            op = sc.nextInt();
            
            switch (op) {
                case 1:
                    if(contador < banco.length){
                        banco[contador] = cs.crearCuentaBancaria();
                        contador++;
                    } else {
                        System.out.println("Alcanzó el límite de cuentas permitidas");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el dni del titular de la cuenta");
                    dni = sc.nextLong();
                    for (int i = 0; i < banco.length; i++) {
                        if(cs.consultarDNI(banco[i]) == dni){
                            System.out.println("¿Cuánto dinero desea depositar?");
                            double dinero = sc.nextDouble();
                            cs.ingresarDinero(dinero , banco[i]);
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el dni del titular de la cuenta");
                    dni = sc.nextLong();
                    for (int i = 0; i < banco.length; i++) {
                        if(cs.consultarDNI(banco[i]) == dni){
                            System.out.println("¿Cuánto dinero desea retirar?");
                            double dinero = sc.nextDouble();
                            cs.retirarDinero(dinero , banco[i]);
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el dni del titular de la cuenta");
                    dni = sc.nextLong();
                    for (int i = 0; i < banco.length; i++) {
                        if(cs.consultarDNI(banco[i]) == dni){
                            System.out.println("¿Cuánto dinero desea retirar?");
                            double dinero = sc.nextDouble();
                            cs.extraccionRapida(dinero , banco[i]);
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el dni del titular de la cuenta");
                    dni = sc.nextLong();
                    for (CuentaBancaria cb : banco) {
                        if(cs.consultarDNI(cb) == dni){
                            cs.consultarSaldo(cb);
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el dni del titular de la cuenta");
                    dni = sc.nextLong();
                    for (CuentaBancaria cb : banco) {
                        if(cs.consultarDNI(cb) == dni){
                            cs.consultarDatos(cb);
                            break;
                        }
                    }
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Ingresaste una opcíón incorrecta");
                    break;
            }
        } while (op != 7);
    }
    
}
