package tn.esprit.tpfoyer.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entities.Reservation;
import tn.esprit.tpfoyer.Services.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservation")

public class ReservationRestControllers {

    @Autowired
    private  ReservationService reservationServices;

    @PostMapping("/addReservation")
    Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationServices.ajouterReservation(reservation);
    }

    @GetMapping("/getAllReservations")
    List<Reservation> getAllReservations(){
        return reservationServices.afficherListeReservations();
    }

    @GetMapping("/getReservationByID/{idR}")
    Reservation getReservationByID(@PathVariable("idR") Long idReservation) {
        return reservationServices.afficherReservationSelonID(idReservation);
    }

    @PutMapping("/updateReservation")
    Reservation updateReservation(@RequestBody Reservation reservation){
        return reservationServices.modifierReservation(reservation);
    }

    @DeleteMapping("/deleteReservation/{idR}")
    void deleteReservation(@PathVariable("idR") Long idReservation) {
        reservationServices.supprimerReservation(idReservation);
    }
}
