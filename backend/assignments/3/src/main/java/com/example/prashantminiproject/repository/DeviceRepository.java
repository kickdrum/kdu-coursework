    package com.example.prashantminiproject.repository;

    import com.example.prashantminiproject.model.Device;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
    import org.springframework.stereotype.Repository;

    @Repository
    @EnableJpaRepositories
    public interface DeviceRepository extends JpaRepository<Device, String> {

    }
