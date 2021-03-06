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
package com.allen_sauer.gwt.log.server;

import com.allen_sauer.gwt.log.shared.LogRecord;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import java.util.Set;
import java.util.Map.Entry;

// CHECKSTYLE_JAVADOC_OFF
public final class ServerLogImplLog4J implements ServerLog {
  private final Logger logger;

  {
    logger = Logger.getLogger("gwt-log");
  }

  @Override
  public int getCurrentLogLevel() {
    return logger.getEffectiveLevel().toInt();
  }

  @Override
  public boolean isDebugEnabled() {
    return logger.isDebugEnabled();
  }

  @Override
  public boolean isErrorEnabled() {
    return logger.isEnabledFor(Level.ERROR);
  }

  @Override
  public boolean isFatalEnabled() {
    return logger.isEnabledFor(Level.FATAL);
  }

  @Override
  public boolean isInfoEnabled() {
    return logger.isEnabledFor(Level.INFO);
  }

  @Override
  public boolean isLoggingEnabled() {
    return logger.getLevel().toInt() >= Level.OFF_INT;
  }

  @Override
  public boolean isTraceEnabled() {
    return logger.isTraceEnabled();
  }

  @Override
  public boolean isWarnEnabled() {
    return logger.isEnabledFor(Level.WARN);
  }

  @Override
  public void log(LogRecord record) {
    Set<Entry<String, String>> set = record.getMapEntrySet();
    for (Entry<String, String> entry : set) {
      MDC.put(entry.getKey(), entry.getValue());
    }
    logger.log(Level.toLevel(mapGWTLogLevelToImplLevel(record.getLevel())), record.getMessage(),
        record.getThrowable());
    for (Entry<String, String> entry : set) {
      MDC.remove(entry.getKey());
    }
  }

  @Override
  public int mapGWTLogLevelToImplLevel(int gwtLogLevel) {
    return gwtLogLevel;
  }

  @Override
  public void setCurrentImplLogLevel(int level) {
    logger.setLevel(Level.toLevel(level));
  }

}
