package tn.esprit.tpfoyer.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entities.Chambre;
import tn.esprit.tpfoyer.Services.ChambreService;

import java.util.List;

@RestController
@RequestMapping("/chambre")


public class ChambreRestControllers {

    @Autowired
    private  ChambreService chambreServices;

    @PostMapping("/addChambre")
    Chambre addChambre(@RequestBody Chambre chambre){
        return chambreServices.ajouterChambre(chambre);
    }

    @GetMapping("/getAllBlocs")
    List<Chambre> getAllBlocs(){
        return chambreServices.afficherListeChambres();
    }

    @GetMapping("/getChambreByID/{idCh}")
    Chambre getChambreByID(@PathVariable("idCh") long idChambre){
        return chambreServices.afficherChambreSelonID(idChambre);
    }

    @PutMapping("/updateChambre")
    Chambre updateChmabre(@RequestBody Chambre chambre){
        return chambreServices.modifierChambre(chambre);
    }

    @DeleteMapping("/deleteChambre/{idCh}")
    void deleteChambre(@PathVariable("idCh") long idChambre){
        chambreServices.supprimerChambre(idChambre);
    }
}
