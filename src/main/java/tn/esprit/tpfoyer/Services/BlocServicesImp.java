package tn.esprit.tpfoyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entities.Bloc;
import tn.esprit.tpfoyer.Repositories.BlocRepository;

import java.util.List;

@Service
public class BlocServicesImp implements BlocService{

    @Autowired
    private  BlocRepository blocRepository;
    @Override
    public Bloc ajouterBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public List<Bloc> afficherListeBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc afficherBlocSelonID(long idBloc) {
        return blocRepository.getReferenceById(idBloc);
    }

    @Override
    public Bloc modifierBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void supprimerBloc(long idBloc) {
        blocRepository.deleteById(idBloc);
    }


}
