package com.compsys.service;

import com.compsys.model.Right;

import java.util.List;

public interface RightService {

    Right save(Right right);

    List<Right> getList();

}
