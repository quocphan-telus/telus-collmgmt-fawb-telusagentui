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
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Document generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`DOCUMENT`", indexes = {
            @Index(name = "`FK_DOCUMENT_TO_DomainValLmV6F`", columnList = "`type`"),
            @Index(name = "`FK_DOCUMENT_TO_USER_crealc0nH`", columnList = "`createdBy`"),
            @Index(name = "`FK_DOCUMENT_TO_USER_upda2H9vu`", columnList = "`updatedBy`"),
            @Index(name = "`FK_DOCUMENT_TO_DomainVal5lrkI`", columnList = "`documentLabel`"),
            @Index(name = "`FK_DOCUMENT_TO_PARTY_par1bs57`", columnList = "`partyId`"),
            @Index(name = "`FK_DOCUMENT_TO_APPLICATIGwesA`", columnList = "`applicationId`")})
public class Document implements Serializable {


    private Integer id;

    private String code;

    private String name;

    private String status;

    private Integer type;

    private Integer applicationId;

    private Integer partyId;

    private Integer updatedBy;

    private Timestamp updatedOn;

    private Integer createdBy;

    private Timestamp createdOn;

    private Integer documentLabel;

    private String externalId;

    private DomainValue domainValueByType;

    private User userByUpdatedBy;

    private Party party;

    private DomainValue domainValueByDocumentLabel;

    private Application application;

    private User userByCreatedBy;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`code`", nullable = true, length = 50)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "`name`", nullable = true, length = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "`status`", nullable = true, length = 50)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "`type`", nullable = true, scale = 0, precision = 10)
    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "`applicationId`", nullable = true, scale = 0, precision = 10)
    public Integer getApplicationId() {
        return this.applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    @Column(name = "`partyId`", nullable = true, scale = 0, precision = 10)
    public Integer getPartyId() {
        return this.partyId;
    }

    public void setPartyId(Integer partyId) {
        this.partyId = partyId;
    }

    @Column(name = "`updatedBy`", nullable = true, scale = 0, precision = 10)
    public Integer getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Column(name = "`updatedOn`", nullable = true)
    public Timestamp getUpdatedOn() {
        return this.updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Column(name = "`createdBy`", nullable = true, scale = 0, precision = 10)
    public Integer getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "`createdOn`", nullable = true)
    public Timestamp getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    @Column(name = "`documentLabel`", nullable = true, scale = 0, precision = 10)
    public Integer getDocumentLabel() {
        return this.documentLabel;
    }

    public void setDocumentLabel(Integer documentLabel) {
        this.documentLabel = documentLabel;
    }

    @Column(name = "`externalId`", nullable = true, length = 150)
    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`type`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_DOCUMENT_TO_DomainValLmV6F`"))
    @Fetch(FetchMode.JOIN)
    public DomainValue getDomainValueByType() {
        return this.domainValueByType;
    }

    public void setDomainValueByType(DomainValue domainValueByType) {
        if(domainValueByType != null) {
            this.type = domainValueByType.getId();
        }

        this.domainValueByType = domainValueByType;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`updatedBy`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_DOCUMENT_TO_USER_upda2H9vu`"))
    @Fetch(FetchMode.JOIN)
    public User getUserByUpdatedBy() {
        return this.userByUpdatedBy;
    }

    public void setUserByUpdatedBy(User userByUpdatedBy) {
        if(userByUpdatedBy != null) {
            this.updatedBy = userByUpdatedBy.getId();
        }

        this.userByUpdatedBy = userByUpdatedBy;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`partyId`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_DOCUMENT_TO_PARTY_par1bs57`"))
    @Fetch(FetchMode.JOIN)
    public Party getParty() {
        return this.party;
    }

    public void setParty(Party party) {
        if(party != null) {
            this.partyId = party.getId();
        }

        this.party = party;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`documentLabel`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_DOCUMENT_TO_DomainVal5lrkI`"))
    @Fetch(FetchMode.JOIN)
    public DomainValue getDomainValueByDocumentLabel() {
        return this.domainValueByDocumentLabel;
    }

    public void setDomainValueByDocumentLabel(DomainValue domainValueByDocumentLabel) {
        if(domainValueByDocumentLabel != null) {
            this.documentLabel = domainValueByDocumentLabel.getId();
        }

        this.domainValueByDocumentLabel = domainValueByDocumentLabel;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`applicationId`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_DOCUMENT_TO_APPLICATIGwesA`"))
    @Fetch(FetchMode.JOIN)
    public Application getApplication() {
        return this.application;
    }

    public void setApplication(Application application) {
        if(application != null) {
            this.applicationId = application.getId();
        }

        this.application = application;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`createdBy`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_DOCUMENT_TO_USER_crealc0nH`"))
    @Fetch(FetchMode.JOIN)
    public User getUserByCreatedBy() {
        return this.userByCreatedBy;
    }

    public void setUserByCreatedBy(User userByCreatedBy) {
        if(userByCreatedBy != null) {
            this.createdBy = userByCreatedBy.getId();
        }

        this.userByCreatedBy = userByCreatedBy;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document)) return false;
        final Document document = (Document) o;
        return Objects.equals(getId(), document.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}