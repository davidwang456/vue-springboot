package com.example.repository;

import com.example.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PackageRepository extends JpaRepository<Package, Long> {
    Page<Package> findAll(Pageable pageable);
} 