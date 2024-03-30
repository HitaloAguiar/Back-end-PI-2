package br.unitins.system.model;

import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PreUpdate;

@MappedSuperclass
public abstract class DefaultEntity {

    private LocalDateTime dataInsert;

    private LocalDateTime dataUpdate;

    @PostPersist
    private void gerarDataInsert() {

        dataInsert = LocalDateTime.now();
    }

    @PreUpdate
    private void gerarDataUpdate() {

        dataUpdate = LocalDateTime.now();
    }

    public LocalDateTime getDataInsert() {
        return dataInsert;
    }

    public LocalDateTime getDataUpdate() {
        return dataUpdate;
    }
}
