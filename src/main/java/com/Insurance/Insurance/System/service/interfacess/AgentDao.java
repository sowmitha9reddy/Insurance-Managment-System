package com.Insurance.Insurance.System.service.interfacess;

import com.Insurance.Insurance.System.dto.AgentDto;

import java.util.List;

public interface AgentDao {

    public AgentDto addAgent(AgentDto agentDto);

    public AgentDto getAgent(long id);

    public List<AgentDto> getAllAgents() ;


    public AgentDto updateAgent(long id, AgentDto agentDto) ;

    public  void deleteAgent(long id) ;

    public  void deleteAllAgents();
}
