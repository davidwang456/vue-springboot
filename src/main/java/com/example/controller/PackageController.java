package com.example.controller;

import com.example.entity.Package;
import com.example.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/packages")
@CrossOrigin
public class PackageController {
    @Autowired
    private PackageService packageService;

    @GetMapping
    public Map<String, Object> findAll(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "20") int pageSize) {
        pageSize = Math.min(pageSize, 20);
        Page<Package> page = packageService.findAll(pageNum, pageSize);
        Map<String, Object> result = new HashMap<>();
        result.put("list", page.getContent());
        result.put("total", page.getTotalElements());
        return result;
    }
} 