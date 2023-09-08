package DesignPatterns.AdapterPattern;

import java.util.List;

public class LegacySchoolStudent {
    private List<String> name;
    private String standard;
    private String section;
    private String email;

    public LegacySchoolStudent(List<String> name, String standard, String section, String email) {
        this.name = name;
        this.standard = standard;
        this.section = section;
        this.email = email;
    }

    public List<String> getName() {
        return name;
    }

    public String getStandard() {
        return standard;
    }

    public String getSection() {
        return section;
    }

    public String getEmail() {
        return email;
    }
}
