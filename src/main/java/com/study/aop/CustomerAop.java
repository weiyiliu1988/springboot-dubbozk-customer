package com.study.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author LIU
 *
 */

@Aspect
@Order(-1) // 控制多个Aspect的执行顺序，越小越先执行
@Component // 注册入IOC容器
public class CustomerAop {

	@Pointcut("execution(* com.study.controller.CustomerController.test(..))")
	public void pointCutAt() {

	}

	@Before("pointCutAt()")
	public void beforeMethod(JoinPoint jp) {
		System.out.println("beforeMethod");
		String methodName = jp.getSignature().getName();
		System.out.println(methodName);

	}

	@AfterReturning(pointcut = "pointCutAt()", returning = "result")
	public void AfterMethod(JoinPoint jp, Object result) {
		System.out.println("AfterMethod");
		String methodName = jp.getSignature().getName();
		System.out.println(methodName);
		System.out.println("result--->" + result);
	}

}
