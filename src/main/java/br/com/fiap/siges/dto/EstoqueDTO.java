package br.com.fiap.siges.dto;

public record EstoqueDTO(
        String tipo,
        String marca,
        String nome,
        String identificador,
        Integer quantidade
) {
}