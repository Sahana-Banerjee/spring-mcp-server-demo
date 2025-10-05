package com.study.spring.ai.mcp_demo.service.impl;

import com.study.spring.ai.mcp_demo.service.McpDemoService;
import com.study.spring.ai.mcp_demo.service.PersonDetails;
import jakarta.annotation.PostConstruct;
import org.springframework.ai.tool.annotation.Tool;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class McpDemoServiceImpl implements McpDemoService {

    List<PersonDetails> personDetailsList = new ArrayList<>();

    @Tool(name = "dmcp_get_personal_details", description = "This tool aims to fetch personal details")
    @Override
    public List<PersonDetails> getPersonDetails() {
        return personDetailsList;
    }

    @Tool(name = "dmcp_filter_person_detail", description = "This tool aims to fetch personal details of a specifc person")
    @Override
    public PersonDetails getPersonDetailsByName(String name) {
        return personDetailsList.stream().filter(p -> p.name().equalsIgnoreCase(name))
                .findAny()
                .orElse(null);
    }

    @PostConstruct
    public void init(){
        personDetailsList.addAll(List.of(
                new PersonDetails("Sahana", "A working mom and full time learner and SWE"),
                new PersonDetails("Sourav", "A working dad and full time SWE")
        ));
    }
}
