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

/**
 * Logger which sends output via <code>$wnd.console.log()</code>
 * if <code>$wnd.console.log</code> is a function.
 */
public final class ConsoleLogger extends AbstractLogger {
  // CHECKSTYLE_JAVADOC_OFF

  public native boolean isSupported()
  /*-{
    return $wnd.console != null && !$wnd.console.firebug && typeof($wnd.console.log) == 'function';
  }-*/;

  @Override
  native void log(int logLevel, String message)
  /*-{
    $wnd.console.log(message);
  }-*/;
}
