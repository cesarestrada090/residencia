package com.residencial.app.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenantId;
    
    @ManyToOne
    @JoinColumn(name = "document_type", nullable = false)
    private DocumentType documentType;

    @Column(name = "document", nullable = false, unique = true)
    private String document;

    @ManyToOne
    @JoinColumn(name = "user_type", nullable = false)
    private UserType userType;

    @Column(name = "status", nullable = false)
    private Byte status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}