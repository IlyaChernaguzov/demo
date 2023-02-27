package com.example.demo.model.entity;

import com.example.demo.model.enums.OrderStatus;
import com.example.demo.model.enums.SessionStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "sessions")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @CreationTimestamp
    @JsonIgnore
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    LocalDateTime createdAt;

    @Column(name = "updated_at")
    @JsonIgnore
    LocalDateTime updatedAt;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus = OrderStatus.CREATE;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    User user;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    List<Place> place;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    Session session;
}