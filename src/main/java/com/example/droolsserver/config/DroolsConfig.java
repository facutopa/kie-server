package com.example.droolsserver.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {

    @Bean
    public KieContainer kieContainer() {
        System.out.println("=== CONFIGURANDO DROOLS ===");
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        
        // Cargar reglas desde el classpath
        System.out.println("Cargando reglas desde: rules/reglas.drl");
        kieFileSystem.write("src/main/resources/rules/reglas.drl", 
            kieServices.getResources().newClassPathResource("rules/reglas.drl"));
        
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        System.out.println("Compilando reglas...");
        kieBuilder.buildAll();
        
        if (kieBuilder.getResults().hasMessages(org.kie.api.builder.Message.Level.ERROR)) {
            System.out.println("ERRORES EN REGLAS:");
            kieBuilder.getResults().getMessages(org.kie.api.builder.Message.Level.ERROR).forEach(System.out::println);
        } else {
            System.out.println("Reglas compiladas correctamente");
        }
        
        KieModule kieModule = kieBuilder.getKieModule();
        KieContainer container = kieServices.newKieContainer(kieModule.getReleaseId());
        System.out.println("KieContainer creado exitosamente");
        return container;
    }

    @Bean
    public KieSession kieSession() {
        return kieContainer().newKieSession();
    }
}
