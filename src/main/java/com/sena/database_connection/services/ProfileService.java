package com.sena.database_connection.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sena.database_connection.entities.Profile;
import com.sena.database_connection.repositories.ProfileRepository;

@Service
public class ProfileService {

    private final ProfileRepository repository;

    public ProfileService(ProfileRepository repository) {
        this.repository = repository;
    }

    public List<Profile> obetenerTodos() {
        return this.repository.findAll();
    }

    public Optional<Profile> porId(Long id) {
        return this.repository.findById(id);
    }

    public Profile crear(Profile profile) {
        return this.repository.save(profile);
    }

    public Profile actualizar(Profile profile) {
        if (profile.getId() == null || !this.repository.existsById(profile.getId())) {
            return null;
        }
        return this.repository.save(profile);
    }

    public Profile eliminar(Long id) {
        Optional<Profile> profileOptional = this.repository.findById(id);

        if (profileOptional.isEmpty()) {
            return null;
        }

        Profile profileDeleted = profileOptional.get();
        this.repository.deleteById(id);
        
        return profileDeleted;
    }
}