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
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * SchemaVersion generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`schema_version`", indexes = {
            @Index(name = "`schema_version_ir_idx`", columnList = "`installed_rank`"),
            @Index(name = "`schema_version_vr_idx`", columnList = "`version_rank`"),
            @Index(name = "`schema_version_s_idx`", columnList = "`success`")})
public class SchemaVersion implements Serializable {


    private String version;

    private int versionRank;

    private int installedRank;

    private String description;

    private String type;

    private String script;

    private Integer checksum;

    private String installedBy;

    private Timestamp installedOn;

    private int executionTime;

    private boolean success;

    @Id
    @Column(name = "`version`", nullable = false, length = 50)
    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Column(name = "`version_rank`", nullable = false, scale = 0, precision = 10)
    public int getVersionRank() {
        return this.versionRank;
    }

    public void setVersionRank(int versionRank) {
        this.versionRank = versionRank;
    }

    @Column(name = "`installed_rank`", nullable = false, scale = 0, precision = 10)
    public int getInstalledRank() {
        return this.installedRank;
    }

    public void setInstalledRank(int installedRank) {
        this.installedRank = installedRank;
    }

    @Column(name = "`description`", nullable = false, length = 200)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "`type`", nullable = false, length = 20)
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "`script`", nullable = false, length = 1000)
    public String getScript() {
        return this.script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    @Column(name = "`checksum`", nullable = true, scale = 0, precision = 10)
    public Integer getChecksum() {
        return this.checksum;
    }

    public void setChecksum(Integer checksum) {
        this.checksum = checksum;
    }

    @Column(name = "`installed_by`", nullable = false, length = 100)
    public String getInstalledBy() {
        return this.installedBy;
    }

    public void setInstalledBy(String installedBy) {
        this.installedBy = installedBy;
    }

    @Column(name = "`installed_on`", nullable = false)
    public Timestamp getInstalledOn() {
        return this.installedOn;
    }

    public void setInstalledOn(Timestamp installedOn) {
        this.installedOn = installedOn;
    }

    @Column(name = "`execution_time`", nullable = false, scale = 0, precision = 10)
    public int getExecutionTime() {
        return this.executionTime;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    @Column(name = "`success`", nullable = false)
    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SchemaVersion)) return false;
        final SchemaVersion schemaVersion = (SchemaVersion) o;
        return Objects.equals(getVersion(), schemaVersion.getVersion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVersion());
    }
}