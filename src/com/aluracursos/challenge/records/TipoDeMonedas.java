package com.aluracursos.challenge.records;

import java.util.Map;

public record TipoDeMonedas(String base_code,
                            Map<String, Double> conversion_rates) {
}