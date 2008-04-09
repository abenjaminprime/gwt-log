/*
 * Copyright 2008 Fred Sauer
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.allen_sauer.gwt.log.client;

import java.io.Serializable;

// CHECKSTYLE_JAVADOC_OFF
@SuppressWarnings("serial")
public class ClientStackTraceElement implements Serializable {
  private String declaringClass;
  private String fileName;
  private int lineNumber;
  private String methodName;

  ClientStackTraceElement(String declaringClass, String methodName, String fileName, int lineNumber) {
    this.declaringClass = declaringClass;
    this.methodName = methodName;
    this.fileName = fileName;
    this.lineNumber = lineNumber;
  }

  @SuppressWarnings("unused")
  private ClientStackTraceElement() {
  }

  public String getClassName() {
    return declaringClass;
  }

  public String getFileName() {
    return fileName;
  }

  public int getLineNumber() {
    return lineNumber;
  }

  public String getMethodName() {
    return methodName;
  }
}
