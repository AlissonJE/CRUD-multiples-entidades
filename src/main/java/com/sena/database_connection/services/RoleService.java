package com.sena.database_connection.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sena.database_connection.entities.Role;
import com.sena.database_connection.repositories.RoleRepository;

@Service
public class RoleService {

    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public List<Role> obetenerTodos() {
        return this.repository.findAll();
    }

    public Optional<Role> porId(Long id) {
        return this.repository.findById(id);
    }

    public Role crear(Role role) {
        return this.repository.save(role);
    }

    public Role actualizar(Role role) {
        if (role.getId() == null || !this.repository.existsById(role.getId())) {
            return null;
        }
        return this.repository.save(role);
    }

    public Role eliminar(Long id) {
        Optional<Role> roleOptional = this.repository.findById(id);

        if (roleOptional.isEmpty()) {
            return null;
        }

        Role roleDeleted = roleOptional.get();
        this.repository.deleteById(id);
        
        return roleDeleted;
    }
}