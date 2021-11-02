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

import org.wso2.carbon.identity.workflow.mgt.bean.Parameter;
import org.wso2.carbon.identity.workflow.mgt.bean.Workflow;
import org.wso2.carbon.identity.workflow.mgt.exception.WorkflowException;

import java.util.List;

/**
 * List methods that can be associated to workflow definitions, eg:- Add definition, etc
 */
public interface WorkflowDefinitionManager {

    /**
     * Add new workflow
     *
     * @param workflowDTO   Workflow details
     * @param parameterList List of parameters
     * @param tenantId      tenant id
     * @throws WorkflowException
     */
    void addWorkflow(Workflow workflowDTO, List<Parameter> parameterList, int tenantId) throws WorkflowException;

    /**
     * Retrieve workflow from workflow ID
     *
     * @param workflowId workflow id
     * @throws WorkflowException
     */
    Workflow getWorkflowByID(String workflowId) throws WorkflowException;

    /**
     * List parameters of a workflow
     *
     * @param workflowId workflow id
     * @throws WorkflowException
     */
    List<Parameter> getWorkflowParameters(String workflowId) throws WorkflowException;

    /**
     * List workflows for a tenant
     *
     * @param tenantId Tenant ID
     * @throws WorkflowException
     */
    List<Workflow> getAllWorkflows(int tenantId) throws WorkflowException;

    /**
     * Remove a workflow
     *
     * @param id ID of workflow to remove
     * @throws WorkflowException
     */
    void removeWorkflow(String workflowId) throws WorkflowException;

}
