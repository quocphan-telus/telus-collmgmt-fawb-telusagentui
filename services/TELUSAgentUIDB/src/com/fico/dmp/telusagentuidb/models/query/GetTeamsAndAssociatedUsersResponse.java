/*Copyright (c) 2020-2021 fico.com All Rights Reserved.
 This software is the confidential and proprietary information of fico.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with fico.com*/
package com.fico.dmp.telusagentuidb.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetTeamsAndAssociatedUsersResponse implements Serializable {


    @ColumnAlias("ID")
    private Long id;

    @ColumnAlias("TeamID")
    private String teamId;

    @ColumnAlias("TeamName")
    private String teamName;

    @ColumnAlias("userCount")
    private Long userCount;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Long getUserCount() {
        return this.userCount;
    }

    public void setUserCount(Long userCount) {
        this.userCount = userCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetTeamsAndAssociatedUsersResponse)) return false;
        final GetTeamsAndAssociatedUsersResponse getTeamsAndAssociatedUsersResponse = (GetTeamsAndAssociatedUsersResponse) o;
        return Objects.equals(getId(), getTeamsAndAssociatedUsersResponse.getId()) &&
                Objects.equals(getTeamId(), getTeamsAndAssociatedUsersResponse.getTeamId()) &&
                Objects.equals(getTeamName(), getTeamsAndAssociatedUsersResponse.getTeamName()) &&
                Objects.equals(getUserCount(), getTeamsAndAssociatedUsersResponse.getUserCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getTeamId(),
                getTeamName(),
                getUserCount());
    }
}