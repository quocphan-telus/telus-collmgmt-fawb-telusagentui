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
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * QrtzTriggers generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`QRTZ_TRIGGERS`", indexes = {
            @Index(name = "`QRTZ_TRIGGERS_ibfk_1`", columnList = "`JOB_GROUP`, `SCHED_NAME`, `JOB_NAME`")})
@IdClass(QrtzTriggersId.class)
public class QrtzTriggers implements Serializable {


    private String schedName;

    private String triggerName;

    private String triggerGroup;

    private String calendarName;

    private String description;

    private Long endTime;

    private String jobGroup;

    private String jobName;

    private Short misfireInstr;

    private Long nextFireTime;

    private Long prevFireTime;

    private Integer priority;

    private long startTime;

    private String triggerState;

    private String triggerType;

    @JsonProperty(access = Access.READ_ONLY)
    private byte[] jobData;

    private QrtzJobDetails qrtzJobDetails;

    @Id
    @Column(name = "`SCHED_NAME`", nullable = false, length = 120)
    public String getSchedName() {
        return this.schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    @Id
    @Column(name = "`TRIGGER_NAME`", nullable = false, length = 200)
    public String getTriggerName() {
        return this.triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    @Id
    @Column(name = "`TRIGGER_GROUP`", nullable = false, length = 200)
    public String getTriggerGroup() {
        return this.triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    @Column(name = "`CALENDAR_NAME`", nullable = true, length = 200)
    public String getCalendarName() {
        return this.calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    @Column(name = "`DESCRIPTION`", nullable = true, length = 250)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "`END_TIME`", nullable = true, scale = 0, precision = 19)
    public Long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    @Column(name = "`JOB_GROUP`", nullable = false, length = 200)
    public String getJobGroup() {
        return this.jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    @Column(name = "`JOB_NAME`", nullable = false, length = 200)
    public String getJobName() {
        return this.jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Column(name = "`MISFIRE_INSTR`", nullable = true, scale = 0, precision = 5)
    public Short getMisfireInstr() {
        return this.misfireInstr;
    }

    public void setMisfireInstr(Short misfireInstr) {
        this.misfireInstr = misfireInstr;
    }

    @Column(name = "`NEXT_FIRE_TIME`", nullable = true, scale = 0, precision = 19)
    public Long getNextFireTime() {
        return this.nextFireTime;
    }

    public void setNextFireTime(Long nextFireTime) {
        this.nextFireTime = nextFireTime;
    }

    @Column(name = "`PREV_FIRE_TIME`", nullable = true, scale = 0, precision = 19)
    public Long getPrevFireTime() {
        return this.prevFireTime;
    }

    public void setPrevFireTime(Long prevFireTime) {
        this.prevFireTime = prevFireTime;
    }

    @Column(name = "`PRIORITY`", nullable = true, scale = 0, precision = 10)
    public Integer getPriority() {
        return this.priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Column(name = "`START_TIME`", nullable = false, scale = 0, precision = 19)
    public long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    @Column(name = "`TRIGGER_STATE`", nullable = false, length = 16)
    public String getTriggerState() {
        return this.triggerState;
    }

    public void setTriggerState(String triggerState) {
        this.triggerState = triggerState;
    }

    @Column(name = "`TRIGGER_TYPE`", nullable = false, length = 8)
    public String getTriggerType() {
        return this.triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    @Lob()
    @Column(name = "`JOB_DATA`", nullable = true)
    public byte[] getJobData() {
        return this.jobData;
    }

    public void setJobData(byte[] jobData) {
        this.jobData = jobData;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns(value = {
            @JoinColumn(name = "`JOB_GROUP`", referencedColumnName = "`JOB_GROUP`", insertable = false, updatable = false),
            @JoinColumn(name = "`JOB_NAME`", referencedColumnName = "`JOB_NAME`", insertable = false, updatable = false),
            @JoinColumn(name = "`SCHED_NAME`", referencedColumnName = "`SCHED_NAME`", insertable = false, updatable = false)},
        foreignKey = @ForeignKey(name = "`QRTZ_TRIGGERS_ibfk_1`"))
    @Fetch(FetchMode.JOIN)
    public QrtzJobDetails getQrtzJobDetails() {
        return this.qrtzJobDetails;
    }

    public void setQrtzJobDetails(QrtzJobDetails qrtzJobDetails) {
        if(qrtzJobDetails != null) {
            this.jobGroup = qrtzJobDetails.getJobGroup();
            this.jobName = qrtzJobDetails.getJobName();
            this.schedName = qrtzJobDetails.getSchedName();
        }

        this.qrtzJobDetails = qrtzJobDetails;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QrtzTriggers)) return false;
        final QrtzTriggers qrtzTriggers = (QrtzTriggers) o;
        return Objects.equals(getSchedName(), qrtzTriggers.getSchedName()) &&
                Objects.equals(getTriggerName(), qrtzTriggers.getTriggerName()) &&
                Objects.equals(getTriggerGroup(), qrtzTriggers.getTriggerGroup());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSchedName(),
                getTriggerName(),
                getTriggerGroup());
    }
}