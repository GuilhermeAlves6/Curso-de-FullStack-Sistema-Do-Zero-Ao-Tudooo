package br.com.guilherme.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guilherme.projeto.entity.UsuarioVerificadorEntity;

public interface UsuarioVerificadorRepository extends JpaRepository<UsuarioVerificadorEntity, Long>{

}
