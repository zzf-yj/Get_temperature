package com.health.repository;

import com.health.domain.Abnormal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbnormalRepository extends JpaRepository<Abnormal,Integer> {

}
