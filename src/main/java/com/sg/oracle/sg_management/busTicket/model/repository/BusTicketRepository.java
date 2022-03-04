package com.sg.oracle.sg_management.busTicket.model.repository;


import com.sg.oracle.sg_management.busTicket.model.entity.BusTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusTicketRepository extends JpaRepository<BusTicket,Integer> {
}
