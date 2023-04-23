package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.GovernorateCodeEntity;

/**
 * @author YoussefMahmoud
 * @created Apr 23, 2023-1:19:30 PM
 */

@Repository
public interface GovernorateCodeRepository extends JpaRepository<GovernorateCodeEntity, Integer> {

}