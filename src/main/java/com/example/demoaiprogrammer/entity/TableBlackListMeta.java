package com.example.demoaiprogrammer.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "tbl_blacklist_meta")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TableBlackListMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name="blacklist_code")
    private String blackListCode;
    @Column(name="tbl_name")
    private String tableName;
    @Column(name="status")
    private int status;
    @CreationTimestamp
    @Column(name="created_date", updatable = false)
    private Timestamp createdDate;
    @UpdateTimestamp
    @Column(name="updated_date")
    private Timestamp updatedDate;
}
