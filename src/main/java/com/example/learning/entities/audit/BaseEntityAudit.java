package com.example.learning.entities.audit;

import com.datastax.driver.core.utils.UUIDs;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@JsonIgnoreProperties(
        value = {"id", "created_at", "updated_at", "is_moderated", "created_by", "updated_by"}, allowGetters = true)
public abstract class BaseEntityAudit extends BaseEntity implements Persistable<Serializable> {

    @Override
    public UUID getId() {
        return super.getId();
    }

    @Override
    public void setId(UUID id) {
        super.setId(id);
    }

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    protected LocalDateTime created_at;

    //    @CreatedBy
    @Column(nullable = false, updatable = false)
    protected String created_by;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected LocalDateTime updated_at;

    //    @LastModifiedBy
    protected String updated_by;

    @org.springframework.data.annotation.Transient
    @JsonIgnore
    boolean isNew;

    @Override
    @JsonIgnore
    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        if (aNew) {
            isNew = true;
            this.setId(UUIDs.timeBased());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntityAudit)) return false;
        if (!super.equals(o)) return false;
        BaseEntityAudit that = (BaseEntityAudit) o;
        return created_by.equals(that.created_by)
                && updated_by.equals(that.updated_by)
                && created_at.equals(that.created_at)
                && updated_at.equals(that.updated_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), created_by, updated_by, created_at, updated_at);
    }

    @Override
    public String toString() {
        return "BaseEntityAudit{"
                + "created_by='"
                + created_by
                + "'"
                + ", updated_by='"
                + updated_by
                + "'"
                + ", created_at='"
                + created_at
                + "'"
                + ", updated_at='"
                + updated_at
                + "'"
                + "}"
                + super.toString();
    }
}
