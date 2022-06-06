/*
 * Copyright [2022] [MaxKey of copyright http://www.maxkey.top]
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 

package org.maxkey.listener;

import java.io.Serializable;

import org.maxkey.persistence.service.RolesService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicRolesListenerAdapter extends ListenerAdapter  implements Job , Serializable {
	final static Logger _logger = LoggerFactory.getLogger(DynamicRolesListenerAdapter.class);
    
    private static final long serialVersionUID = 8831626240807856084L;

    private static  RolesService rolesService = null;

    @Override
    public void execute(JobExecutionContext context){
        if(jobStatus == JOBSTATUS.RUNNING) {return;}
        
        init(context);
        
        _logger.debug("running ... " );
        jobStatus = JOBSTATUS.RUNNING;
        try {
            if(rolesService != null) {
            	rolesService.refreshAllDynamicRoles();
            	Thread.sleep(10 * 1000);//10 minutes
            }
            _logger.debug("finished  " );
            jobStatus = JOBSTATUS.FINISHED;
        }catch(Exception e) {
            jobStatus = JOBSTATUS.ERROR;
            _logger.error("Exception " ,e);
        }
    }

    @Override
    void init(JobExecutionContext context){
    	super.init(context);
    	if(rolesService == null) {
    		rolesService = getParameter("rolesService",RolesService.class);
        }
    }

}
