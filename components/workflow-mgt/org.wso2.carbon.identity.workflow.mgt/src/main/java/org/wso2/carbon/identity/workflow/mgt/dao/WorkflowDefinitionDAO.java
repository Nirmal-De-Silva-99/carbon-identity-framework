/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.com).
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.workflow.mgt.dao;

import org.wso2.carbon.identity.workflow.mgt.bean.Workflow;
import org.wso2.carbon.identity.workflow.mgt.bean.WorkflowDefinition;
import org.wso2.carbon.identity.workflow.mgt.exception.InternalWorkflowException;

import java.util.List;

/**
 * Workflow related DAO operations are provided by this class
 */
public interface WorkflowDefinitionDAO {

    /**
     * Adding a workflow
     *
     * @param workflowDefinition Workflow bean object
     * @param tenantId Tenant ID
     * @throws InternalWorkflowException
     */
    void addWorkflow(WorkflowDefinition workflowDefinition, int tenantId) throws InternalWorkflowException;

    /**
     * Get a Workflow object for given workflow Id
     *
     * @param workflowId Workflow unique id
     * @return Workflow object
     * @throws InternalWorkflowException
     */
    WorkflowDefinition getWorkflow(String workflowId) throws InternalWorkflowException;

    /**
     * Remove Workflow from the DB
     *
     * @param workflowId workflow Id
     * @throws InternalWorkflowException
     */
    void removeWorkflow(String workflowId) throws InternalWorkflowException;

    /**
     * Update current workflow
     *
     * @param workflowDefinition Workflow object
     * @throws InternalWorkflowException
     */
    void updateWorkflow(WorkflowDefinition workflowDefinition) throws InternalWorkflowException;

    /**
     * Retrieve all the Workflows for a tenant
     *
     * @param tenantId Tenant ID
     * @return List<Workflow>
     * @throws InternalWorkflowException
     */
    List<WorkflowDefinition> listWorkflows(int tenantId) throws InternalWorkflowException;

}
