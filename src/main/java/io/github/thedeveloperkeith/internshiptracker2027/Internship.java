package io.github.thedeveloperkeith.internshiptracker2027;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface Internship extends JpaRepository<internshiptable, Long> {
}

