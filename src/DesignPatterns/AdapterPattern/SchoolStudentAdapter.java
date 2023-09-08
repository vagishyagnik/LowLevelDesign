package DesignPatterns.AdapterPattern;

public class SchoolStudentAdapter implements Student {

    String name;
    String standard;
    String section;

    public SchoolStudentAdapter(LegacySchoolStudent schoolStudent) {
        StringBuilder sb = new StringBuilder();
        schoolStudent.getName().forEach(t -> {
            sb.append(t).append(" ");
        });
        if (!sb.isEmpty()) sb.deleteCharAt(sb.length()-1);
        this.name = sb.toString();
        this.standard = schoolStudent.getStandard();
        this.section = schoolStudent.getSection();
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
}
