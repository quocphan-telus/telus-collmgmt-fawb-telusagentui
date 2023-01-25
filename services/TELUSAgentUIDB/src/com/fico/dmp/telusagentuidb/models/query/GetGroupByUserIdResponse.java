/*Copyright (c) 2020-2021 fico.com All Rights Reserved.
 This software is the confidential and proprietary information of fico.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with fico.com*/
package com.fico.dmp.telusagentuidb.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetGroupByUserIdResponse implements Serializable {


    @ColumnAlias("Id")
    private Long id;

    @ColumnAlias("Name")
    private String name;

    @ColumnAlias("active")
    private Boolean active;

    @ColumnAlias("description")
    private String description;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetGroupByUserIdResponse)) return false;
        final GetGroupByUserIdResponse getGroupByUserIdResponse = (GetGroupByUserIdResponse) o;
        return Objects.equals(getId(), getGroupByUserIdResponse.getId()) &&
                Objects.equals(getName(), getGroupByUserIdResponse.getName()) &&
                Objects.equals(getActive(), getGroupByUserIdResponse.getActive()) &&
                Objects.equals(getDescription(), getGroupByUserIdResponse.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getName(),
                getActive(),
                getDescription());
    }
}