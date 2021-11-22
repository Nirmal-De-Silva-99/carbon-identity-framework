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
import org.wso2.carbon.identity.workflow.mgt.exception.InternalWorkflowException;
import org.wso2.carbon.identity.workflow.mgt.util.SQLConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class WorkflowDefinitionDAOImpl implements WorkflowDefinitionDAO {

    private final String errorMessage = "Error when executing the SQL query ";

    @Override
    public void addWorkflow(Workflow workflow, int tenantId) throws InternalWorkflowException {

        Connection connection = IdentityDatabaseUtil.getDBConnection();
        PreparedStatement prepStmt = null;
        String query = SQLConstants.ADD_WORKFLOW_QUERY;
        try {
            prepStmt = connection.prepareStatement(query);
            prepStmt.setString(1, workflow.getWorkflowId());
            prepStmt.setString(2, workflow.getWorkflowName());
            prepStmt.setString(3, workflow.getWorkflowDescription());
            prepStmt.setString(4, workflow.getTemplateId());
            prepStmt.setString(5, workflow.getWorkflowImplId());
            prepStmt.setInt(6, tenantId);
            prepStmt.executeUpdate();
            IdentityDatabaseUtil.commitTransaction(connection);
        } catch (SQLException e) {
            IdentityDatabaseUtil.rollbackTransaction(connection);
            throw new InternalWorkflowException(errorMessage, e);
        } finally {
            IdentityDatabaseUtil.closeAllConnections(connection, null, prepStmt);
        }
    }

    @Override
    public Workflow getWorkflow(String workflowId) throws InternalWorkflowException {

        return null;
    }

    @Override
    public void removeWorkflow(String workflowId) throws InternalWorkflowException {

    }

    @Override
    public void updateWorkflow(String workflowId, Workflow workflow) throws InternalWorkflowException {

    }

    @Override
    public List<Workflow> listWorkflows(int tenantId) throws InternalWorkflowException {

        return null;
    }
}
