package io.github.thedeveloperkeith.internshiptracker2027;

import jakarta.persistence.*;

@Entity
@Table(name = "internshipwebsites")
public class internshiptable {

    public internshiptable() {}

    @Id
    private Long id;

    private String internships;

    @Column(name = "\"programmingLanguage\"")
    private String programmingLanguage;

    public internshiptable(String internships, String programmingLanguage) {
        this.internships = internships;
        this.programmingLanguage = programmingLanguage;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getInternships() { return internships; }
    public void setInternships(String internships) { this.internships = internships; }

    public String getProgrammingLanguage() { return programmingLanguage; }
    public void setProgrammingLanguage(String programmingLanguage) { this.programmingLanguage = programmingLanguage; }
}
