package tn.esprit.tpfoyer.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entities.Universite;
import tn.esprit.tpfoyer.Services.UniversiteService;

import java.util.List;

@RestController
@RequestMapping("/universite")
public class UniversiteRestControllers {

    @Autowired
    private  UniversiteService universiteServices;

    @PostMapping("/addUniveriste")
    Universite addUniveriste(@RequestBody Universite universite) {
        return universiteServices.ajouterUniversite(universite);
    }

    @GetMapping("/getAllUniversites")
    List<Universite> getAllUniversites(){
        return universiteServices.afficherListeUniversite();
    }

    @GetMapping("/getUniversiteByID/{idU}")
    Universite getUniversiteByID(@PathVariable("idU") long idUniversite) {
        return universiteServices.afficherUniversiteSelonID(idUniversite);
    }

    @PutMapping("/updateReservation")
    Universite updateUniversite(@RequestBody Universite universite){
        return universiteServices.modifierUniversite(universite);
    }

    @DeleteMapping("/deleteUniversite/{idU}")
    void deleteUniversite(@PathVariable("idU") long idUniversite) {
        universiteServices.supprimerUniversite(idUniversite);
    }

    @PutMapping("/affecterFoyer/{idFoyer}/{nomUniversite}")
    Universite affecterFoyerAUniversite(@PathVariable long idFoyer,
                                        @PathVariable String nomUniversite) {
        return universiteServices.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }
}
