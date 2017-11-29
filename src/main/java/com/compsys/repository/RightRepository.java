package com.compsys.repository;

import com.compsys.model.Right;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RightRepository extends JpaRepository<Right, Long> {

	Right save(Right sale);

}
