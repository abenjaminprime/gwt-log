@java -cp "%~dp0\src;%~dp0\getting-started;%~dp0\bin;%GWT_HOME%/gwt-user.jar;%GWT_HOME%/gwt-dev-windows.jar" com.google.gwt.dev.GWTCompiler -out "%~dp0\www" -style PRETTY %* com.mycompany.MyApplication