/*
 * Copyright 2020 Google LLC
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package com.google.cloud.healthcare.fdamystudies.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorBean {

  private Integer code = 0;
  private String message = "";
  private String siteId;

  public ErrorBean() {}

  public ErrorBean(Integer code, String msg) {
    this.code = code;
    this.message = msg;
  }
}
