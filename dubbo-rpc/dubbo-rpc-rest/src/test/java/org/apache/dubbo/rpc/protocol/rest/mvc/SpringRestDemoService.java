/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.rpc.protocol.rest.mvc;

import org.apache.dubbo.rpc.protocol.rest.User;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/demoService")
public interface SpringRestDemoService {
    @GetMapping(value = "/hello")
    Integer hello(@RequestParam Integer a, @RequestParam Integer b);

    @GetMapping(value = "/error")
    String error();

    @PostMapping(value = "/sayHello", consumes = MediaType.TEXT_PLAIN_VALUE)
    String sayHello(String name);

    boolean isCalled();

    @PostMapping(
            value = "/testFormBody",
    
           consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String testFormBody(@RequestBody User user);

    @PostMapping(
            value = "/testFormMapBody",
    
           consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    List<String> testFormMapBody(@RequestBody LinkedMultiValueMap map);

    @PostMapping(value = "/testHeader", consumes = MediaType.TEXT_PLAIN_VALUE)
    String testHeader(@RequestHeader String header);

    @GetMapping(value = "/testHeaderInt", consumes = MediaType.TEXT_PLAIN_VALUE)
    String testHeaderInt(@RequestHeader int header);

    @GetMapping(value = "/primitive")
    int primitiveInt(@RequestParam("a") int a, @RequestParam("b") int b);

    @GetMapping(value = "/primitiveLong")
    long primitiveLong(@RequestParam("a") long a, @RequestParam("b") Long b);

    @GetMapping(value = "/primitiveByte")
    long primitiveByte(@RequestParam("a") byte a, @RequestParam("b") Long b);

    @PostMapping(value = "/primitiveShort")
    long primitiveShort(@RequestParam("a") short a, @RequestParam("b") Long b, @RequestBody int c);
}
