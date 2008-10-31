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
package com.allen_sauer.gwt.log.client.util;

import com.allen_sauer.gwt.log.client.ServerSideLog;

//CHECKSTYLE_JAVADOC_OFF
public class ServerSideLogUtil {
  private static final String LOG_LEVEL_TEXT_DEBUG = "DEBUG";
  private static final String LOG_LEVEL_TEXT_ERROR = "ERROR";
  private static final String LOG_LEVEL_TEXT_FATAL = "FATAL";
  private static final String LOG_LEVEL_TEXT_INFO = "INFO";
  private static final String LOG_LEVEL_TEXT_OFF = "OFF";
  private static final String LOG_LEVEL_TEXT_WARN = "WARN";

  public static String levelToString(int level) {
    switch (level) {
      case ServerSideLog.LOG_LEVEL_DEBUG:
        return LOG_LEVEL_TEXT_DEBUG;
      case ServerSideLog.LOG_LEVEL_INFO:
        return LOG_LEVEL_TEXT_INFO;
      case ServerSideLog.LOG_LEVEL_WARN:
        return LOG_LEVEL_TEXT_WARN;
      case ServerSideLog.LOG_LEVEL_ERROR:
        return LOG_LEVEL_TEXT_ERROR;
      case ServerSideLog.LOG_LEVEL_FATAL:
        return LOG_LEVEL_TEXT_FATAL;
      case ServerSideLog.LOG_LEVEL_OFF:
        return LOG_LEVEL_TEXT_OFF;
      default:
        throw new IllegalArgumentException();
    }
  }
}
