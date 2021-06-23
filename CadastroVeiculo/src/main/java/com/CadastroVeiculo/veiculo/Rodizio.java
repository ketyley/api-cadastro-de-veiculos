package com.CadastroVeiculo.veiculo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Rodizio {

    SEGUNDA_FEIRA(Arrays.asList(0, 1), "segunda-feira", DayOfWeek.MONDAY),
    TERCA_FEIRA(Arrays.asList(2, 3), "terça-feira", DayOfWeek.TUESDAY),
    QUARTA_FEIRA(Arrays.asList(4, 5), "quarta-feira", DayOfWeek.WEDNESDAY),
    QUINTA_FEIRA(Arrays.asList(6, 7), "quinta-feira", DayOfWeek.THURSDAY),
    SEXTA_FEIRA(Arrays.asList(8, 9), "sexta-feira", DayOfWeek.FRIDAY),
    NAO_MAPEADO(new ArrayList<>(), "não mapeado", null);

    private final List<Integer> valores;
    private final String diaDaSemanaFormatado;
    private final DayOfWeek diaDaSemana;

    Rodizio(List<Integer> valores, String diaDaSemanaFormatado, DayOfWeek diaDaSemana) {
        this.valores = valores;
        this.diaDaSemanaFormatado = diaDaSemanaFormatado;
        this.diaDaSemana = diaDaSemana;
    }

    public List<Integer> getValores() {
        return this.valores;
    }
    public String getDiaDaSemanaFormatado() {
        return this.diaDaSemanaFormatado;
    }
    public DayOfWeek getDiaDaSemana() {
        return this.diaDaSemana;
    }

    public static Rodizio buscarDiaDeRodizio(int ultimoDigito) {
        for (Rodizio rodizio : Rodizio.values()) {
            if (rodizio.getValores().contains(ultimoDigito)) {
                return rodizio;
            }
        }
        return NAO_MAPEADO;
    }

    public boolean rodizioAtivo() {
        DayOfWeek diaDaSemana = DayOfWeek.WEDNESDAY;
        return (this.getDiaDaSemana().equals(diaDaSemana));
    }
}
