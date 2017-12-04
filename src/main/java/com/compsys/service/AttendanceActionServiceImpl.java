package com.compsys.service;


import com.compsys.model.AttendanceAction;
import com.compsys.repository.AttendanceActionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AttendanceActionServiceImpl implements AttendanceActionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AttendanceActionServiceImpl.class);

    private final AttendanceActionRepository repository;

    @Autowired
    public AttendanceActionServiceImpl(AttendanceActionRepository repository) {
        this.repository = repository;
    }

    @Override
    public AttendanceAction save(AttendanceAction attendanceAction) {
    	AttendanceAction created = repository.save(attendanceAction);
        return created;
    }

    @Override
    public List<AttendanceAction> getList() {
        return repository.findAll();
    }

    @Override
    public Map<Long, String> getAllAsMap() {
        return repository.findAll().stream().collect(
                Collectors.toMap(AttendanceAction::getId, AttendanceAction::getName));
    }
}
