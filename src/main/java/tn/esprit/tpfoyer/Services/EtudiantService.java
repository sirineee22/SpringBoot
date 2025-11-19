package tn.esprit.tpfoyer.Services;

import tn.esprit.tpfoyer.Entities.Etudiant;

import java.util.List;

public interface EtudiantService {


    Etudiant ajouterEtudiant(Etudiant etudiant);
    List<Etudiant> afficherListeEtudiant();
    Etudiant afficherEtudiantSelonID(long idEtudiant);
    Etudiant modifierEtudiant(Etudiant etudiant);
    void supprimerEtudiant(long idEtudiant);
}
