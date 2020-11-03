package com.gama.passagens.repository;

import org.springframework.data.repository.CrudRepository;

import com.gama.passagens.model.acesso.Role;

public interface RoleRepository extends CrudRepository<Role, String> {

	
}
