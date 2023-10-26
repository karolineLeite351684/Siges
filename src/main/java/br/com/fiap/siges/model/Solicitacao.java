package br.com.fiap.siges.model;

import br.com.fiap.siges.enumeration.StatusDaSolicitacaoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "solicitacao")
@Getter
@Setter
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String idSolicitacao;

    @Enumerated(EnumType.STRING)
    private StatusDaSolicitacaoEnum statusSolicitacao;

    private String nomeDoSolicitante;

    private LocalDate dataDaSolicitacao;

    private Boolean ehUmNovoColaborador;

    private String descricaoPedido;

    private String respostaPedido;
}
