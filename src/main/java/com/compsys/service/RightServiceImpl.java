package com.compsys.service;


import com.compsys.model.Right;
import com.compsys.repository.RightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RightServiceImpl implements RightService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RightServiceImpl.class);

    private final RightRepository repository;

    @Autowired
    public RightServiceImpl(RightRepository repository) {
        this.repository = repository;
    }


    @Override
    public Right save(Right right) {
        Right created = repository.save(right);
        return created;
    }

    @Override
    public List<Right> getList() {
        return repository.findAll();
    }
}
