package tn.esprit.tpfoyer.Services;

import tn.esprit.tpfoyer.Entities.Reservation;

import java.util.List;

public interface ReservationService {

    Reservation ajouterReservation(Reservation reservation);
    List<Reservation> afficherListeReservations();
    Reservation afficherReservationSelonID(Long idReservation);
    Reservation modifierReservation(Reservation reservation);
    void supprimerReservation(Long idReservation);
}
