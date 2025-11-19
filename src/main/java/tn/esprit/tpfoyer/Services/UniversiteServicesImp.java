package tn.esprit.tpfoyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entities.Foyer;
import tn.esprit.tpfoyer.Entities.Universite;
import tn.esprit.tpfoyer.Repositories.FoyerRepository;
import tn.esprit.tpfoyer.Repositories.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServicesImp implements UniversiteService{

    private final UniversiteRepository universiteRepository;
    private final FoyerRepository foyerRepository;


    @Override
    public Universite ajouterUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public List<Universite> afficherListeUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite afficherUniversiteSelonID(long idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }

    @Override
    public Universite modifierUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public void supprimerUniversite(long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite)
                .orElseThrow(() -> new RuntimeException("Universite non trouvée"));
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer non trouvé"));
        universite.setFoyer(foyer);
       //foyer.setUniversite(universite);
        return universiteRepository.save(universite);
    }
}