package com.microservices.user.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "TB_USER")
public class UserModel implements Serializable {
    
}
