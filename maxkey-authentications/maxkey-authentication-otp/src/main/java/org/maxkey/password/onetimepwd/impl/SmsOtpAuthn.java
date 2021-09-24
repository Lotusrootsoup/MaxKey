/*
 * Copyright [2020] [MaxKey of copyright http://www.maxkey.top]
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
 

package org.maxkey.password.onetimepwd.impl;

import java.io.IOException;
import java.util.Properties;

import org.maxkey.entity.UserInfo;
import org.maxkey.password.onetimepwd.AbstractOtpAuthn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmsOtpAuthn extends AbstractOtpAuthn {
    private static final  Logger logger = LoggerFactory.getLogger(SmsOtpAuthn.class);
    
    protected Properties properties;
    
    
    @Override
    public boolean produce(UserInfo userInfo) {
        String token = this.genToken(userInfo);
        // TODO:You must add send sms code here
        logger.debug("send sms code" + token);
        return true;
    }

    @Override
    public boolean validate(UserInfo userInfo, String token) {
        return true;
    }
    
    public void setProperties(Properties properties) {
		this.properties = properties;
	}

	protected void loadProperties() throws IOException {

    }
    
    public void initPropertys() {
        
    }

}
