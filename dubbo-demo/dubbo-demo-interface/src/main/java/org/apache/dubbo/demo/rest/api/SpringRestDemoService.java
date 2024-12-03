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
package org.apache.dubbo.demo.rest.api;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import po.User;

@RequestMapping("/spring/demo/service")
public interface SpringRestDemoService {

    @GetMapping(value = "/hello")
    Integer hello(@RequestParam("a") Integer a, @RequestParam("b") Integer b);

    @GetMapping(value = "/error")
    String error();

    @PostMapping(value = "/say")
    String sayHello(@RequestBody String name);

    @PostMapping(
    
           value = "/testFormBody",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Long testFormBody(@RequestBody Long number);

    @PostMapping(
    
           value = "/testJavaBeanBody",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    User testJavaBeanBody(@RequestBody User user);

    @GetMapping(value = "/primitive")
    int primitiveInt(@RequestParam("a") int a, @RequestParam("b") int b);

    @GetMapping(value = "/primitiveLong")
    long primitiveLong(@RequestParam("a") long a, @RequestParam("b") Long b);

    @GetMapping(value = "/primitiveByte")
    long primitiveByte(@RequestParam("a") byte a, @RequestParam("b") Long b);

    @PostMapping(value = "/primitiveShort")
    long primitiveShort(@RequestParam("a") short a, @RequestParam("b") Long b, @RequestBody int c);

    @GetMapping(value = "/testMapParam")
    String testMapParam(@RequestParam Map<String, String> params);

    @GetMapping(value = "/testMapHeader")
    String testMapHeader(@RequestHeader Map<String, String> headers);

    @PostMapping(
    
           value = "/testMapForm",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    List<String> testMapForm(MultiValueMap<String, String> params);

    @GetMapping(value = "/headerInt")
    int headerInt(@RequestHeader("header") int header);
}
