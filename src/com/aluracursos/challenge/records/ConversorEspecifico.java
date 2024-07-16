package com.aluracursos.challenge.records;

public record ConversorEspecifico(String base_code,
                                  String target_code,
                                  double conversion_rate,
                                  double conversion_result) {

    public static double CANTIDAD(ConversorEspecifico conversor) {
        return conversor.conversion_result / conversor.conversion_rate;
    }

    @Override
    public String toString() {
        return "Convirtiendo tipo de moneda {" +
                "De: " + base_code + ", " +
                "A: " + target_code + ", " +
                CANTIDAD(this) +" " + base_code + " = " + conversion_result + " " + target_code +
                '}';
    }
}