package org.ashu.tech_trekker.service.impl;

import org.ashu.tech_trekker.model.WriterInfo;
import org.ashu.tech_trekker.repository.WriterInfoRepository;
import org.ashu.tech_trekker.service.TechTrekkerService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TechTrekkerServiceImpl implements TechTrekkerService {
    private final WriterInfoRepository repository;

    @Override
    public void createWriter(WriterInfo info) {
        repository.save(info);
    }
    
}
