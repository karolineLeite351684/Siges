package br.com.fiap.siges.repository;

import br.com.fiap.siges.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}