package com.realstate.service;

import com.realstate.payload.AgentDto;

import java.util.List;

public interface AgentService {


    AgentDto createAgent(AgentDto agentDto, int clientId);
    List<AgentDto> findAllAgents();
}
