package com.sg.oracle.sg_management.busTicket.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.sg.oracle.sg_management.busTicket.model.entity.BusTicket;
import com.sg.oracle.sg_management.busTicket.model.repository.BusTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;

/*
 *  View Scope xhtml sayfamizda Ajax kullanildiginda kullanisli olmaktadir. -> Primefaces
 * 
 * Eger bean’in sadece sayfa boyunca yasamasini istersek bu durumda ViewScoped kullanabiliriz.
 * 
 *  @Inject instead of Spring’s @Autowired to inject a bean.
	@Named instead of Spring’s @Component to declare a bean.
 * 
 *  https://stackoverflow.com/questions/5415261/what-is-javax-inject-named-annotation-supposed-to-be-used-for
 */

@Setter
@Getter
@ViewScoped
@Named("busTicketController")
public class BusTicketManagedBean implements Serializable
{
	private BusTicket busTicket = new BusTicket();
	private List<BusTicket> busTicketList = new ArrayList<BusTicket>();
	
	@Autowired
	private BusTicketRepository busTicketRepository;
	
	public void edit(BusTicket busTicket)
	{
		this.busTicket = busTicket;
	}
	
	public void fetchAll()
	{
		busTicketList = busTicketRepository.findAll();
	}
	
	public void save()
	{
		busTicketRepository.save(busTicket); // yapilandirilan bilet kaydedildi
		
		busTicket = new BusTicket(); // onceki bilet bilgileri yeni olusuturulani etkilemesin
		
		busTicketList = busTicketRepository.findAll(); // veri eklendeikten sonra, veri tablosunda gosterilmek uzere veriler cekildi.
	}
	
	public void refresh()
	{
		busTicket = new BusTicket();
	}

}
