package ru.hse.babds.artemis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.hse.babds.artemis.model.Person;
import ru.hse.babds.artemis.service.ArtemisProducer;

@Controller
public class PublishController {

    @Autowired
    ArtemisProducer artemisProducer;

    @RequestMapping(value = "/produce")
    public String produceArtemis(@RequestParam(value = "msg", required = false) String msg) {
        msg = "ok";
        artemisProducer.send(msg);
        return "Done send msg: " + msg;
    }

    @RequestMapping(value = "/produce", method = RequestMethod.POST)
    public String produceArtemis(@RequestBody Person p) {
        artemisProducer.send(p);
        System.out.println("send person: " + p);
        return "Send Person Done" + p.toString();
    }
}
