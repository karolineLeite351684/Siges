package br.com.fiap.siges.specification;

import br.com.fiap.siges.dto.filter.SolicitacaoListagemInternaFilterDTO;
import br.com.fiap.siges.model.Solicitacao;
import br.com.fiap.siges.model.Solicitacao_;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class SolicitacaoListagemIntenaSpecification implements Specification<Solicitacao> {

    private SolicitacaoListagemInternaFilterDTO filter;

    public SolicitacaoListagemIntenaSpecification(SolicitacaoListagemInternaFilterDTO filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<Solicitacao> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (filter.statusSolicitacao() != null) {
            predicates.add(criteriaBuilder.equal(root.get(Solicitacao_.STATUS_SOLICITACAO), filter.statusSolicitacao()));
        }

        if (filter.dataDaSolicitacao() != null) {
            predicates.add(criteriaBuilder.equal(root.get(Solicitacao_.DATA_DA_SOLICITACAO), filter.dataDaSolicitacao()));

        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
