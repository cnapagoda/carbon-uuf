/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.wso2.carbon.uuf;

import org.openjdk.jmh.annotations.Benchmark;
import org.wso2.carbon.uuf.internal.UUFServer;
import org.wso2.carbon.uuf.spi.HttpRequest;
import org.wso2.carbon.uuf.spi.HttpResponse;
import org.wso2.carbon.uuf.api.ServerConnection;


import java.io.File;
import java.io.InputStream;
import java.util.Map;

public class HttpRequestBenchmark {

    @Benchmark
    public void testMethod() {
        UUFServer us = new UUFServer();

        //us.serve(genHttpRequest(),genHttpResponse());
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
