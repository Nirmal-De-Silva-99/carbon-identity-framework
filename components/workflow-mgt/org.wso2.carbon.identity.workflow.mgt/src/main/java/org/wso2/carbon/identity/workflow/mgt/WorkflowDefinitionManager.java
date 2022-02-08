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

package org.wso2.carbon.identity.workflow.mgt;

import org.wso2.carbon.identity.workflow.mgt.bean.Step;
import org.wso2.carbon.identity.workflow.mgt.bean.WorkflowDefinition;
import org.wso2.carbon.identity.workflow.mgt.exception.WorkflowException;

import java.util.List;

/**
 * List methods that can be associated to workflow definitions, eg:- Add definition, etc
 */
public interface WorkflowDefinitionManager {

    /**
     * Add new workflow
     *
     * @param workflowDefinition    Workflow details
     * @param tenantId              tenant id
     * @throws WorkflowException
     */
    String addWorkflow(WorkflowDefinition workflowDefinition, int tenantId) throws Exception;

    /**
     * Retrieve workflow from workflow ID
     *
     * @param workflowId workflow id
     * @throws WorkflowException
     */
    WorkflowDefinition getWorkflowByID(String workflowId) throws Exception;

    /**
     * Update a workflow
     *
     * @param workflowDefinition workflow details
     * @throws WorkflowException
     */
    String updateWorkflow(WorkflowDefinition workflowDefinition) throws Exception;

    /**
     * List steps of a workflow
     *
     * @param workflowId workflow id
     * @throws WorkflowException
     */
    List<Step> getWorkflowSteps(String workflowId) throws WorkflowException;

    /**
     * List workflows for a tenant
     *
     * @param tenantId Tenant ID
     * @param limit Limit
     * @param offset Offset
     * @throws WorkflowException
     */
    List<WorkflowDefinition> listWorkflows(int tenantId, int limit, int offset) throws WorkflowException;

    /**
     * Remove a workflow
     *
     * @param workflowId ID of workflow to remove
     * @throws WorkflowException
     */
    void removeWorkflow(String workflowId) throws WorkflowException;

}
