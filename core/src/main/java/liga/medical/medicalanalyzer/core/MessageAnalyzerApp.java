package liga.medical.medicalanalyzer.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"liga.medical.medicalanalyzer", "liga.medical.common"})
public class MessageAnalyzerApp {
    public static void main(String[] args) {
        SpringApplication.run(MessageAnalyzerApp.class, args);
    }
}
