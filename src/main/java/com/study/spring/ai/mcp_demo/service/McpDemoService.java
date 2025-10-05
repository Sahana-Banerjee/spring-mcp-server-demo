package com.study.spring.ai.mcp_demo.service;

import java.util.List;

public interface McpDemoService {
    List<PersonDetails> getPersonDetails();
    PersonDetails getPersonDetailsByName(String name);
}
