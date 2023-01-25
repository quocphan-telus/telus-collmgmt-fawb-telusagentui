/*Copyright (c) 2020-2021 fico.com All Rights Reserved.
 This software is the confidential and proprietary information of fico.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with fico.com*/
package com.fico.dmp.telusagentuidb.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.fico.dmp.telusagentuidb.QrtzCalendars;
import com.fico.dmp.telusagentuidb.QrtzCalendarsId;

/**
 * Specifies methods used to obtain and modify QrtzCalendars related information
 * which is stored in the database.
 */
@Repository("TELUSAgentUIDB.QrtzCalendarsDao")
public class QrtzCalendarsDao extends WMGenericDaoImpl<QrtzCalendars, QrtzCalendarsId> {

    @Autowired
    @Qualifier("TELUSAgentUIDBTemplate")
    private HibernateTemplate template;


    @Override
    public HibernateTemplate getTemplate() {
        return this.template;
    }
}