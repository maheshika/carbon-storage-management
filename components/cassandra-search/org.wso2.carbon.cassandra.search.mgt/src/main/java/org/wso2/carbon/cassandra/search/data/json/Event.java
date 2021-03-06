/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *   * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.wso2.carbon.cassandra.search.data.json;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private String stream;
    private String rowId;
    private String version;
    private String timestamp;
    private String host;
    private String activityId;
    private String messageBodyType;
    private String messageBody;

    private List<ColumnValue> content;

    public Event(String rowId) {
        this.rowId = rowId;
        content = new ArrayList<ColumnValue>();
    }

    public Event() {
        content = new ArrayList<ColumnValue>();
    }

    public Event(String stream, String rowId, String version, String timestamp) {
        this.stream = stream;
        this.rowId = rowId;
        this.version = version;
        this.timestamp = timestamp;
        content = new ArrayList<ColumnValue>();
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public void setMessageBodyType(String messageBodyType) {
        this.messageBodyType = messageBodyType;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public void setContent(List<ColumnValue> content) {
        this.content = content;
    }

    public void addAttributeValue(ColumnValue record) {
        content.add(record);
    }

    public void addColumnValue(String columnName, String columnValue) {
        content.add(new ColumnValue(columnName, columnValue));
    }
}
