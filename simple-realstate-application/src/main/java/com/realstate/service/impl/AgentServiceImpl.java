package com.realstate.service.impl;

import com.realstate.entity.Agent;
import com.realstate.entity.ClientReg;
import com.realstate.entity.ClientWish;
import com.realstate.entity.Rent;
import com.realstate.payload.AgentDto;
import com.realstate.payload.ClientRegDto;
import com.realstate.repository.AgentRepository;
import com.realstate.repository.ClientRegRepository;
import com.realstate.repository.RentRepository;
import com.realstate.service.AgentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private AgentRepository agentRepository;
    @Override
    public AgentDto createAgent(AgentDto agentDto, int clientId) {
        Rent rent = rentRepository.findById(clientId).get();
        Agent agent = mapToEntity(agentDto);
        agent.setRent(rent);
        Agent agent1 = agentRepository.save(agent);
        return mapToDto(agent1);
    }

    @Override
    public List<AgentDto> findAllAgents() {
        List<Agent> all = agentRepository.findAll();
        return  all.stream().map(agent->mapToDto(agent)).collect(Collectors.toList());
    }

    Agent mapToEntity(AgentDto agentDto){
        return mapper.map(agentDto, Agent.class);
    }

    AgentDto  mapToDto(Agent agent){
        return mapper.map(agent,AgentDto.class);
    }
}
