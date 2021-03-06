/**
 * Copyright 2010 The Apache Software Foundation
 *
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
package com.alibaba.wasp;

import com.alibaba.wasp.zookeeper.ZooKeeperWatcher;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Abortable;
import org.apache.hadoop.hbase.Stoppable;

/**
 * Defines the set of shared functions implemented by wasp servers (Masters
 * and FServers).
 */
public interface Server extends Abortable, Stoppable {
  /**
   * Gets the configuration object for this server.
   */
  public Configuration getConfiguration();

  /**
   * Gets the ZooKeeper instance for this server.
   */
  public ZooKeeperWatcher getZooKeeper();

  /**
   * @return The unique server name for this server.
   */
  public ServerName getServerName();
}