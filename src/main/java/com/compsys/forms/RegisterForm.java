package com.compsys.forms;

public class RegisterForm {

    private String firstName;

    private String lastName;

    private String nickName;

    private boolean isActive;

    //private RightGroup rightgroup;

    private String rightgroup;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public String getRightgroup() {
        return rightgroup;
    }

    public void setRightgroup(String rightgroup) {
        this.rightgroup = rightgroup;
    }
}
