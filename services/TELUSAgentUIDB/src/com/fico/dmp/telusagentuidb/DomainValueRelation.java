/*Copyright (c) 2020-2021 fico.com All Rights Reserved.
 This software is the confidential and proprietary information of fico.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with fico.com*/
package com.fico.dmp.telusagentuidb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
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
 * DomainValueRelation generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`DomainValueRelation`", indexes = {
            @Index(name = "`FK_DomainValueRelation_ThHkUG`", columnList = "`DomainValueId`"),
            @Index(name = "`FK_DomainValueRelation_TIKNtp`", columnList = "`ParentDomainValueId2`"),
            @Index(name = "`FK_DomainValueRelation_TIUJOq`", columnList = "`ParentDomainValueId1`")})
public class DomainValueRelation implements Serializable {


    private Integer id;

    private Integer domainValueId;

    private Integer parentDomainValueId1;

    private Integer parentDomainValueId2;

    private DomainValue domainValueByParentDomainValueId2;

    private DomainValue domainValueByParentDomainValueId1;

    private DomainValue domainValueByDomainValueId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`DomainValueId`", nullable = true, scale = 0, precision = 10)
    public Integer getDomainValueId() {
        return this.domainValueId;
    }

    public void setDomainValueId(Integer domainValueId) {
        this.domainValueId = domainValueId;
    }

    @Column(name = "`ParentDomainValueId1`", nullable = true, scale = 0, precision = 10)
    public Integer getParentDomainValueId1() {
        return this.parentDomainValueId1;
    }

    public void setParentDomainValueId1(Integer parentDomainValueId1) {
        this.parentDomainValueId1 = parentDomainValueId1;
    }

    @Column(name = "`ParentDomainValueId2`", nullable = true, scale = 0, precision = 10)
    public Integer getParentDomainValueId2() {
        return this.parentDomainValueId2;
    }

    public void setParentDomainValueId2(Integer parentDomainValueId2) {
        this.parentDomainValueId2 = parentDomainValueId2;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`ParentDomainValueId2`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_DomainValueRelation_TIKNtp`"))
    @Fetch(FetchMode.JOIN)
    public DomainValue getDomainValueByParentDomainValueId2() {
        return this.domainValueByParentDomainValueId2;
    }

    public void setDomainValueByParentDomainValueId2(DomainValue domainValueByParentDomainValueId2) {
        if(domainValueByParentDomainValueId2 != null) {
            this.parentDomainValueId2 = domainValueByParentDomainValueId2.getId();
        }

        this.domainValueByParentDomainValueId2 = domainValueByParentDomainValueId2;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`ParentDomainValueId1`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_DomainValueRelation_TIUJOq`"))
    @Fetch(FetchMode.JOIN)
    public DomainValue getDomainValueByParentDomainValueId1() {
        return this.domainValueByParentDomainValueId1;
    }

    public void setDomainValueByParentDomainValueId1(DomainValue domainValueByParentDomainValueId1) {
        if(domainValueByParentDomainValueId1 != null) {
            this.parentDomainValueId1 = domainValueByParentDomainValueId1.getId();
        }

        this.domainValueByParentDomainValueId1 = domainValueByParentDomainValueId1;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`DomainValueId`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_DomainValueRelation_ThHkUG`"))
    @Fetch(FetchMode.JOIN)
    public DomainValue getDomainValueByDomainValueId() {
        return this.domainValueByDomainValueId;
    }

    public void setDomainValueByDomainValueId(DomainValue domainValueByDomainValueId) {
        if(domainValueByDomainValueId != null) {
            this.domainValueId = domainValueByDomainValueId.getId();
        }

        this.domainValueByDomainValueId = domainValueByDomainValueId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DomainValueRelation)) return false;
        final DomainValueRelation domainValueRelation = (DomainValueRelation) o;
        return Objects.equals(getId(), domainValueRelation.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}