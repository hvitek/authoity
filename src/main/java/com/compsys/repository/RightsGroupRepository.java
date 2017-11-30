package com.compsys.repository;

import com.compsys.model.RightsGroup;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface RightsGroupRepository extends Repository<RightsGroup, Long> {

	RightsGroup save(RightsGroup sale);

	List<RightsGroup> findAll();

	Optional<RightsGroup> findOne(Long id);

}
