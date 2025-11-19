package tn.esprit.tpfoyer.Services;

import tn.esprit.tpfoyer.Entities.Foyer;

import java.util.List;

public interface FoyerService {

    Foyer ajouterFoyer(Foyer foyer);
    List<Foyer> afficherListeFoyers();
    Foyer afficherFoyerSelonID(long idFoyer);
    Foyer modifierFoyer(Foyer foyer);
    void supprimerFoyer(long idFoyer);
}
