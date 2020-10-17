package com.gov.uae.axiom.service;

import java.util.List;

import com.gov.uae.axiom.domain.Mobiles;

public interface MobileService {

	public Iterable<Mobiles> list();

	public Mobiles save(Mobiles user);

	public void save(List<Mobiles> users);

	public Iterable<Mobiles> searchByoneOrMoreCreiteria(Long id, String brand, String phone, String picture, String sim,
			String resolution, String announceDate, String priceEur, String audioJack, String gps, String battery);
	
	public <T> List<T> getListFromIterator(Iterable<T> iterator); 
  
}
