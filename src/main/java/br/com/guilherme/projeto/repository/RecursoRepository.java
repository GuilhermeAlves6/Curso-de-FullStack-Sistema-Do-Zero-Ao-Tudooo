package br.com.guilherme.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guilherme.projeto.entity.RecursoEntity;

public interface RecursoRepository extends JpaRepository<RecursoEntity, Long> {

}
