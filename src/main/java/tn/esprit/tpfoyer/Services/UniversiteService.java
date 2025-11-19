package tn.esprit.tpfoyer.Services;

import tn.esprit.tpfoyer.Entities.Universite;

import java.util.List;

public interface UniversiteService {


    Universite ajouterUniversite(Universite universite);
    List<Universite> afficherListeUniversite();
    Universite afficherUniversiteSelonID(long idUniversite);
    Universite modifierUniversite(Universite universite);
    void supprimerUniversite(long idUniversite);
    Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);
}
