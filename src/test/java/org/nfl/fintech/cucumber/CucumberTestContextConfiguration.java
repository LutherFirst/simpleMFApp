package org.nfl.fintech.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.nfl.fintech.SimpleMfApp;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = SimpleMfApp.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
