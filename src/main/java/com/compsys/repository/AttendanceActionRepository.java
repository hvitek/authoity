package com.compsys.repository;

import com.compsys.model.AttendanceAction;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface AttendanceActionRepository extends Repository<AttendanceAction, Long> {

	AttendanceAction save(AttendanceAction sale);

	List<AttendanceAction> findAll();

}
