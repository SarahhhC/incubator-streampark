/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.streampark.console.core.service.application;

import org.apache.streampark.common.enums.FlinkExecutionMode;
import org.apache.streampark.console.base.domain.RestRequest;
import org.apache.streampark.console.core.entity.Application;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * The ApplicationManageService interface provides methods to manage applications information. It
 * extends the IService interface with the Application entity.
 */
public interface ApplicationManageService extends IService<Application> {

  /**
   * Retrieves a page of applications based on the provided parameters.
   *
   * @param appParam The application object to be used for filtering the results.
   * @param request The REST request object containing additional parameters or headers.
   * @return A page of Application objects based on the provided parameters.
   */
  IPage<Application> page(Application appParam, RestRequest request);

  /**
   * Creates a new application.
   *
   * @param appParam The application to create.
   * @return True if the application was successfully created, false otherwise.
   * @throws IOException If an I/O error occurs.
   */
  boolean create(Application appParam) throws IOException;

  /**
   * Copies the given Application.
   *
   * @param appParam the Application to be copied
   * @return the size of the copied Application in bytes as a Long value
   * @throws IOException if there was an error during the copy process
   */
  Long copy(Application appParam) throws IOException;

  /**
   * Updates the given application.
   *
   * @param appParam the application to be updated
   * @return true if the update was successful, false otherwise
   */
  boolean update(Application appParam);

  /**
   * Sets the given application to be effective.
   *
   * @param appParam the application to be set effective
   */
  void toEffective(Application appParam);

  /**
   * Checks if the given application is ready to build and update.
   *
   * @param appParam the application to check for readiness
   * @return true if the application is ready to build and update, false otherwise
   */
  boolean checkBuildAndUpdate(Application appParam);

  /**
   * Deletes the given Application from the system.
   *
   * @param appParam The Application to be deleted.
   * @return True if the deletion was successful, false otherwise.
   */
  Boolean delete(Application appParam);

  /**
   * Retrieves the Application with the specified details from the system.
   *
   * @param appParam The Application object containing the details of the Application to retrieve.
   * @return The Application object that matches the specified details, or null if no matching
   *     Application is found.
   */
  Application getApp(Application appParam);

  /**
   * Updates the release of the given application.
   *
   * @param appParam The application to update the release for.
   */
  void updateRelease(Application appParam);

  /**
   * Cleans the application by performing necessary cleanup tasks.
   *
   * @param appParam The application to clean.
   */
  void clean(Application appParam);

  /**
   * Retrieves a list of applications by project ID.
   *
   * @param id The project ID to search for applications.
   * @return A list of applications associated with the project ID.
   */
  List<Application> getByProjectId(Long id);

  /**
   * Changes the ownership of all applications associated with a user.
   *
   * @param userId The ID of the user whose applications will be changed.
   * @param targetUserId The ID of the user who will become the new owner of the applications.
   */
  void changeOwnership(Long userId, Long targetUserId);

  /**
   * Retrieves a list of applications based on the specified team ID.
   *
   * @param teamId The ID of the team to retrieve the applications for.
   * @return A list of Application objects associated with the given team ID.
   */
  List<Application> getByTeamId(Long teamId);

  /**
   * Retrieves a list of applications by team ID and execution modes.
   *
   * @param teamId The ID of the team to filter by
   * @param executionModeEnums The collection of execution modes to filter by
   * @return A list of applications that belong to the specified team and have the specified
   *     execution modes
   */
  List<Application> getByTeamIdAndExecutionModes(
      Long teamId, Collection<FlinkExecutionMode> executionModeEnums);

  /**
   * Retrieves a list of applications be probing or need to probe.
   *
   * @return a list of applications be probing or need to probe.
   */
  List<Application> getProbeApps();
}
