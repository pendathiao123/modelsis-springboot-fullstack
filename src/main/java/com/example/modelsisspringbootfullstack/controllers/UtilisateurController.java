package com.example.modelsisspringbootfullstack.controllers;

import com.example.modelsisspringbootfullstack.entities.Utilisateur;
import com.example.modelsisspringbootfullstack.services.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/test_recrutement")
public class UtilisateurController {
    private final UtilisateurService utilisateurService;


    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping("/user")
    public ResponseEntity<String> add(@RequestParam("userName") String userName, @RequestParam("password") String password){
        utilisateurService.create(userName,password);
        return ResponseEntity.ok().body("{\"message\": \"utilisateur ajouté\"}");
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<Utilisateur> get(@PathVariable("id") int id){
        Utilisateur utilisateur = utilisateurService.findById(id).get();
        return ResponseEntity.ok().body(utilisateur);
    }
    @GetMapping("/user/all")
    public ResponseEntity<List<Utilisateur>> getAll(){
        List<Utilisateur> utilisateurs = utilisateurService.getAll();
        return ResponseEntity.ok().body(utilisateurs);
    }
    @DeleteMapping("/user/delete")
    public ResponseEntity<String> deleteUser(@RequestParam("id") int id){
        utilisateurService.delete(id);
        return ResponseEntity.ok().body("{\"message\": \"utulisateur supprimé\"}");
    }
    @PutMapping("/user/update")
    public ResponseEntity<Utilisateur> update(@RequestParam("id") int id, @RequestBody Utilisateur utilisateur){
        Utilisateur newUtilisateur = utilisateurService.update(id, utilisateur);
        return ResponseEntity.ok().body(newUtilisateur);
    }


}
