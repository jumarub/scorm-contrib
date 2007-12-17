/**********************************************************************************
 * $URL:  $
 * $Id:  $
 ***********************************************************************************
 *
 * Copyright (c) 2007 The Sakai Foundation.
 * 
 * Licensed under the Educational Community License, Version 1.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at
 * 
 *      http://www.opensource.org/licenses/ecl1.php
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 *
 **********************************************************************************/
package org.sakaiproject.scorm.service.api;

import javax.swing.tree.TreeModel;

import org.sakaiproject.scorm.model.api.SessionBean;

public interface ScormSequencingService {

	/**
	 * This navigate method is used for start, next, previous, suspend, and quit requests
	 */
	public String navigate(int request, SessionBean sessionBean, INavigable agent, Object target);
	
	/**
	 * This navigate method is used for 'choice' requests, that is, ones that arise from a user
	 * clicking on the tree of available activities
	 */
	public void navigate(String choiceRequest, SessionBean sessionBean, INavigable agent, Object target);
	
	/**
	 * This navigate method is almost identical to the one above, except that it uses a different
	 * identifier to determine which activity has been clicked on.
	 */
	public void navigateToActivity(String activityId, SessionBean sessionBean, INavigable agent, Object target);
	
	/**
	 * This method is called once at the beginning of each user session to provide the bean
	 * where all state information will be stored
	 */
	public SessionBean newSessionBean(String courseId, long contentPackageId);
	
	/**
	 * Called to get the destination url for the selected sco
	 */
	public String getCurrentUrl(SessionBean sessionBean);
	
	/**
	 * Called to get the TreeModel object that represents the 'choice' tree of activities
	 */
	public TreeModel getTreeModel(SessionBean sessionBean);
	
	/**
	 * Indicates if the user is allowed to 'continue' to the next sco
	 */
	public boolean isContinueEnabled(SessionBean sessionBean);
	
	/**
	 * Indicates if the user is allowed to 'continue' to the next sco, even if it means exiting
	 * the session
	 */
	public boolean isContinueExitEnabled(SessionBean sessionBean);
	
	/**
	 * Indicates if the user is allowed to return to the previous sco
	 */
	public boolean isPreviousEnabled(SessionBean sessionBean);

	/**
	 * Indicates if the user is allowed to resume a suspended session
	 */
	public boolean isResumeEnabled(SessionBean sessionBean);
	
	/**
	 * Indicates if the user is allowed to start a given session
	 */
	public boolean isStartEnabled(SessionBean sessionBean);
	
	/**
	 * Indicates if the user is allowed to suspend a given session
	 */
	public boolean isSuspendEnabled(SessionBean sessionBean);
	
	/**
	 * Indicates if the user is currently in 'flow' mode
	 */
	public boolean isControlModeFlow(SessionBean sessionBean);
	
	/**
	 * Indicates if the user is currently in 'choice' mode
	 */
	public boolean isControlModeChoice(SessionBean sessionBean);
	
}
