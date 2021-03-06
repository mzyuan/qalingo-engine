/**
 * Most of the code in the Qalingo project is copyrighted Hoteia and licensed
 * under the Apache License Version 2.0 (release version 0.8.0)
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *                   Copyright (c) Hoteia, 2012-2014
 * http://www.hoteia.com - http://twitter.com/hoteia - contact@hoteia.com
 *
 */
package org.hoteia.qalingo.core.jms.notification.producer;

import org.hoteia.qalingo.core.jms.AbstractMessageJms;

public class EmailNotificationMessageJms extends AbstractMessageJms {

    private String emailType;
    private Long emailId;
    
    public String getEmailType() {
        return emailType;
    }
    
    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }
    
    public Long getEmailId() {
        return emailId;
    }
    
    public void setEmailId(Long emailId) {
        this.emailId = emailId;
    }
    
}
