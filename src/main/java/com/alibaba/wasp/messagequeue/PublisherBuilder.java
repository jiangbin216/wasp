/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.wasp.messagequeue;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import com.alibaba.wasp.EntityGroupInfo;
import com.alibaba.wasp.storage.StorageActionManager;

public class PublisherBuilder {

  public static final Log LOG = LogFactory.getLog(PublisherBuilder.class);

  public PublisherBuilder() {
  }

  public Publisher build(Configuration conf, EntityGroupInfo entityGroupInfo) {
    try {
      return new Publisher(entityGroupInfo, new StorageActionManager(conf));
    } catch (IOException e) {
      LOG.error("new HBaseActionManager in Subscriber error", e);
      return null;
    }
  }

  public Publisher build(EntityGroupInfo entityGroupInfo,
      StorageActionManager action) {
    return new Publisher(entityGroupInfo, action);
  }
}
