package com.example.modelsisspringbootfullstack.services;

import com.example.modelsisspringbootfullstack.entities.Utilisateur;
import com.example.modelsisspringbootfullstack.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Optional<Utilisateur> findById(int id){return utilisateurRepository.findById(id);}

    public List<Utilisateur> getAll(){return utilisateurRepository.findAll();}

    public Utilisateur create(String userName, String password){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUserName(userName);
        utilisateur.setPassword(password);


        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur update(int id, Utilisateur utilisateur){
        Utilisateur newUtilisateur = findById(id).get();
        newUtilisateur.setUserName(utilisateur.getUserName());
        newUtilisateur.setPassword(utilisateur.getPassword());

        return utilisateurRepository.save(newUtilisateur);
    }

    public  void delete(int id){
        utilisateurRepository.deleteById(id);
    }
}
