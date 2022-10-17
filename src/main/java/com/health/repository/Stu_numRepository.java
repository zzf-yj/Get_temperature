package com.health.repository;

import com.health.domain.Abnormal;
import com.health.domain.Stu_number;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Stu_numRepository extends JpaRepository<Stu_number,Integer> {
}
