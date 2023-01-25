/*Copyright (c) 2020-2021 fico.com All Rights Reserved.
 This software is the confidential and proprietary information of fico.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with fico.com*/
package com.fico.dmp.telusagentuidb.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QueueLockRequest implements Serializable {


    @JsonProperty("lockedBy")
    @NotNull
    private String lockedBy;

    @JsonProperty("updatedBy")
    @NotNull
    private String updatedBy;

    @JsonProperty("updatedOn")
    @NotNull
    private Timestamp updatedOn;

    @JsonProperty("id")
    @NotNull
    private Integer id;

    public String getLockedBy() {
        return this.lockedBy;
    }

    public void setLockedBy(String lockedBy) {
        this.lockedBy = lockedBy;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getUpdatedOn() {
        return this.updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QueueLockRequest)) return false;
        final QueueLockRequest queueLockRequest = (QueueLockRequest) o;
        return Objects.equals(getLockedBy(), queueLockRequest.getLockedBy()) &&
                Objects.equals(getUpdatedBy(), queueLockRequest.getUpdatedBy()) &&
                Objects.equals(getUpdatedOn(), queueLockRequest.getUpdatedOn()) &&
                Objects.equals(getId(), queueLockRequest.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLockedBy(),
                getUpdatedBy(),
                getUpdatedOn(),
                getId());
    }
}