package org.example;

public class Veiculo {
    private String placa;
    private String diaSemana;

    public Veiculo(String placa, String diaSemana) {
        this.placa = placa;
        this.diaSemana = diaSemana;
    }

    public String getPlaca() {
        return placa;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + " | Dia do Rodízio: " + diaSemana;
    }
}
