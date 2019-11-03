package com.devroom.location.repose;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devroom.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

	//hibernate query language JPQL
	@Query(value="select type,count(type) from location group by type",nativeQuery=true)
	public List<Object[]> findTypeAndTypeCount();
	
}
