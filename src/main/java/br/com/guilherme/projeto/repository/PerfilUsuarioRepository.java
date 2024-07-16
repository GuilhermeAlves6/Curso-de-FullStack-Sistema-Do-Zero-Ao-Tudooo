package br.com.guilherme.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guilherme.projeto.entity.PerfilUsuarioEntity;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuarioEntity, Long>{

}
