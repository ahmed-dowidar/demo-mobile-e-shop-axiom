package com.gov.uae.axiom.serviceImpl;

import com.gov.uae.axiom.domain.Mobiles;
import com.gov.uae.axiom.repository.MobileRepository;
import com.gov.uae.axiom.service.MobileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MobileServiceImpl implements MobileService {

	@Autowired
	private MobileRepository mobileRepository;

	@Override
	public Iterable<Mobiles> list() {
		return mobileRepository.findAll();
	}

	@Override
	public Mobiles save(Mobiles mobile) {
		return mobileRepository.save(mobile);
	}

	@Override
	public void save(List<Mobiles> mobiles) {
		mobileRepository.saveAll(mobiles);
	}

	@Override
	public Iterable<Mobiles> searchByoneOrMoreCreiteria(Long id, String brand, String phone, String picture, String sim,
			String resolution, String announceDate, String priceEur, String audioJack, String gps, String battery) {
		
		return mobileRepository.getMobilesBySearchCreiteria(id, brand, phone, picture, sim, resolution, announceDate,
				priceEur, audioJack, gps, battery);
	}

	@Override
	public <T> List<T> getListFromIterator(Iterable<T> iterable) {
		return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
	}

}
