package DesignPatterns.AdapterPattern;

public class CollegeStudent implements Student {

    private String name;
    private String standard;
    private String section;
    Integer year;

    public CollegeStudent(String name, String standard, String section, Integer year) {
        this.name = name;
        this.standard = standard;
        this.section = section;
        this.year = year;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getStandard() {
        return this.standard;
    }

    @Override
    public String getSection() {
        return this.section;
    }

    public Integer getYear() {
        return this.year;
    }
}
