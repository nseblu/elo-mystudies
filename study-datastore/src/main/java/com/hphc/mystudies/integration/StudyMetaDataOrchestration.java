/*
 * Copyright © 2017-2018 Harvard Pilgrim Health Care Institute (HPHCI) and its Contributors.
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do so, subject to the
 * following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 *
 * Funding Source: Food and Drug Administration ("Funding Agency") effective 18 September 2014 as Contract no.
 * HHSF22320140030I/HHSF22301006T (the "Prime Contract").
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package com.hphc.mystudies.integration;

import com.hphc.mystudies.bean.ConsentDocumentResponse;
import com.hphc.mystudies.bean.EligibilityConsentResponse;
import com.hphc.mystudies.bean.GatewayInfoResponse;
import com.hphc.mystudies.bean.ResourcesResponse;
import com.hphc.mystudies.bean.StudyInfoResponse;
import com.hphc.mystudies.bean.StudyResponse;
import com.hphc.mystudies.dao.StudyMetaDataDao;
import com.hphc.mystudies.exception.OrchestrationException;
import com.hphc.mystudies.util.StudyMetaDataUtil;
import java.util.HashMap;
import org.apache.log4j.Logger;

public class StudyMetaDataOrchestration {

  private static final Logger LOGGER = Logger.getLogger(StudyMetaDataOrchestration.class);

  @SuppressWarnings("unchecked")
  HashMap<String, String> propMap = StudyMetaDataUtil.getAppProperties();

  StudyMetaDataDao studyMetaDataDao = new StudyMetaDataDao();

  public boolean isValidAuthorizationId(String authorization) throws OrchestrationException {
    LOGGER.info("INFO: StudyMetaDataOrchestration - isValidAuthorizationId() :: Starts");
    boolean hasValidAuthorization = false;
    try {
      hasValidAuthorization = studyMetaDataDao.isValidAuthorizationId(authorization);
    } catch (Exception e) {
      LOGGER.error("StudyMetaDataOrchestration - isValidAuthorizationId() :: ERROR", e);
    }
    LOGGER.info("INFO: StudyMetaDataOrchestration - isValidAuthorizationId() :: Ends");
    return hasValidAuthorization;
  }

  public GatewayInfoResponse gatewayAppResourcesInfo(String authorization)
      throws OrchestrationException {
    LOGGER.info("INFO: StudyMetaDataOrchestration - gatewayAppResourcesInfo() :: Starts");
    GatewayInfoResponse gatewayInfo = new GatewayInfoResponse();
    try {
      gatewayInfo = studyMetaDataDao.gatewayAppResourcesInfo(authorization);
    } catch (Exception e) {
      LOGGER.error("StudyMetaDataOrchestration - gatewayAppResourcesInfo() :: ERROR", e);
    }
    LOGGER.info("INFO: StudyMetaDataOrchestration - gatewayAppResourcesInfo() :: Ends");
    return gatewayInfo;
  }

  public StudyResponse studyList(String authorization, String applicationId)
      throws OrchestrationException {
    LOGGER.info("INFO: StudyMetaDataOrchestration - studyList() :: Starts");
    StudyResponse studyResponse = new StudyResponse();
    try {
      studyResponse = studyMetaDataDao.studyList(authorization, applicationId);
    } catch (Exception e) {
      LOGGER.error("StudyMetaDataOrchestration - studyList() :: ERROR", e);
    }
    LOGGER.info("INFO: StudyMetaDataOrchestration - studyList() :: Ends");
    return studyResponse;
  }

  public EligibilityConsentResponse eligibilityConsentMetadata(String studyId)
      throws OrchestrationException {
    LOGGER.info("INFO: StudyMetaDataOrchestration - eligibilityConsentMetadata() :: Starts");
    EligibilityConsentResponse eligibilityConsentResponse = new EligibilityConsentResponse();
    try {
      eligibilityConsentResponse = studyMetaDataDao.eligibilityConsentMetadata(studyId);
    } catch (Exception e) {
      LOGGER.error("StudyMetaDataOrchestration - eligibilityConsentMetadata() :: ERROR", e);
    }
    LOGGER.info("INFO: StudyMetaDataOrchestration - eligibilityConsentMetadata() :: Ends");
    return eligibilityConsentResponse;
  }

  public ConsentDocumentResponse consentDocument(
      String studyId, String consentVersion, String activityId, String activityVersion)
      throws OrchestrationException {
    LOGGER.info("INFO: StudyMetaDataOrchestration - consentDocument() :: Starts");
    ConsentDocumentResponse consentDocumentResponse = new ConsentDocumentResponse();
    try {
      consentDocumentResponse =
          studyMetaDataDao.consentDocument(studyId, consentVersion, activityId, activityVersion);
    } catch (Exception e) {
      LOGGER.error("StudyMetaDataOrchestration - consentDocument() :: ERROR", e);
    }
    LOGGER.info("INFO: StudyMetaDataOrchestration - consentDocument() :: Ends");
    return consentDocumentResponse;
  }

  public ResourcesResponse resourcesForStudy(String studyId) throws OrchestrationException {
    LOGGER.info("INFO: StudyMetaDataOrchestration - resourcesForStudy() :: Starts");
    ResourcesResponse resourcesResponse = new ResourcesResponse();
    try {
      resourcesResponse = studyMetaDataDao.resourcesForStudy(studyId);
    } catch (Exception e) {
      LOGGER.error("StudyMetaDataOrchestration - resourcesForStudy() :: ERROR", e);
    }
    LOGGER.info("INFO: StudyMetaDataOrchestration - resourcesForStudy() :: Ends");
    return resourcesResponse;
  }

  public StudyInfoResponse studyInfo(String studyId) throws OrchestrationException {
    LOGGER.info("INFO: StudyMetaDataOrchestration - studyInfo() :: Starts");
    StudyInfoResponse studyInfoResponse = new StudyInfoResponse();
    try {
      studyInfoResponse = studyMetaDataDao.studyInfo(studyId);
    } catch (Exception e) {
      LOGGER.error("StudyMetaDataOrchestration - studyInfo() :: ERROR", e);
    }
    LOGGER.info("INFO: StudyMetaDataOrchestration - studyInfo() :: Ends");
    return studyInfoResponse;
  }

  public boolean isValidStudy(String studyId) throws OrchestrationException {
    LOGGER.info("INFO: StudyMetaDataOrchestration - isValidStudy() :: Starts");
    boolean flag = false;
    try {
      flag = studyMetaDataDao.isValidStudy(studyId);
    } catch (Exception e) {
      LOGGER.error("StudyMetaDataOrchestration - isValidStudy() :: ERROR", e);
    }
    LOGGER.info("INFO: StudyMetaDataOrchestration - isValidStudy() :: Ends");
    return flag;
  }

  public boolean isValidActivity(String activityId, String studyId, String activityVersion)
      throws OrchestrationException {
    LOGGER.info("INFO: StudyMetaDataOrchestration - isValidActivity() :: Starts");
    boolean flag = false;
    try {
      flag = studyMetaDataDao.isValidActivity(activityId, studyId, activityVersion);
    } catch (Exception e) {
      LOGGER.error("StudyMetaDataOrchestration - isValidActivity() :: ERROR", e);
    }
    LOGGER.info("INFO: StudyMetaDataOrchestration - isValidActivity() :: Ends");
    return flag;
  }

  public boolean isActivityTypeQuestionnaire(
      String activityId, String studyId, String activityVersion) throws OrchestrationException {
    LOGGER.info("INFO: StudyMetaDataOrchestration - isActivityTypeQuestionnaire() :: Starts");
    boolean flag = false;
    try {
      flag = studyMetaDataDao.isActivityTypeQuestionnaire(activityId, studyId, activityVersion);
    } catch (Exception e) {
      LOGGER.error("StudyMetaDataOrchestration - isActivityTypeQuestionnaire() :: ERROR", e);
    }
    LOGGER.info("INFO: StudyMetaDataOrchestration - isActivityTypeQuestionnaire() :: Ends");
    return flag;
  }

  public boolean isValidToken(String token) throws OrchestrationException {
    LOGGER.info("INFO: StudyMetaDataOrchestration - isValidToken() :: Starts");
    boolean flag = false;
    try {
      flag = studyMetaDataDao.isValidToken(token);
    } catch (Exception e) {
      LOGGER.error("StudyMetaDataOrchestration - isValidToken() :: ERROR", e);
    }
    LOGGER.info("INFO: StudyMetaDataOrchestration - isValidToken() :: Ends");
    return flag;
  }

  public StudyResponse study(String studyId) throws OrchestrationException {
    LOGGER.info("INFO: StudyMetaDataOrchestration - study() :: Starts");
    StudyResponse studyResponse = new StudyResponse();
    try {
      studyResponse = studyMetaDataDao.study(studyId);
    } catch (Exception e) {
      LOGGER.error("StudyMetaDataOrchestration - study() :: ERROR", e);
    }
    LOGGER.info("INFO: StudyMetaDataOrchestration - study() :: Ends");
    return studyResponse;
  }
}
