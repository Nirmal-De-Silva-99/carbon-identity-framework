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

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.wso2.carbon.identity.workflow.mgt.bean.Step;
import org.wso2.carbon.identity.workflow.mgt.bean.WorkflowDefinition;
import org.wso2.carbon.identity.workflow.mgt.exception.WorkflowException;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class WorkflowDefinitionManagerImplTest {

    private WorkflowDefinitionManagerImpl workflowDefinitionManager = new WorkflowDefinitionManagerImpl();
    private int tenantId = 1234;

    private Set<String> workflowIds = new HashSet<>();

    @Test(dataProvider = "ValidWorkflowDefinitions")
    public void testAddWorkflowDefinition(WorkflowDefinition validDefinition) throws Exception {

        String workflowDefinitionId = workflowDefinitionManager.addWorkflow(validDefinition, tenantId);
        workflowIds.add(workflowDefinitionId);
        System.out.println(workflowDefinitionManager.getWorkflowByID(workflowDefinitionId).getWorkflowId());
        Assert.assertNotNull(workflowDefinitionId, "Workflow Definition not Added");
    }

    @Test(dataProvider = "InvalidWorkflowDefinitions")
    public void testAddInvalidWorkflowDefinition(WorkflowDefinition invalidDefinition, String expectedErrorMessage) throws Exception {

        try {
            workflowDefinitionManager.addWorkflow(invalidDefinition, tenantId);
            Assert.fail("Invalid Workflow Definition Added");
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), expectedErrorMessage);
        }
    }

    @Test(dependsOnMethods = "testAddWorkflowDefinition")
    public void testGetWorkflowDefinition() throws Exception {

        Assert.assertFalse(workflowIds.isEmpty(), "No added workflows");
        for (String workflowId : workflowIds) {
            WorkflowDefinition workflowDefinition = workflowDefinitionManager.getWorkflowByID(workflowId);
            Assert.assertNotNull(workflowDefinition, "Workflow Definition not found");
        }
    }

    @Test(dependsOnMethods = "testGetWorkflowDefinition")
    public void testListWorkflows() throws Exception {

        Assert.assertFalse(workflowIds.isEmpty(), "No added workflows");
        for (String workflowId : workflowIds) {
            List<WorkflowDefinition> workflowDefinitionsList =  workflowDefinitionManager.listWorkflows(tenantId, 1, 4);
            Assert.assertNotNull(workflowDefinitionsList, "Workflow Definitions not found");
        }

    }

    @Test(dependsOnMethods = "testListWorkflows")
    public void testRemoveWorkflow() throws Exception {
        Assert.assertFalse(workflowIds.isEmpty(), "No added workflows");
        int size = workflowIds.size();
        int item = new Random().nextInt(size);
        int i = 0;
        String workflowId = null;

        for (String s: workflowIds) {
            if (i == item)
                workflowId = s;
            i++;
        }

        WorkflowDefinition testDefinition = new WorkflowDefinition().setWorkflowName("Test").setWorkflowDescription("Test Description").setSteps(new Step[]{});

        workflowDefinitionManager.removeWorkflow(workflowId);

        assert workflowId != null;
        Assert.assertNotNull(workflowDefinitionManager.getWorkflowByID(workflowId), "Workflow Definition not deleted");

    }

    @Test(dataProvider = "UpdatingWorkflowDefinitions")
    public void testUpdateWorkflow(WorkflowDefinition updatingDefinition) throws Exception {

        String workflowDefinitionId = workflowDefinitionManager.updateWorkflow(updatingDefinition);
        workflowIds.add(workflowDefinitionId);
        Assert.assertNotNull(workflowDefinitionId, "Workflow Definition not Added");
        Assert.assertEquals(updatingDefinition, workflowDefinitionManager.getWorkflowByID(workflowDefinitionId));

    }

    @Test
    public void testGetWorkflowSteps() {

    }


    @DataProvider(name = "ValidWorkflowDefinitions")
    public Object[][] getValidWorkflowDefinitions() {

        WorkflowDefinition definition = new WorkflowDefinition();
        definition.setWorkflowName("Test");
        definition.setWorkflowDescription("");

        return new Object[][]{
                {new WorkflowDefinition().setWorkflowName("Test").setWorkflowDescription("Test Description").setSteps(new Step[]{})},
                {new WorkflowDefinition().setWorkflowName("Test").setWorkflowDescription("").setSteps(null).setSteps(new Step[]{})},
                {new WorkflowDefinition().setWorkflowName("Test").setWorkflowDescription(null).setSteps(null).setSteps(new Step[]{})},
        };
    }

    @DataProvider(name = "InvalidWorkflowDefinitions")
    public Object[][] getInvalidWorkflowDefinitions() {

        return new Object[][]{
                {new WorkflowDefinition().setWorkflowName(null).setWorkflowDescription("Test Description").setSteps(new Step[]{}), "Name is invalid"},
                {new WorkflowDefinition().setWorkflowName("Test").setWorkflowDescription("Test Description").setSteps(null), "No Steps Configured"},

        };
    }

    @DataProvider(name = "UpdatingWorkflowDefinitions")
    public Object[][] getUpdatingWorkflowDefinitions() {

        return new Object[][]{
                {new WorkflowDefinition().setWorkflowName("Test Updated").setWorkflowDescription("Test Description Updated").setSteps(new Step[]{})},
                {new WorkflowDefinition().setWorkflowName("Test Updated").setWorkflowDescription("").setSteps(null).setSteps(new Step[]{})},
                {new WorkflowDefinition().setWorkflowName("Test Updated").setWorkflowDescription(null).setSteps(null).setSteps(new Step[]{})},
        };
    }

    @BeforeMethod
    public void setUp() {

    }

    @AfterMethod
    public void tearDown() {

    }

}