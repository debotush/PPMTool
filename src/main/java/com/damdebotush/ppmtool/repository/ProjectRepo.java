package com.damdebotush.ppmtool.repository;

import com.damdebotush.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Long> {

    @Override
    Optional<Project> findById(Long aLong);

    Project findByProjectIdentifier(String projectIdentifier);

    Iterable<Project> findAll();
}
