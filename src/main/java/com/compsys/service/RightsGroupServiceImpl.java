package com.compsys.service;


import com.compsys.model.RightsGroup;
import com.compsys.repository.RightsGroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RightsGroupServiceImpl implements RightsGroupService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RightsGroupServiceImpl.class);

    private final RightsGroupRepository repository;

    @Autowired
    public RightsGroupServiceImpl(RightsGroupRepository repository) {
        this.repository = repository;
    }


    @Override
    public RightsGroup save(RightsGroup right) {
        RightsGroup created = repository.save(right);
        return created;
    }

    @Override
    public List<RightsGroup> getList() {
        return repository.findAll();
    }

    @Override
    public Optional<RightsGroup> getById(long id) {
        return repository.findOne(id);
    }


    @Override
    public Map<Long, String> getAllAsMap() {
        return repository.findAll().stream().collect(
                Collectors.toMap(RightsGroup::getId, RightsGroup::getName));
    }
}
