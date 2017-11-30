package com.compsys.service;

import com.compsys.model.Right;

import java.util.List;
import java.util.Map;

public interface RightService {

    Right save(Right right);

    List<Right> getList();

    Map<Long, String> getAllAsMap();
}
