package com.example.modelsisspringbootfullstack.repositories;

import com.example.modelsisspringbootfullstack.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
}
