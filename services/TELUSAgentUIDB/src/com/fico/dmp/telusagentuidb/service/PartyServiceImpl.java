/*Copyright (c) 2020-2021 fico.com All Rights Reserved.
 This software is the confidential and proprietary information of fico.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with fico.com*/
package com.fico.dmp.telusagentuidb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import com.wavemaker.commons.MessageResource;
import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.runtime.util.logging.FAWBStaticLoggerBinder;

import com.fico.dmp.telusagentuidb.Document;
import com.fico.dmp.telusagentuidb.Note;
import com.fico.dmp.telusagentuidb.Party;


/**
 * ServiceImpl object for domain model class Party.
 *
 * @see Party
 */
@Service("TELUSAgentUIDB.PartyService")
@Validated
public class PartyServiceImpl implements PartyService {

    private static final Logger LOGGER =  FAWBStaticLoggerBinder.getSingleton().getLoggerFactory().getLogger(PartyServiceImpl.class.getName());

    @Lazy
    @Autowired
    @Qualifier("TELUSAgentUIDB.NoteService")
    private NoteService noteService;

    @Lazy
    @Autowired
    @Qualifier("TELUSAgentUIDB.DocumentService")
    private DocumentService documentService;

    @Autowired
    @Qualifier("TELUSAgentUIDB.PartyDao")
    private WMGenericDao<Party, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Party, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Party create(Party party) {
        LOGGER.debug("Creating a new Party with information: {}", party);

        Party partyCreated = this.wmGenericDao.create(party);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(partyCreated);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Party getById(Integer partyId) {
        LOGGER.debug("Finding Party by id: {}", partyId);
        return this.wmGenericDao.findById(partyId);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Party findById(Integer partyId) {
        LOGGER.debug("Finding Party by id: {}", partyId);
        try {
            return this.wmGenericDao.findById(partyId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Party found with id: {}", partyId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public List<Party> findByMultipleIds(List<Integer> partyIds, boolean orderedReturn) {
        LOGGER.debug("Finding Parties by ids: {}", partyIds);

        return this.wmGenericDao.findByMultipleIds(partyIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Party update(Party party) {
        LOGGER.debug("Updating Party with information: {}", party);

        this.wmGenericDao.update(party);
        this.wmGenericDao.refresh(party);

        return party;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Party delete(Integer partyId) {
        LOGGER.debug("Deleting Party with id: {}", partyId);
        Party deleted = this.wmGenericDao.findById(partyId);
        if (deleted == null) {
            LOGGER.debug("No Party found with id: {}", partyId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), Party.class.getSimpleName(), partyId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public void delete(Party party) {
        LOGGER.debug("Deleting Party with {}", party);
        this.wmGenericDao.delete(party);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<Party> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Parties");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<Party> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Parties");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TELUSAgentUIDB for table Party to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TELUSAgentUIDB for table Party to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public void importData(MultipartFile file) {
        LOGGER.debug("importing data in the service TELUSAgentUIDB for table Party");
        this.wmGenericDao.importData(file, "TELUSAgentUIDB", "PARTY");
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<Document> findAssociatedDocuments(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated documents");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("party.id = '" + id + "'");

        return documentService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<Note> findAssociatedNotes(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated notes");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("party.id = '" + id + "'");

        return noteService.findAll(queryBuilder.toString(), pageable);
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service NoteService instance
     */
    protected void setNoteService(NoteService service) {
        this.noteService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service DocumentService instance
     */
    protected void setDocumentService(DocumentService service) {
        this.documentService = service;
    }

}