package com.compsys.service;

import com.compsys.model.RightsGroup;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface RightsGroupService {

    RightsGroup save(RightsGroup rightsGroup);

    List<RightsGroup> getList();

    Optional<RightsGroup> getById(long id);

    Map<Long, String> getAllAsMap();

}
