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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class WorkflowDefinitionManagerImpl implements WorkflowDefinitionManager {

    private static volatile WorkflowDefinitionManagerImpl workflowDefinitionManagerImpl;

    public Map<String, WorkflowDefinition> workflowDefinitions = new HashMap<String, WorkflowDefinition>();

    @Override
    public String addWorkflow(WorkflowDefinition workflowDefinition, int tenantId) throws Exception {

        if (workflowDefinition.getWorkflowName().isEmpty()) {
            throw new Exception("Name is invalid");
        }
        //Code to persist the workflow definition
        String workflowId = UUID.randomUUID().toString();
        System.out.println(workflowId);
        workflowDefinitions.put(workflowId, workflowDefinition);

        return workflowId;
    }

    @Override
    public WorkflowDefinition getWorkflowByID(String workflowId) throws Exception {

        if (workflowId.isEmpty()) {
            throw new Exception("ID is invalid");
        }
        return workflowDefinitions.get(workflowId);


    }

    @Override
    public String updateWorkflow(WorkflowDefinition workflowDefinition) throws Exception {

        if (workflowDefinition.getWorkflowName().isEmpty()) {
            throw new Exception("Name is invalid");
        }

        workflowDefinitions.put(workflowDefinition.getWorkflowId(), workflowDefinition);

        return workflowDefinition.getWorkflowId();

    }

    @Override
    public List<Step> getWorkflowSteps(String workflowId) throws WorkflowException {

        return null;
    }

    @Override
    public List<WorkflowDefinition> listWorkflows(int tenantId, int limit, int offset) throws WorkflowException {

        return null;
    }

    @Override
    public void removeWorkflow(String workflowId) throws WorkflowException {
        workflowDefinitions.remove(workflowId);

    }

    /**
     * Singleton method
     *
     * @return WorkflowDefinitionManagerImpl
     */
    public static WorkflowDefinitionManagerImpl getInstance() {

        if (workflowDefinitionManagerImpl == null) {
            synchronized (WorkflowDefinitionManagerImpl.class) {
                if (workflowDefinitionManagerImpl == null) {
                    workflowDefinitionManagerImpl = new WorkflowDefinitionManagerImpl();
                }
            }
        }
        return workflowDefinitionManagerImpl;
    }

}
