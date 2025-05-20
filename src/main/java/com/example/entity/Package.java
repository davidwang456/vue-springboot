package com.example.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "packages")
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String initiator;
    private String type;
    private String domain;
    private String pkgName;
    private String pkgVersion;
    private String repositoryName;
    private LocalDateTime createTime;
} 