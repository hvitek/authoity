package com.compsys.session;

import com.compsys.model.User;

public class SessionParams {
private static User loggedUser;


public static User getLoggedUser() {
	return loggedUser;
}
public void setLoggedUser(User loggedUser) {
	SessionParams.loggedUser = loggedUser;
}

	
}
