package com.gama.passagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gama.passagens.model.acesso.Role;

public interface RoleRepository extends JpaRepository<Role,String> {

}
