/*Copyright (c) 2020-2021 fico.com All Rights Reserved.
 This software is the confidential and proprietary information of fico.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with fico.com*/
package com.fico.dmp.telusagentuidb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * EntityDocuments generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`ENTITY_DOCUMENTS`")
public class EntityDocuments implements Serializable {


    private Integer id;

    @JsonProperty(access = Access.READ_ONLY)
    private byte[] document;

    private Timestamp createdOn;

    private Integer createdBy;

    private String documentName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Lob()
    @Column(name = "`document`", nullable = true)
    public byte[] getDocument() {
        return this.document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }

    @Column(name = "`createdOn`", nullable = true)
    public Timestamp getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    @Column(name = "`createdBy`", nullable = true, scale = 0, precision = 10)
    public Integer getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "`documentName`", nullable = true, length = 50)
    public String getDocumentName() {
        return this.documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntityDocuments)) return false;
        final EntityDocuments entityDocuments = (EntityDocuments) o;
        return Objects.equals(getId(), entityDocuments.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}