package com.kafka.demo.repository;

import com.kafka.demo.entity.CityLog;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * CityLog Table Repository
 */
public interface CityLogRepository extends JpaRepository<CityLog, Long> {

}
