/*Copyright (c) 2020-2021 fico.com All Rights Reserved.
 This software is the confidential and proprietary information of fico.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with fico.com*/
package com.fico.dmp.telusagentuidb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.HashMap;
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

import com.fico.dmp.telusagentuidb.AuditDataChange;
import com.fico.dmp.telusagentuidb.Document;
import com.fico.dmp.telusagentuidb.DomainValue;
import com.fico.dmp.telusagentuidb.DomainValueType;
import com.fico.dmp.telusagentuidb.FawbPropertySource;
import com.fico.dmp.telusagentuidb.Group;
import com.fico.dmp.telusagentuidb.GroupRole;
import com.fico.dmp.telusagentuidb.Party;
import com.fico.dmp.telusagentuidb.Queue;
import com.fico.dmp.telusagentuidb.Role;
import com.fico.dmp.telusagentuidb.TeamUser;
import com.fico.dmp.telusagentuidb.User;
import com.fico.dmp.telusagentuidb.UserGroup;
import com.fico.dmp.telusagentuidb.UserRole;
import com.fico.dmp.telusagentuidb.WorkcategoryUser;


/**
 * ServiceImpl object for domain model class User.
 *
 * @see User
 */
@Service("TELUSAgentUIDB.UserService")
@Validated
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER =  FAWBStaticLoggerBinder.getSingleton().getLoggerFactory().getLogger(UserServiceImpl.class.getName());

    @Lazy
    @Autowired
    @Qualifier("TELUSAgentUIDB.PartyService")
    private PartyService partyService;

    @Lazy
    @Autowired
    @Qualifier("TELUSAgentUIDB.AuditDataChangeService")
    private AuditDataChangeService auditDataChangeService;

    @Lazy
    @Autowired
    @Qualifier("TELUSAgentUIDB.UserGroupService")
    private UserGroupService userGroupService;

    @Lazy
    @Autowired
    @Qualifier("TELUSAgentUIDB.FawbPropertySourceService")
    private FawbPropertySourceService fawbPropertySourceService;

    @Lazy
    @Autowired
    @Qualifier("TELUSAgentUIDB.GroupRoleService")
    private GroupRoleService groupRoleService;

    @Lazy
    @Autowired
    @Qualifier("TELUSAgentUIDB.QueueService")
    private QueueService queueService;

    @Lazy
    @Autowired
    @Qualifier("TELUSAgentUIDB.WorkcategoryUserService")
    private WorkcategoryUserService workcategoryUserService;

    @Lazy
    @Autowired
    @Qualifier("TELUSAgentUIDB.TeamUserService")
    private TeamUserService teamUserService;

    @Lazy
    @Autowired
    @Qualifier("TELUSAgentUIDB.DomainValueTypeService")
    private DomainValueTypeService domainValueTypeService;

    @Lazy
    @Autowired
    @Qualifier("TELUSAgentUIDB.GroupService")
    private GroupService groupService;

    @Lazy
    @Autowired
    @Qualifier("TELUSAgentUIDB.RoleService")
    private RoleService roleService;

    @Lazy
    @Autowired
    @Qualifier("TELUSAgentUIDB.DomainValueService")
    private DomainValueService domainValueService;

    @Lazy
    @Autowired
    @Qualifier("TELUSAgentUIDB.DocumentService")
    private DocumentService documentService;

    @Lazy
    @Autowired
    @Qualifier("TELUSAgentUIDB.UserRoleService")
    private UserRoleService userRoleService;

    @Autowired
    @Qualifier("TELUSAgentUIDB.UserDao")
    private WMGenericDao<User, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<User, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public User create(User user) {
        LOGGER.debug("Creating a new User with information: {}", user);

        User userCreated = this.wmGenericDao.create(user);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(userCreated);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public User getById(Integer userIdInstance) {
        LOGGER.debug("Finding User by id: {}", userIdInstance);
        return this.wmGenericDao.findById(userIdInstance);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public User findById(Integer userIdInstance) {
        LOGGER.debug("Finding User by id: {}", userIdInstance);
        try {
            return this.wmGenericDao.findById(userIdInstance);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No User found with id: {}", userIdInstance, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public List<User> findByMultipleIds(List<Integer> userIdInstances, boolean orderedReturn) {
        LOGGER.debug("Finding Users by ids: {}", userIdInstances);

        return this.wmGenericDao.findByMultipleIds(userIdInstances, orderedReturn);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public User getByEmail(String email) {
        Map<String, Object> emailMap = new HashMap<>();
        emailMap.put("email", email);

        LOGGER.debug("Finding User by unique keys: {}", emailMap);
        return this.wmGenericDao.findByUniqueKey(emailMap);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public User getByUserId(String userId) {
        Map<String, Object> userIdMap = new HashMap<>();
        userIdMap.put("userId", userId);

        LOGGER.debug("Finding User by unique keys: {}", userIdMap);
        return this.wmGenericDao.findByUniqueKey(userIdMap);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public User update(User user) {
        LOGGER.debug("Updating User with information: {}", user);

        this.wmGenericDao.update(user);
        this.wmGenericDao.refresh(user);

        return user;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public User delete(Integer userIdInstance) {
        LOGGER.debug("Deleting User with id: {}", userIdInstance);
        User deleted = this.wmGenericDao.findById(userIdInstance);
        if (deleted == null) {
            LOGGER.debug("No User found with id: {}", userIdInstance);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), User.class.getSimpleName(), userIdInstance);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "TELUSAgentUIDBTransactionManager")
    @Override
    public void delete(User user) {
        LOGGER.debug("Deleting User with {}", user);
        this.wmGenericDao.delete(user);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<User> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Users");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<User> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Users");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TELUSAgentUIDB for table User to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service TELUSAgentUIDB for table User to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public void importData(MultipartFile file) {
        LOGGER.debug("importing data in the service TELUSAgentUIDB for table User");
        this.wmGenericDao.importData(file, "TELUSAgentUIDB", "USER");
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
    public Page<Party> findAssociatedPartiesForUpdatedBy(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated partiesForUpdatedBy");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByUpdatedBy.id = '" + id + "'");

        return partyService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<Party> findAssociatedPartiesForCreatedBy(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated partiesForCreatedBy");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByCreatedBy.id = '" + id + "'");

        return partyService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<Role> findAssociatedRolesForCreatedBy(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated rolesForCreatedBy");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByCreatedBy.id = '" + id + "'");

        return roleService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<Role> findAssociatedRolesForUpdatedBy(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated rolesForUpdatedBy");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByUpdatedBy.id = '" + id + "'");

        return roleService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<WorkcategoryUser> findAssociatedWorkcategoryUsers(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated workcategoryUsers");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("user.id = '" + id + "'");

        return workcategoryUserService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<DomainValue> findAssociatedDomainValuesForUpdatedBy(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated domainValuesForUpdatedBy");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByUpdatedBy.id = '" + id + "'");

        return domainValueService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<DomainValue> findAssociatedDomainValuesForCreatedBy(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated domainValuesForCreatedBy");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByCreatedBy.id = '" + id + "'");

        return domainValueService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<GroupRole> findAssociatedGroupRolesForUpdatedBy(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated groupRolesForUpdatedBy");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByUpdatedBy.id = '" + id + "'");

        return groupRoleService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<GroupRole> findAssociatedGroupRolesForCreatedBy(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated groupRolesForCreatedBy");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByCreatedBy.id = '" + id + "'");

        return groupRoleService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<UserRole> findAssociatedUserRoles(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated userRoles");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("user.id = '" + id + "'");

        return userRoleService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<Queue> findAssociatedQueuesForUpdatedBy(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated queuesForUpdatedBy");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByUpdatedBy.id = '" + id + "'");

        return queueService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<Queue> findAssociatedQueuesForCreatedBy(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated queuesForCreatedBy");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByCreatedBy.id = '" + id + "'");

        return queueService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<Queue> findAssociatedQueuesForLockedBy(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated queuesForLockedBy");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByLockedBy.id = '" + id + "'");

        return queueService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<Document> findAssociatedDocumentsForUpdatedBy(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated documentsForUpdatedBy");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByUpdatedBy.id = '" + id + "'");

        return documentService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<Document> findAssociatedDocumentsForCreatedBy(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated documentsForCreatedBy");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByCreatedBy.id = '" + id + "'");

        return documentService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<AuditDataChange> findAssociatedAuditDataChanges(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated auditDataChanges");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("user.id = '" + id + "'");

        return auditDataChangeService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<TeamUser> findAssociatedTeamUsers(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated teamUsers");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("user.id = '" + id + "'");

        return teamUserService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<FawbPropertySource> findAssociatedFawbPropertySourcesForUpdatedBy(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated fawbPropertySourcesForUpdatedBy");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByUpdatedBy.id = '" + id + "'");

        return fawbPropertySourceService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<FawbPropertySource> findAssociatedFawbPropertySourcesForCreatedBy(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated fawbPropertySourcesForCreatedBy");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByCreatedBy.id = '" + id + "'");

        return fawbPropertySourceService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<DomainValueType> findAssociatedDomainValueTypesForCreatedBy(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated domainValueTypesForCreatedBy");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByCreatedBy.id = '" + id + "'");

        return domainValueTypeService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<DomainValueType> findAssociatedDomainValueTypesForUpdatedBy(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated domainValueTypesForUpdatedBy");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByUpdatedBy.id = '" + id + "'");

        return domainValueTypeService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<User> findAssociatedUsersForUpdatedBy(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated usersForUpdatedBy");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByUpdatedBy.id = '" + id + "'");

        return findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<User> findAssociatedUsersForCreatedBy(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated usersForCreatedBy");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByCreatedBy.id = '" + id + "'");

        return findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<Group> findAssociated_groupsForUpdatedBy(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated _groupsForUpdatedBy");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByUpdatedBy.id = '" + id + "'");

        return groupService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<Group> findAssociated_groupsForCreatedBy(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated _groupsForCreatedBy");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByCreatedBy.id = '" + id + "'");

        return groupService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<UserGroup> findAssociatedUserGroupsForUserId(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated userGroupsForUserId");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByUserId.id = '" + id + "'");

        return userGroupService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<UserGroup> findAssociatedUserGroupsForUpdatedBy(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated userGroupsForUpdatedBy");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByUpdatedBy.id = '" + id + "'");

        return userGroupService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "TELUSAgentUIDBTransactionManager")
    @Override
    public Page<UserGroup> findAssociatedUserGroupsForCreatedBy(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated userGroupsForCreatedBy");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("userByCreatedBy.id = '" + id + "'");

        return userGroupService.findAll(queryBuilder.toString(), pageable);
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service PartyService instance
     */
    protected void setPartyService(PartyService service) {
        this.partyService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service AuditDataChangeService instance
     */
    protected void setAuditDataChangeService(AuditDataChangeService service) {
        this.auditDataChangeService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service UserGroupService instance
     */
    protected void setUserGroupService(UserGroupService service) {
        this.userGroupService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service FawbPropertySourceService instance
     */
    protected void setFawbPropertySourceService(FawbPropertySourceService service) {
        this.fawbPropertySourceService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service GroupRoleService instance
     */
    protected void setGroupRoleService(GroupRoleService service) {
        this.groupRoleService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service QueueService instance
     */
    protected void setQueueService(QueueService service) {
        this.queueService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service WorkcategoryUserService instance
     */
    protected void setWorkcategoryUserService(WorkcategoryUserService service) {
        this.workcategoryUserService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service TeamUserService instance
     */
    protected void setTeamUserService(TeamUserService service) {
        this.teamUserService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service DomainValueTypeService instance
     */
    protected void setDomainValueTypeService(DomainValueTypeService service) {
        this.domainValueTypeService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service GroupService instance
     */
    protected void setGroupService(GroupService service) {
        this.groupService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service RoleService instance
     */
    protected void setRoleService(RoleService service) {
        this.roleService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service DomainValueService instance
     */
    protected void setDomainValueService(DomainValueService service) {
        this.domainValueService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service DocumentService instance
     */
    protected void setDocumentService(DocumentService service) {
        this.documentService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service UserRoleService instance
     */
    protected void setUserRoleService(UserRoleService service) {
        this.userRoleService = service;
    }

}