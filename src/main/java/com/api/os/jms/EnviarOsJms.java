package com.api.os.jms;

import com.api.os.dominios.OrdemServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class EnviarOsJms {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void enviarOs(OrdemServico ordemServico){
        jmsTemplate.convertAndSend("ordemServico", ordemServico);
    }
}
