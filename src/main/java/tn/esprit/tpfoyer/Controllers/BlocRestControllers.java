package tn.esprit.tpfoyer.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entities.Bloc;
import tn.esprit.tpfoyer.Services.BlocService;

import java.util.List;

@RestController
@RequestMapping("/bloc")
public class BlocRestControllers {


    @Autowired
    private  BlocService blocServices;

    @PostMapping("/addBloc")
    Bloc addBloc(@RequestBody Bloc bloc) {
        return blocServices.ajouterBloc(bloc);
    }

    @GetMapping("/getAllBlocs")
    List<Bloc> getAllBlocs(){
        return blocServices.afficherListeBlocs();
    }

    @GetMapping("/getBlocByID/{idB}")
    Bloc getBlocByID(@PathVariable("idB") long idBloc){
        return blocServices.afficherBlocSelonID(idBloc);
    }

    @PutMapping("/updateBloc")
    Bloc updateBloc(@RequestBody Bloc bloc){
        return blocServices.modifierBloc(bloc);
    }

    @DeleteMapping("/deleteBloc/{idB}")
    void deleteBloc(@PathVariable("idB") long idBloc){
        blocServices.supprimerBloc(idBloc);
    }
}
