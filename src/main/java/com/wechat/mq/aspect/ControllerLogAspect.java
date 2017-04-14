package com.wechat.mq.aspect;

import com.alibaba.fastjson.JSON;
import com.wechat.mq.annotation.ControllerLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * Created by akinoneko on 2017/4/14.
 */
@Aspect
@Component
public class ControllerLogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerLogAspect.class);

    //controller调用日志记录点
    @Pointcut("@annotation(com.wechat.mq.annotation.ControllerLog)")
    public void controllerMethodLog() {

    }

    @Before("controllerMethodLog()")
    public void doServiceBefore(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes()).getRequest();
        String ip = request.getRemoteAddr();
        String params = JSON.toJSONString(joinPoint.getArgs());
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = targetName + "." + joinPoint.getSignature().getName();
        StringBuilder message = new StringBuilder();
        try {
            message.append("\r\n=====Controller前置通知开始=====")
                    .append("\r\n请求方法:").append(methodName)
                    .append("\r\n请求参数:").append(params)
                    .append("\r\n请求描述:").append(getControllerMethodDescription(joinPoint))
                    .append("\r\n请求IP:").append(ip)
                    .append("\r\n=====Controller前置通知结束=====");
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Controller方法参数拦截打印:{}", message.toString());
            }
        } catch (Exception e) {
            LOGGER.error("异常信息:{}", e.getMessage());
        }
    }

    @Around("controllerMethodLog()")
    public Object doServiceAround(ProceedingJoinPoint joinPoint) throws Throwable {
        return joinPoint.proceed();
    }

    @After("controllerMethodLog()")
    public void doServiceAfter(JoinPoint joinPoint) {

    }

    /**
     * 解析注解中对于方法的描述信息
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == args.length) {
                    description = method.getAnnotation(ControllerLog.class).description();
                    break;
                }
            }
        }
        return description;
    }
}
