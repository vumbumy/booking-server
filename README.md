# Booking Server (REST) Skeleton for Java

This ia a reference implementation for API v3 Booking server based on:

*   [google-protobuf](https://developers.google.com/protocol-buffers/docs/overview)
*   [Jersey RESTful Web Services](https://jersey.github.io/)

### Prerequisites

Require installations of

*   [Apache Maven](https://maven.apache.org/)
*   [Protocol compiler for java](https://github.com/google/protobuf)
*   [Apache Tomcat](http://tomcat.apache.org/)

### Get Started

1.  Copy the [Proto
    Interface](https://developers.google.com/maps-booking/reference/rest-api-v3/proto-bundle)
    into a proto file (api_v3.proto). Modify the package to match your project
    (com.partner.mapsbooking.v3.model).

    * If implementing waitlist functionality, repeat the same steps with the
    [Waitlist Proto Interface](https://developers.google.com/maps-booking/reference/rest-api-v3/waitlists/proto-bundle)

2.  Create a web application project in your IDE named booking_server_v3, add
    Maven support to this project.

3.  Place your proto file under the **src/main/resources,** add dependencies for
    Jersey and protocol buffers runtime to the Maven **pom.xml** file:

             <dependencyManagement>
                 <dependencies>
                     <dependency>
                         <groupId>org.glassfish.jersey</groupId>
                         <artifactId>jersey-bom</artifactId>
                         <version>${jersey.version}</version>
                         <type>pom</type>
                         <scope>import</scope>
                     </dependency>
                 </dependencies>
             </dependencyManagement>

             <dependencies>
                 <dependency>
                     <groupId>org.glassfish.jersey.containers</groupId>
                     <artifactId>jersey-container-servlet-core</artifactId>
                 </dependency>
                 <dependency>
                     <groupId>org.glassfish.jersey.media</groupId>
                     <artifactId>jersey-media-json-jackson</artifactId>
                     <version>2.27</version>
                 </dependency>
                 <dependency>
                     <groupId>com.google.protobuf</groupId>
                     <artifactId>protobuf-java</artifactId>
                     <version>3.5.1</version>
                 </dependency>
                 <dependency>
                     <groupId>io.grpc</groupId>
                     <artifactId>grpc-protobuf</artifactId>
                     <version>1.11.0</version>
                 </dependency>
             </dependencies>

             <properties>
                 <java.version>1.8</java.version>
                 <jersey.version>2.23.2</jersey.version>
             </properties>

4.  Execute the following command under **src/main** to auto-generate a source
    file for the classes defined in the proto file:

         protoc --java_out=java resources/api_v3.proto

    * If implementing waitlist functionality, also execute the following:
         protoc --java_out=java resources/waitlist.proto

5.  Inside of the **src/main/java,** create a new package matching your groupId
    (com.partner.mapsbooking). Retrieve the sample code from the repo:

         git clone https://maps-booking.googlesource.com/java-maps-booking-rest-server-v3-skeleton

    place the
    files under your package, follow the **TODOs** to complete your
    implementation.

6.  Configure your servlet by modifying the **web.xml** file:

        <?xml version="1.0" encoding="UTF-8"?>
        <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
                 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
                 version="4.0">

            <servlet>
                <servlet-name>Booking Rest Server</servlet-name>
                <servlet-class>org.glassfish.jersey.servlet.ServletContainer</servlet-class>
                <init-param>
                    <param-name>jersey.config.server.provider.packages</param-name>
                    <param-value>com.partner.mapsbooking</param-value>
                </init-param>
                <load-on-startup>1</load-on-startup>
            </servlet>

            <servlet-mapping>
                <servlet-name>Booking Rest Server</servlet-name>
                <url-pattern>/mapsbooking/*</url-pattern>
            </servlet-mapping>
        </web-app>

7.  In the Run Configurations, set up a Tomcat server configuration. Add all the
    jars to the /WEB_INF/lib directory (project structure -> artifacts -> After
    selecting all jars right click and choose "Put into /WEB-INF/lib").

8.  Run Tomcat to start your server.

### Final Directory Structure

      src
      |---main
          |---java
              |---com.partner.mapsbooking
                  |---rest
                      |---BookingService.java
                      |---BookingExceptionMapper.java
                      |---Error.java
                  |---authentication
                      |---AuthenticationService.java
                      |---RestAuthenticationFilter.java
                  |---v3.model
                      |---ApiV3.java
                      |---Waitlist.java
          |---resources
              |---api_v3.proto
              |---waitlist.proto
      |---test
