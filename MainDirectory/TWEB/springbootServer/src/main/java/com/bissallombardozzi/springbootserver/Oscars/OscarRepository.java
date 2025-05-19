package com.bissallombardozzi.springbootserver.Oscars;

import com.bissallombardozzi.springbootserver.Dto.OscarEditionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface OscarRepository extends JpaRepository<Oscar, Long> {

    @Query("SELECT o FROM Oscar o WHERE o.yearCeremony = :year")
    List<Oscar> findByYearCeremony(int year);

    @Query("SELECT o FROM Oscar o WHERE o.ceremonyEdition = :edition")
    List<Oscar> findByCeremony(int edition);


}
