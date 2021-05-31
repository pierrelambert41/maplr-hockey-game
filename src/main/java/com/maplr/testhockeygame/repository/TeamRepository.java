package com.maplr.testhockeygame.repository;

import com.maplr.testhockeygame.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    Team findByYear(Long year);
}
