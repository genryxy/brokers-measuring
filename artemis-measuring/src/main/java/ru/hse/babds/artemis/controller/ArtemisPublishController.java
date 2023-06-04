package ru.hse.babds.artemis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.hse.babds.artemis.model.Person;
import ru.hse.babds.artemis.service.ArtemisProducer;

@Controller
public class ArtemisPublishController {

    @Autowired
    ArtemisProducer artemisProducer;

    @GetMapping(value = "/produce")
    public String produceArtemis(@RequestParam(value = "msg", required = false) String msg) {
        msg = "ok";
        artemisProducer.send(msg);
        return "Done send msg: " + msg;
    }

    @PostMapping(value = "/produce")
    public ResponseEntity<String> produceArtemis(@RequestBody Person p) {
        artemisProducer.send(p);
        System.out.println("send person: " + p);
        return ResponseEntity.ok("person ok:" + p.toString());
    }
}
