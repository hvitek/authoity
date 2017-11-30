package com.compsys.repository;

import com.compsys.model.Right;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface RightRepository extends Repository<Right, Long> {

	Right save(Right sale);

	List<Right> findAll();

}
