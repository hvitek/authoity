package com.compsys.service;

import com.compsys.model.AttendanceAction;

import java.util.List;
import java.util.Map;

public interface AttendanceActionService {

	AttendanceAction save(AttendanceAction attendanceAction);

    List<AttendanceAction> getList();

    Map<Long, String> getAllAsMap();
}
