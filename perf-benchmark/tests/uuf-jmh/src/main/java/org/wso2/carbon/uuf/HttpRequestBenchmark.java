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

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.wso2.carbon.uuf.internal.UUFServer;
import org.wso2.carbon.uuf.spi.HttpRequest;
import org.wso2.carbon.uuf.spi.HttpResponse;


import java.io.File;
import java.io.InputStream;
import java.util.Map;

public class HttpRequestBenchmark {


    @State(Scope.Benchmark)
    public static class httpRequestState {
        UUFServer us = new UUFServer();
    }


    @Benchmark
    public void testMethod(httpRequestState rs) {
        rs.us.serve(genHttpRequest(),genHttpResponse());
    }


    public HttpRequest genHttpRequest(){
        return new HttpRequest() {
            @Override
            public String getUrl() {
                return null;
            }

            @Override
            public String getMethod() {
                return null;
            }

            @Override
            public String getProtocol() {
                return null;
            }

            @Override
            public Map<String, String> getHeaders() {
                return null;
            }

            @Override
            public String getHostName() {
                return null;
            }

            @Override
            public String getCookieValue(String cookieName) {
                return null;
            }

            @Override
            public String getUri() {
                return null;
            }

            @Override
            public String getContextPath() {
                return null;
            }

            @Override
            public String getUriWithoutContextPath() {
                return null;
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

    public HttpResponse genHttpResponse(){
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
