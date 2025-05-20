package com.example.service;

import com.example.entity.Package;
import com.example.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PackageService {
    @Autowired
    private PackageRepository packageRepository;

    public Page<Package> findAll(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return packageRepository.findAll(pageable);
    }
} 