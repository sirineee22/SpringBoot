package tn.esprit.tpfoyer.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entities.Etudiant;
import tn.esprit.tpfoyer.Services.EtudiantService;

import java.util.List;

@RestController
@RequestMapping("/etudiant")

public class EtudiantRestControllers {


    @Autowired
    private  EtudiantService etudiantServices;

    @PostMapping("/addEtudiant")
    Etudiant addEtudiant(@RequestBody Etudiant etudiant){
        return etudiantServices.ajouterEtudiant(etudiant);
    }

    @GetMapping("/getAllEtudiants")
    List<Etudiant> getAllEtudiants(){
        return etudiantServices.afficherListeEtudiant();
    }

    @GetMapping("/getEtudiantByID/{idEt}")
    Etudiant getEtudiantByID(@PathVariable("idEt") long idEtudiant){
        return etudiantServices.afficherEtudiantSelonID(idEtudiant);
    }

    @PutMapping("/updateEtudiant")
    Etudiant updateEtudiant(@RequestBody Etudiant etudiant){
        return etudiantServices.modifierEtudiant(etudiant);
    }

    @DeleteMapping("/deleteEtudiant/{idEt}")
    void deleteEtudiant(@PathVariable("idEt") long idEtudiant){
        etudiantServices.supprimerEtudiant(idEtudiant);
    }
}

