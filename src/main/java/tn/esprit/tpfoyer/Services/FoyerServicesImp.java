package tn.esprit.tpfoyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entities.Foyer;
import tn.esprit.tpfoyer.Repositories.FoyerRepository;

import java.util.List;

@Service
public class FoyerServicesImp implements FoyerService {

    @Autowired
    private  FoyerRepository foyerRepository;
    @Override
    public Foyer ajouterFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public List<Foyer> afficherListeFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer afficherFoyerSelonID(long idFoyer) {
        return foyerRepository.findById(idFoyer).get();
    }

    @Override
    public Foyer modifierFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void supprimerFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }
}
