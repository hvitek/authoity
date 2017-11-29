package com.compsys.service;

import com.compsys.model.Rightsgroup;

import java.util.List;

public interface RightsGroupService {

	Rightsgroup save(Rightsgroup rightsgroup);

    List<Rightsgroup> getList();

}
