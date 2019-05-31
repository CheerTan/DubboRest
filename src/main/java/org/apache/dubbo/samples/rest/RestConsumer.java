/*
 *
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
package org.apache.dubbo.samples.rest;

import com.alibaba.fastjson.JSON;
import com.awifi.core.coreservice.dbc.merchantbase.service.MerchantBaseService;
//import com.awifi.core.coreservice.dbc.merchantbase.service.facade.MerchantBaseRestService;
import com.awifi.core.coreservice.dbc.merchantbase.service.MerchantHotareaService;
import com.awifi.core.coreservice.dbc.merchantdevice.service.MerchantDeviceQueryService;
import org.apache.dubbo.samples.rest.api.facade.AnotherUserRestService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class RestConsumer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/rest-consumer.xml"});
        context.start();
        //AnotherUserRestService userService = (AnotherUserRestService) context.getBean("anotherUserRestService");
        MerchantBaseService merchantBaseRestService=(MerchantBaseService) context.getBean("merchantBaseService", MerchantBaseService.class);
        //MerchantHotareaService merchantHotareaService=(MerchantHotareaService)context.getBean("MerchantHotareaService",MerchantHotareaService.class);
        MerchantDeviceQueryService merchantDeviceQueryService=(MerchantDeviceQueryService)context.getBean("MerchantDeviceQueryService",MerchantDeviceQueryService.class);
//        User user = new User(1L, "larrypage");
//        System.out.println("SUCCESS: registered user with id " + userService.registerUser(user).getId());
//
//        RpcContext.getContext().setAttachment("clientName", "demo");
//        RpcContext.getContext().setAttachment("clientImpl", "dubbo");
//        System.out.println("SUCCESS: got user " + userService.getUser(1L));
//        System.in.read();
        Map<String, Object> params = new HashMap();
        params.put("id", 1);

        String res="2";
        String re="1";
        res=merchantBaseRestService.queryById(JSON.toJSONString(params));
        re=merchantDeviceQueryService.queryMerInfoByDevId(JSON.toJSONString(params));
        //re=merchantHotareaService.queryById(JSON.toJSONString(params));
        System.out.println(res);
    }
    

}