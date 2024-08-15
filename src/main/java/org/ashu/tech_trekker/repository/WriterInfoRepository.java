package org.ashu.tech_trekker.repository;

import org.ashu.tech_trekker.model.WriterInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WriterInfoRepository extends 
JpaRepository<WriterInfo,Integer> {
    
}
