package com.pluralsight.conference.controller;

import com.pluralsight.conference.model.Speaker;
import com.pluralsight.conference.service.SpeakerService;
import com.pluralsight.conference.service.SpeakerServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpeakerController {

    private SpeakerService speakerService;

    public SpeakerController(SpeakerService speakerService) {
        this.speakerService = speakerService;
    }

    @PutMapping
    public Speaker createSpeaker(@RequestBody Speaker speaker) {
        System.out.println("Name :" + speaker.getName());
        return speakerService.create(speaker);
    }

    @GetMapping
    public List<Speaker> getSpeakers() {
        return speakerService.findAll();
    }

    @GetMapping("/speaker/{id}")
    public Speaker getSpeaker(@PathVariable (value="id") int id) {
        return speakerService.getSpeaker(id);
    }

    @PutMapping("/speaker")
    public Speaker getSpeaker(@RequestBody Speaker speaker) {
        return speakerService.update(speaker);
    }
}
