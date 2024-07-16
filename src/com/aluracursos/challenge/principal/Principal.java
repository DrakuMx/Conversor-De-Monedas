package com.aluracursos.challenge.principal;

import com.aluracursos.challenge.request.RequestConvertirTipoDeMoneda;
import com.aluracursos.challenge.request.RequestConvertirTipoDeMonedaEspecifica;
import com.aluracursos.challenge.request.RequestTiposdeMoneda;
import com.aluracursos.challenge.records.Conversor;
import com.aluracursos.challenge.records.ConversorEspecifico;
import com.aluracursos.challenge.records.TipoDeMonedas;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        System.out.println("""
        Iniciando Challenge Conversor de Monedas
        """);
        Scanner teclado = new Scanner(System.in);

        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    Ejemplo de monedas que puedes utilizar:
                    ARS - Peso argentino
                    BOB - Boliviano boliviano
                    BRL - Real brasileño
                    CLP - Peso chileno
                    COP - Peso colombiano
                    USD - Dólar estadounidense
                    MXN - Peso Mexicano
                    
                    1 - Obtener los datos sobre todos los tipos de monedas que tenemos.
                    2 - Convertir el tipo de moneda.
                    3 - Convertir el tipo de moneda segun una cantidad especifica.
                    
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {

                case 1:
                    Scanner lectura = new Scanner(System.in);
                    RequestTiposdeMoneda pedir = new RequestTiposdeMoneda();
                    System.out.println("Escriba la moneda de la cual quiera saber los datos: ");
                    try {
                        var moneda = lectura.nextLine();
                        TipoDeMonedas DatosMonedas = pedir.DatosMonedas(moneda);
                        System.out.println(DatosMonedas);
                    } catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println(" ");
                    break;
                case 2:
                    Scanner lectura1 = new Scanner(System.in);
                    RequestConvertirTipoDeMoneda pedir1 = new RequestConvertirTipoDeMoneda();
                    System.out.println("Escriba la primera moneda: ");
                    try {
                        var moneda1 = lectura1.nextLine();
                        System.out.println("Escriba la Segunda moneda: ");
                        var moneda2 = lectura1.nextLine();
                        Conversor conversor = pedir1.convertirMonedaXMoneda(moneda1, moneda2);
                        System.out.println(conversor);
                    } catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println(" ");
                    break;
                case 3:
                    Scanner lectura2 = new Scanner(System.in);
                    RequestConvertirTipoDeMonedaEspecifica pedir2 = new RequestConvertirTipoDeMonedaEspecifica();
                    System.out.println("Escriba la primera moneda: ");
                    try {
                        var moneda1 = lectura2.nextLine();
                        System.out.println("Escriba la Segunda moneda: ");
                        var moneda2 = lectura2.nextLine();
                        System.out.println("Escriba la cantidad: ");
                        double cantidad = Double.parseDouble(lectura2.nextLine());
                        ConversorEspecifico conversor2 = pedir2.convertirMonedaXMoneda(moneda1, moneda2, cantidad);
                        System.out.println(conversor2);
                    } catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println(" ");
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    System.out.println(" ");
                    break;
                default:
                    System.out.println("Opción inválida");
                    System.out.println(" ");
            }
        }
    }
}
