package tn.esprit.tpfoyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entities.Chambre;
import tn.esprit.tpfoyer.Repositories.ChambreRepository;

import java.util.List;

@Service
public class ChambreServicesImp implements ChambreService {


    @Autowired
    private  ChambreRepository chambreRepository;
    @Override
    public Chambre ajouterChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> afficherListeChambres() {
        return  chambreRepository.findAll();
    }

    @Override
    public Chambre afficherChambreSelonID(long idChambre) {
        return chambreRepository.findById(idChambre).get();
    }

    @Override
    public Chambre modifierChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void supprimerChambre(long idChambre) {
        chambreRepository.deleteById(idChambre);
    }
}
