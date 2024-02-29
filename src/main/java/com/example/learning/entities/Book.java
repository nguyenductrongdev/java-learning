package com.example.learning.entities;

import com.datastax.driver.mapping.annotations.Column;
import com.example.learning.entities.audit.BaseEntityAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
@com.datastax.driver.mapping.annotations.Table(name = "book")
@org.springframework.data.cassandra.core.mapping.Table("book")
@EntityListeners(AuditingEntityListener.class)
@Entity
// @SQLRestriction("name <> 'bar'")
public class Book extends BaseEntityAudit {
    @NotNull
    @Column(name = "object_id")
    private UUID object_id;

    @Column(name = "name")
    private String name;

    @Column(name = "pages")
    private Integer pages;
}
