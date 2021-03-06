package com.harvard.studyappmodule.studymodel;

import io.realm.RealmObject;

public class StudySetting extends RealmObject {
  private boolean enrolling;
  private String platform;
  private boolean rejoin;

  public boolean isEnrolling() {
    return enrolling;
  }

  public void setEnrolling(boolean enrolling) {
    this.enrolling = enrolling;
  }

  public String getPlatform() {
    return platform;
  }

  public void setPlatform(String platform) {
    this.platform = platform;
  }

  public boolean getRejoin() {
    return rejoin;
  }

  public void setRejoin(boolean rejoin) {
    this.rejoin = rejoin;
  }
}
