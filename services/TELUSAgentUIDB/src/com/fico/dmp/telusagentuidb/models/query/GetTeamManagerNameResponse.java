/*Copyright (c) 2020-2021 fico.com All Rights Reserved.
 This software is the confidential and proprietary information of fico.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with fico.com*/
package com.fico.dmp.telusagentuidb.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetTeamManagerNameResponse implements Serializable {


    @ColumnAlias("firstName")
    private String firstName;

    @ColumnAlias("userId")
    private Long userId;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetTeamManagerNameResponse)) return false;
        final GetTeamManagerNameResponse getTeamManagerNameResponse = (GetTeamManagerNameResponse) o;
        return Objects.equals(getFirstName(), getTeamManagerNameResponse.getFirstName()) &&
                Objects.equals(getUserId(), getTeamManagerNameResponse.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(),
                getUserId());
    }
}