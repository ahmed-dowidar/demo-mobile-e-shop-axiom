package com.gov.uae.axiom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gov.uae.axiom.domain.Mobiles;

public interface MobileRepository extends JpaRepository<Mobiles, Long> {
	
	 @Query(value = "select mobiles from  Mobiles mobiles "
	    		+ "where (:id =null or mobiles.id = :id) "
	    		+ "and (:brand=null or mobiles.brand LIKE CONCAT('%', :brand, '%'))"
	    		+ "and (:phone=null or mobiles.phone LIKE CONCAT('%', :phone, '%'))"
	    		+ "and (:picture=null or mobiles.picture LIKE CONCAT('%', :picture, '%'))"
	    		+ "and (:sim=null or mobiles.sim LIKE CONCAT('%', :sim, '%'))"
	    		+ "and (:resolution=null or mobiles.resolution LIKE CONCAT('%', :resolution, '%'))"
	    		+ "and (:announceDate=null or mobiles.release.announceDate LIKE CONCAT('%', :announceDate, '%'))"
	    		+ "and (:priceEur=null or mobiles.release.priceEur LIKE CONCAT('%', :priceEur, '%'))"
	    		+ "and (:audioJack=null or mobiles.hardware.audioJack LIKE CONCAT('%', :audioJack, '%'))"
	    		+ "and (:gps=null or mobiles.hardware.gps LIKE CONCAT('%', :gps, '%'))"
	    		+ "and (:battery=null or mobiles.hardware.battery LIKE CONCAT('%', :battery, '%'))")
	public  Iterable<Mobiles> getMobilesBySearchCreiteria(
			@Param("id") Long id,
			@Param("brand") String brand,
			@Param("phone") String phone ,
			@Param("picture") String picture,
			@Param("sim") String sim,
			@Param("resolution") String resolution,
			@Param("announceDate") String announceDate,
			@Param("priceEur") String priceEur,
			@Param("audioJack") String audioJack,
			@Param("gps") String gps,
			@Param("battery") String battery);
	
}
