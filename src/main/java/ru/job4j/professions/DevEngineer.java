package ru.job4j.professions;

public class DevEngineer extends Engineer {

    private String teamName;
    private boolean isLeadDev;

    public DevEngineer(String name, String surname, String education) {
        super(name, surname, education);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public boolean isLeadDev() {
        return isLeadDev;
    }

    public void setLeadDev(boolean leadDev) {
        isLeadDev = leadDev;
    }
}
