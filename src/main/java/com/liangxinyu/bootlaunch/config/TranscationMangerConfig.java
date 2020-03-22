package com.liangxinyu.bootlaunch.config;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;


import javax.transaction.SystemException;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

@Configuration
public class TranscationMangerConfig {
    @Bean
    public UserTransaction userTransaction() throws SystemException {
        UserTransactionImp userTransactionImp = new UserTransactionImp();
        userTransactionImp.setTransactionTimeout(10000);
        return userTransactionImp;
    }
    @Bean(name="atomikosTranscation",initMethod = "init",destroyMethod = "close")
    public TransactionManager atomikosTranscation(){
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setForceShutdown(false);
        return  userTransactionManager;
    }
    @Bean(name="transactionManager")
    @DependsOn({"userTransaction","atomikosTranscation"})
    public PlatformTransactionManager transactionManager() throws Throwable {
        UserTransaction userTransaction = userTransaction();
        JtaTransactionManager manager = new JtaTransactionManager(userTransaction,atomikosTranscation());
        return manager;
    }

}
