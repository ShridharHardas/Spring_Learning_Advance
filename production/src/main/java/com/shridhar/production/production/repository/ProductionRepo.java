package com.shridhar.production.production.repository;

import com.shridhar.production.production.entity.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionRepo extends JpaRepository<Production,Long> {
}
