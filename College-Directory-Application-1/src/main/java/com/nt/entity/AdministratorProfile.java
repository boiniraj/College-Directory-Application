package com.nt.entity;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "AdministratorProfile")
@Data
public class AdministratorProfile {
	     @Id
	    @Column(name = "user_id",insertable=false, updatable=false)
	    private Long userId;

	    @Column(length = 255)
	    private String photo;
	    
	    @NotNull
	    @Column(name = "department_id",insertable=false, updatable=false)
	    private Long departmentId;
	    
	    // Many-to-One relationship with Department
	    @ManyToOne
	    @JoinColumn(name = "department_id", nullable = false, referencedColumnName = "id")
	    private Department department;

	    // One-to-One relationship with User
	    @OneToOne
	    @MapsId
	    @JoinColumn(name = "user_id",referencedColumnName = "id")
	    private User user;

}
