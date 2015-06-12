Place the following `log4j.xml` file into your `tomcat/lib` directory.  Feel free to tweak as necessary.

```
  <?xml version="1.0" encoding="UTF-8" ?>
  <!DOCTYPE log4j:configuration SYSTEM "log4j.dtd">

  <log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">
      <appender name="CONSOLE" 
          class="org.apache.log4j.ConsoleAppender">
          <param name="Threshold" value="DEBUG"/>
          <layout class="org.apache.log4j.PatternLayout">
              <param name="ConversionPattern" value="[%p][%x] %m%n" />
          </layout>
      </appender>

      <appender name="FILE"
          class="org.apache.log4j.FileAppender">
          <param name="File" value="tomcat.log"/>
          <param name="Append" value="false"/>
          <layout class="org.apache.log4j.PatternLayout">
              <param name="ConversionPattern" value="%d %-5p [%c][%x] %m%n" />
          </layout>
      </appender>

      <appender name="ASYNC" class="org.apache.log4j.AsyncAppender">
          <appender-ref ref="FILE" />
      </appender>

      <category name="net.sf.ehcache">
          <priority value="WARN"/>
      </category>

      <category name="com.ibatis">
          <priority value="DEBUG"/>
      </category>

      <category name="org.springframework">
          <priority value="INFO"/>
      </category>

      <category name="org.apache">
          <priority value="INFO"/>
      </category>

      <category name="java.sql">
          <priority value="WARN"/>
      </category>

      <category name="com.playserengeti">
          <priority value="DEBUG"/>
      </category>

      <root>
          <priority value="DEBUG" />
          <appender-ref ref="ASYNC" />
      </root>
 </log4j:configuration>
```