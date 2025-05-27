package com.bissallombardozzi.springbootserver.Oscars;

import com.bissallombardozzi.springbootserver.Dto.OscarEditionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface OscarRepository extends JpaRepository<Oscar, Long> {

    @Query("SELECT o FROM Oscar o WHERE LOWER(o.castMemberName) = LOWER(:name)" +
            " and o.winner =TRUE ")
    List<Oscar> findOscarsByName(@Param("name") String name);

    @Query("SELECT o FROM Oscar o WHERE o.yearCeremony = :year")
    List<Oscar> findByYearCeremony(int year);

    @Query("SELECT o FROM Oscar o WHERE o.ceremonyEdition = :edition")
    List<Oscar> findByCeremony(int edition);

    @Query(value = "SELECT DISTINCT ON (ceremony) * FROM oscars_awards WHERE ceremony<93 ORDER BY ceremony DESC, year_ceremony DESC LIMIT 5", nativeQuery = true)
    List<Oscar> findTop5CeremonyDistinctOrderByYearCeremonyDesc();



}
