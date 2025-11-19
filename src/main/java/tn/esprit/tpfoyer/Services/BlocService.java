package tn.esprit.tpfoyer.Services;

import tn.esprit.tpfoyer.Entities.Bloc;

import java.util.List;

public interface BlocService {

    Bloc ajouterBloc(Bloc bloc);
    List<Bloc> afficherListeBlocs();
    Bloc afficherBlocSelonID(long idBloc);
    Bloc modifierBloc(Bloc bloc);
    void supprimerBloc(long idBloc);
}
