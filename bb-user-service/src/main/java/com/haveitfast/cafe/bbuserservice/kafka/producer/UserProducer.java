/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

//package com.haveitfast.cafe.bbuserservice.kafka.producer;
//
//import com.haveitfast.cafe.bbuserservice.bean.user.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserProducer {
//
//    private static final Logger logger = LoggerFactory.getLogger(UserProducer.class);
//    private static final String TOPIC = "USER_TOPIC";
//
//    @Autowired
//    private KafkaTemplate<String,Object> kafkaTemplate;
//
//    public void sendMessage(Object obj){
//        logger.info("Sending msg to Kafka topic:"+TOPIC);
//        kafkaTemplate.send(TOPIC, obj);
//    }
//}
