/*
 *  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.wso2.carbon.uuf;

import org.openjdk.jmh.annotations.*;
import org.wso2.carbon.deployment.engine.Artifact;
import org.wso2.carbon.deployment.engine.exception.CarbonDeploymentException;
import org.wso2.carbon.uuf.api.ServerConnection;
import org.wso2.carbon.uuf.renderablecreator.hbs.internal.HbsRenderableCreator;

import org.wso2.carbon.uuf.internal.UUFServer;
import org.wso2.carbon.uuf.internal.io.ArtifactAppDeployer;
import org.wso2.carbon.uuf.spi.HttpRequest;
import org.wso2.carbon.uuf.spi.HttpResponse;
import org.wso2.carbon.uuf.spi.HttpConnector;

import java.io.File;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HttpRequestBenchmark {

    /*
    * Scope.Benchmark: All threads running the benchmark share the same state object.
    */
    @State(Scope.Benchmark)
    public static class httpRequestState {
        UUFServer us = new UUFServer();
        HttpConnector connector;
        ServerConnection serverConnection;

        /*
        * Level.Trial :The method is called once for each time for each full run of the benchmark.
        * A full run means a full "fork" including all warm-up and benchmark iterations.
        */
        @Setup(Level.Trial)
        public void doSetup() {
            connector = new HttpConnector() {
                private ServerConnection serverConnection;

                @Override
                public void setServerConnection(ServerConnection serverConnection) {
                    this.serverConnection = serverConnection;
                }

                @Override
                public ServerConnection getServerConnection() {
                    return serverConnection;
                }

/*                public void servePage() {
                    HttpRequest request = genHttpRequest();
                    HttpResponse response = genHttpResponse();
                    us.setHttpConnector(connector);
                    serverConnection = connector.getServerConnection();
                    serverConnection.serve(request,response);
                    //response.getContent();
                }*/

            };

/*            System.setProperty("carbon.home","");
            us.setHttpConnector(connector);
            serverConnection = connector.getServerConnection();

            ArtifactAppDeployer deployer = new ArtifactAppDeployer();
            deployer.setRenderableCreator(new HbsRenderableCreator());
            us.setUUFAppRegistry(deployer);
            try {
                File file = new File("org.wso2.carbon.uuf.sample.pets-store-1.0.0-SNAPSHOT.zip");
                //System.out.print("file exists: " + file.exists() + " path: " + file.getAbsolutePath());
                deployer.deploy(new Artifact(file));
                deployer.getApp("/pets-store");
            } catch (CarbonDeploymentException e) {
                e.printStackTrace();
            }*/
        }

        @TearDown(Level.Trial)
        public void doTearDown() {
            connector.setServerConnection(null);
        }

    }

    /*
    * Mode.Throughput: Measures the number of operations per second, meaning the number of times per second your benchmark method
    * could be executed.
    * @OutputTimeUnit: actual time unit to use
    * */
    @Benchmark @BenchmarkMode(Mode.Throughput) @OutputTimeUnit(TimeUnit.SECONDS)
    public void testMethod(httpRequestState rs) {
        HttpRequest request = genHttpRequest();
        HttpResponse response = genHttpResponse();

        //HttpResponse res =  rs.serverConnection.serve(request, response);
       // System.out.println(res.getContent().toString());
    }

    // Generate HTTP Request
    public static HttpRequest genHttpRequest(){
        return new HttpRequest() {
            @Override
            public String getUrl() {
                return "http://localhost:9090/pets-store/";
            }

            @Override
            public String getMethod() {
                return "GET";
            }

            @Override
            public String getProtocol() {
                return "HTTP/1.1";
            }

            @Override
            public Map<String, String> getHeaders() {
                return null;
            }

            @Override
            public String getHostName() {
                return "localhost:9090";
            }

            @Override
            public String getCookieValue(String cookieName) {
                return null;
            }

            @Override
            public String getUri() {
                return "/pets-store/";
            }

            @Override
            public String getContextPath() {
                return "/pets-store";
            }

            @Override
            public String getUriWithoutContextPath() {
                return "/";
            }

            @Override
            public String getQueryString() {
                return null;
            }

            @Override
            public Map<String, Object> getQueryParams() {
                return null;
            }

            @Override
            public String getContentType() {
                return null;
            }

            @Override
            public Map<String, Object> getFormParams() {
                return null;
            }

            @Override
            public Map<String, Object> getFiles() {
                return null;
            }

            @Override
            public long getContentLength() {
                return 0;
            }

            @Override
            public boolean isSecure() {
                return false;
            }

            @Override
            public String getRemoteAddr() {
                return null;
            }

            @Override
            public int getLocalPort() {
                return 0;
            }
        };
    }

    // Generate HTTP Response
    public static HttpResponse genHttpResponse(){
        return new HttpResponse() {
            @Override
            public void setStatus(int statusCode) {

            }

            @Override
            public int getStatus() {
                return 0;
            }

            @Override
            public void setContent(String content, String contentType) {

            }

            @Override
            public void setContent(File content) {

            }

            @Override
            public void setContent(File content, String contentType) {

            }

            @Override
            public void setContent(Object content, String contentType) {

            }

            @Override
            public void setContent(InputStream content, String contentType) {

            }

            @Override
            public Object getContent() {
                return null;
            }

            @Override
            public void setContentType(String type) {

            }

            @Override
            public String getContentType() {
                return null;
            }

            @Override
            public void setHeader(String name, String value) {

            }

            @Override
            public Map<String, String> getHeaders() {
                return null;
            }
        };
    }

}
