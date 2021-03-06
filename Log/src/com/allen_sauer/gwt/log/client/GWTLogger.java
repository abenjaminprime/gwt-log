/*
 * Copyright 2009 Fred Sauer
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

import com.google.gwt.core.client.GWT;

import com.allen_sauer.gwt.log.shared.LogRecord;

/**
 * Logger which outputs to {@link GWT#log(String, Throwable)}.
 */
public final class GWTLogger implements Logger {
  // CHECKSTYLE_JAVADOC_OFF

  @Override
  public void clear() {
  }

  @Override
  public boolean isSupported() {
    return !GWT.isScript();
  }

  @Override
  public void log(LogRecord record) {
    GWT.log(record.getFormattedMessage(), record.getThrowable());
  }

  @Override
  public void setCurrentLogLevel(int level) {
  }
}
