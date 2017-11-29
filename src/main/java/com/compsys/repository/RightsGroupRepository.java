package com.compsys.repository;

import com.compsys.model.Rightsgroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RightsGroupRepository extends JpaRepository<Rightsgroup, Long> {

	Rightsgroup save(Rightsgroup sale);

}
