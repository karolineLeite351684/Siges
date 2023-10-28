package br.com.fiap.siges.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Estoque")
@Getter
@Setter
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String tipo;

    private String marca;

    private String nome;

    private String identificador;

    private Integer quantidade;

    private LocalDateTime dataEntrada;

    private LocalDateTime dataAtualizacao;

}