package com.example.GeorgeItexico.rest.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.example.GeorgeItexico.dao.IReservationRepository;
import com.example.GeorgeItexico.entity.Reservation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Reservations")
public class ReservationsController {

  @Autowired
  IReservationRepository reservationsRepository;

  /**
   * REST API that returns a list of all the reservations.
   * @return List<Reservations>
   */
  @Operation(
      summary = "Get a list of all reservations"
  )
  @ApiResponses(
      @ApiResponse(
          responseCode = "200",
          description = "Successful Response",
          content = @Content(array = @ArraySchema(schema = @Schema(implementation =
              Reservation.class)))
      )
  )
  @GetMapping(
      path = "/reservations",
      produces = APPLICATION_JSON_VALUE
  )
  public ResponseEntity<List<Reservation>> getReservation() {
    List<Reservation> listofReservations = (List<Reservation>) reservationsRepository.findAll();
    return new ResponseEntity(listofReservations, HttpStatus.OK);
  }

  /**
   * REST API that save a new reservation.
   * @param reservation
   * @return String
   */
  @Operation(
      summary = "Save a new reservation"
  )
  @ApiResponses(
      @ApiResponse(
          responseCode = "200",
          description = "Successful Response",
          content = @Content(schema = @Schema(implementation = Reservation.class))
      )
  )
  @PostMapping(
      path = "/new-reservation",
      consumes = APPLICATION_JSON_VALUE
  )
  public ResponseEntity<String> newReservation(
      @RequestBody Reservation reservation) {
    reservationsRepository.save(reservation);
    return new ResponseEntity<>("Info saved correctly", HttpStatus.OK);
  }

}
