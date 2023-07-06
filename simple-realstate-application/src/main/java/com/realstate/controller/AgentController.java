package com.realstate.controller;


import com.realstate.payload.AgentDto;
import com.realstate.payload.PropertyDto;
import com.realstate.service.AgentService;
import com.realstate.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class AgentController {

    //http://localhost:8080/api/rent/{rentClientId}/agent
    @Autowired
    private AgentService agentService;

    @PostMapping("/rent/{rentClientId}/agent")
    public ResponseEntity<AgentDto> createAgent( @RequestBody AgentDto agentDto, @PathVariable("rentClientId") int rentClientId) {

        AgentDto dto = agentService.createAgent(agentDto, rentClientId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }

    @GetMapping("/agents")
    public List<AgentDto> findAllAgents() {
        List<AgentDto> allAgents = agentService.findAllAgents();
        return allAgents;

    }
}
