package com.compsys.forms;

public class AttendanceActionForm {

	private Boolean isincoming;
	private Boolean isoutcoming;
    private String name;

    public Boolean getIsincoming() {
		return isincoming;
	}

	public void setIsincoming(Boolean isincoming) {
		this.isincoming = isincoming;
	}

	public Boolean getIsoutcoming() {
		return isoutcoming;
	}

	public void setIsoutcoming(Boolean isoutcoming) {
		this.isoutcoming = isoutcoming;
	}

	
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
