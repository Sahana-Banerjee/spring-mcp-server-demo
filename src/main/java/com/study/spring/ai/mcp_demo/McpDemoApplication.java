package com.study.spring.ai.mcp_demo;

import com.study.spring.ai.mcp_demo.service.McpDemoService;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class McpDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpDemoApplication.class, args);
	}

	@Bean
	List<ToolCallback> dmcpTools(McpDemoService mcpDemoService){
		return List.of(ToolCallbacks.from(mcpDemoService));
	}
}
