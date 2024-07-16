package com.aluracursos.challenge.records;

public record Conversor(String base_code,
                        String target_code,
                        double conversion_rate) {
    @Override
    public String toString() {
        return "Convirtiendo tipo de moneda {" +
                "De: " + base_code + ", " +
                "A: " + target_code + ", " +
                "1.00 " + base_code + " = " + conversion_rate + " " + target_code +
                '}';
    }
}