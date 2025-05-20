package com.example.config;

import com.example.entity.Package;
import com.example.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private PackageRepository packageRepository;

    private final Random random = new Random();
    private final String[] initiators = {"张三", "李四", "王五", "赵六", "钱七"};
    private final String[] types = {"npm", "maven", "pip", "gem", "nuget"};
    private final String[] domains = {"github.com", "gitlab.com", "bitbucket.org", "gitee.com", "coding.net"};
    private final String[] pkgNames = {"react", "vue", "angular", "spring", "django", "flask", "express", "koa"};
    private final String[] versions = {"1.0.0", "2.0.0", "3.0.0", "4.0.0", "5.0.0", "6.0.0", "7.0.0", "8.0.0"};
    private final String[] repositories = {"frontend", "backend", "mobile", "desktop", "cloud", "ai", "iot"};

    @Override
    public void run(String... args) {
        // 检查是否已有数据
        if (packageRepository.count() > 0) {
            return;
        }

        // 生成10000条测试数据
        for (int i = 0; i < 10000; i++) {
            Package pkg = new Package();
            pkg.setInitiator(initiators[random.nextInt(initiators.length)]);
            pkg.setType(types[random.nextInt(types.length)]);
            pkg.setDomain(domains[random.nextInt(domains.length)]);
            pkg.setPkgName(pkgNames[random.nextInt(pkgNames.length)]);
            pkg.setPkgVersion(versions[random.nextInt(versions.length)]);
            pkg.setRepositoryName(repositories[random.nextInt(repositories.length)]);
            pkg.setCreateTime(LocalDateTime.now().minusDays(random.nextInt(365)));

            packageRepository.save(pkg);
        }
    }
} 