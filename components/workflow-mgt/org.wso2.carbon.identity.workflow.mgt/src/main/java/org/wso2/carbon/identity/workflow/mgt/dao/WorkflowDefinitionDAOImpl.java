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

import org.wso2.carbon.identity.core.util.IdentityDatabaseUtil;
import org.wso2.carbon.identity.workflow.mgt.bean.Workflow;
import org.wso2.carbon.identity.workflow.mgt.bean.WorkflowDefinition;
import org.wso2.carbon.identity.workflow.mgt.exception.InternalWorkflowException;
import org.wso2.carbon.identity.workflow.mgt.util.SQLConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class WorkflowDefinitionDAOImpl implements WorkflowDefinitionDAO {

    private final String errorMessage = "Error when executing the SQL query ";

    @Override
    public void addWorkflow(WorkflowDefinition workflowDefinition, int tenantId) throws InternalWorkflowException {

    }

    @Override
    public WorkflowDefinition getWorkflow(String workflowId) throws InternalWorkflowException {

        return null;
    }

    @Override
    public void removeWorkflow(String workflowId) throws InternalWorkflowException {

    }

    @Override
    public void updateWorkflow(WorkflowDefinition workflowDefinition) throws InternalWorkflowException {

    }

    @Override
    public List<WorkflowDefinition> listWorkflows(int tenantId) throws InternalWorkflowException {

        return null;
    }
}
