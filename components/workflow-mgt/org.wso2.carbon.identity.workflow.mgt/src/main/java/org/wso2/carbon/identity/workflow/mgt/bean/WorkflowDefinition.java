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

package org.wso2.carbon.identity.workflow.mgt.bean;

import java.io.Serializable;

public class WorkflowDefinition implements Serializable {

    private String workflowId;
    private String workflowName;
    private String workflowDescription;
    private Step[] steps;

    public String getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId;
    }

    public String getWorkflowName() {
        return workflowName;
    }

    public WorkflowDefinition setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
        return this;
    }

    public String getWorkflowDescription() {
        return workflowDescription;
    }

    public WorkflowDefinition setWorkflowDescription(String workflowDescription) {
        this.workflowDescription = workflowDescription;
        return this;
    }

    public Step[] getSteps() {
        return steps;
    }

    public WorkflowDefinition setSteps(Step[] steps) {
        this.steps = steps;
        return this;
    }
}
