package ru.kpfu.gerasimov.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.kpfu.gerasimov.dto.UserDto;

import java.util.Optional;


@Component
@Aspect
public class LoggingAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(Loggable)")
    public void logCityRequest() {

    }

    @Around("logCityRequest()")
    public Object logAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Optional<String> city = (Optional<String>) proceedingJoinPoint.getArgs()[0];

        Object result = proceedingJoinPoint.proceed();

        LOGGER.info("City request: {}", city.get());

        return result;
    }
}