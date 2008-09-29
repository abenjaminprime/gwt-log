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

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

/**
 * Logger which sends output via RPC to the server where it
 * can be logged and aggregated.
 * 
 * TODO optimize RPC round trips; at a minimum try to combine multiple messages at once
 */
public final class RemoteLogger extends AbstractLogger {
  // CHECKSTYLE_JAVADOC_OFF

  private final AsyncCallback<Object> callback;
  private RuntimeException failure;
  private final RemoteLoggerServiceAsync service;

  public RemoteLogger() {
    service = (RemoteLoggerServiceAsync) GWT.create(RemoteLoggerService.class);
    final ServiceDefTarget target = (ServiceDefTarget) service;
    target.setServiceEntryPoint(GWT.getModuleBaseURL() + "gwt-log");

    callback = new AsyncCallback<Object>() {
      public void onFailure(Throwable ex) {
        if (failure == null) {
          failure = new RuntimeException(
              "Remote logging will be suspended due to communication failure with "
                  + service.getClass().getName() + " at " + target.getServiceEntryPoint(), ex);
        }
      }

      public void onSuccess(Object result) {
      }
    };
  }

  @Override
  public void clear() {
    // do nothing on the server
  }

  @Override
  public void debug(String message, Throwable throwable) {
    if (failure != null) {
      throw failure;
    }
    service.debug(message, new WrappedClientThrowable(throwable), callback);
  }

  @Override
  public void diagnostic(String message, Throwable throwable) {
    if (failure != null) {
      throw failure;
    }
    service.diagnostic(message, new WrappedClientThrowable(throwable), callback);
  }

  @Override
  public void error(String message, Throwable throwable) {
    if (failure != null) {
      throw failure;
    }
    service.error(message, new WrappedClientThrowable(throwable), callback);
  }

  @Override
  public void fatal(String message, Throwable throwable) {
    if (failure != null) {
      throw failure;
    }
    service.fatal(message, new WrappedClientThrowable(throwable), callback);
  }

  @Override
  public void info(String message, Throwable throwable) {
    if (failure != null) {
      throw failure;
    }
    service.info(message, new WrappedClientThrowable(throwable), callback);
  }

  public boolean isSupported() {
    return true;
  }

  @Override
  public void trace(String message, Throwable throwable) {
    if (failure != null) {
      throw failure;
    }
    service.trace(message, new WrappedClientThrowable(throwable), callback);
  }

  @Override
  public void warn(String message, Throwable throwable) {
    if (failure != null) {
      throw failure;
    }
    service.warn(message, new WrappedClientThrowable(throwable), callback);
  }

  @Override
  void log(int logLevel, String message) {
    assert false;
    // Method never called
  }
}
