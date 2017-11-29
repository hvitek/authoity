package com.compsys.service;


import com.compsys.model.Rightsgroup;
import com.compsys.repository.RightsGroupRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RightsGroupServiceImpl implements RightsGroupService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RightsGroupServiceImpl.class);

    private final RightsGroupRepository repository;

    @Autowired
    public RightsGroupServiceImpl(RightsGroupRepository repository) {
        this.repository = repository;
    }


    @Override
    public Rightsgroup save(Rightsgroup right) {
    	Rightsgroup created = repository.save(right);
        return created;
    }

    @Override
    public List<Rightsgroup> getList() {
        return repository.findAll();
    }
}
