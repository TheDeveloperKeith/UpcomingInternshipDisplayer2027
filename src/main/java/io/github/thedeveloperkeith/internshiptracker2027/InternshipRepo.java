package io.github.thedeveloperkeith.internshiptracker2027;


import org.springframework.data.jpa.repository.JpaRepository;

public interface InternshipRepo extends JpaRepository<InternshipEntity, Long> {
}

