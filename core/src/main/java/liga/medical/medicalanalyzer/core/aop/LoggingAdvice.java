package liga.medical.medicalanalyzer.core.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.common.core.api.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {
    private final LogService logService;

    public LoggingAdvice(LogService logService) {
        this.logService = logService;
    }

    @Pointcut("@annotation(liga.medical.common.core.annotation.DbLog)")
    public void controllerPointcut() { }

    @Before("controllerPointcut()")
    public void controllerLogger(JoinPoint jp) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        String className = jp.getTarget().getClass().getName();
        String methodName = jp.getSignature().getName();
        Object[] arrayArgs = jp.getArgs();
        String methodArgs = objectMapper.writeValueAsString(arrayArgs);

        logService.logController(1, className, methodName, methodArgs);
    }
}
