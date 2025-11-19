package tn.esprit.tpfoyer.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entities.Foyer;
import tn.esprit.tpfoyer.Services.FoyerService;

import java.util.List;

@RestController
@RequestMapping("/foyer")

public class FoyerRestControllers {


    @Autowired
    private  FoyerService foyerServices;

    @PostMapping("/addFoyer")
    Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerServices.ajouterFoyer(foyer);
    }

    @GetMapping("/getAllFoyers")
    List<Foyer> getAllFoyers(){
        return foyerServices.afficherListeFoyers();
    }

    @GetMapping("/getFoyerByID/{idF}")
    Foyer getFoyerByID(@PathVariable("idF") long idFoyer){
        return foyerServices.afficherFoyerSelonID(idFoyer);
    }

    @PutMapping("/updateFoyer")
    Foyer updateFoyer(@RequestBody Foyer foyer) {
        return foyerServices.modifierFoyer(foyer);
    }

    @DeleteMapping("/deleteFoyer/{idF}")
    void deleteFoyer(@PathVariable("idF") long idFoyer){
        foyerServices.supprimerFoyer(idFoyer);
    }
}
