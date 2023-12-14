package com.Petrucci.Agenda.impegni;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpegniRepository extends JpaRepository<Impegni, UUID> {

}
