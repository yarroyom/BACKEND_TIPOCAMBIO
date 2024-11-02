/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.TipoCambioBackend.interceptors;

import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.WebServiceMessage;

import java.io.IOException;

public class SoapActionInterceptor implements WebServiceMessageCallback {
    private final String soapAction;

    public SoapActionInterceptor(String soapAction) {
        this.soapAction = soapAction;
    }

    @Override
    public void doWithMessage(WebServiceMessage message) throws IOException {
        SoapMessage soapMessage = (SoapMessage) message;
        // Establecer el encabezado SOAPAction en el mensaje HTTP
        soapMessage.setSoapAction(soapAction);
    }
}
