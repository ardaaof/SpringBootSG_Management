package com.sg.oracle.sg_management.busTicket.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@SequenceGenerator(name="TICKET_ID_SEQ",sequenceName = "TICKET_ID_SEQ",initialValue = 1,allocationSize = 1)
@Table(name="BUS_TICKETS")
@Entity
public class BusTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "TICKET_ID_SEQ")
    @Column(name= "TICKET_ID")
    private int ticketID;

    private String company;

    @Column(name = "FROM_PLACE")
    private String fromPlace;

    @Column(name="TO_PLACE")
    private String toPlace;

    @Temporal(TemporalType.DATE)
    @Column(name = "DEPARTURE_TIME")
    private Date departureTime;
}
