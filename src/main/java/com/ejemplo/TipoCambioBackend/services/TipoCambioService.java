/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.ejemplo.TipoCambioBackend.services;
import com.ejemplo.TipoCambioBackend.models.Solicitud;
import com.ejemplo.TipoCambioBackend.repositories.SolicitudRepository;
import com.ejemplo.TipoCambioBackend.interceptors.SoapActionInterceptor; // Importa el interceptor
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringSource;
import javax.xml.transform.*;
import java.io.StringWriter;
import java.time.LocalDateTime;
import javax.xml.transform.stream.StreamResult;

@Service
public class TipoCambioService {

    private final WebServiceTemplate webServiceTemplate;
    private final SolicitudRepository solicitudRepository;

    @Autowired
    public TipoCambioService(WebServiceTemplate webServiceTemplate, SolicitudRepository solicitudRepository) {
        this.webServiceTemplate = webServiceTemplate;
        this.solicitudRepository = solicitudRepository;
    }

   public String obtenerYGuardarTipoCambio() {
    // SOAP request
    String requestXml = "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
            "<Body>" +
            "<TipoCambioDiaString xmlns=\"http://www.banguat.gob.gt/variables/ws/\"/>" +
            "</Body>" +
            "</Envelope>";
    Source requestPayload = new StringSource(requestXml);

    // Establecer el encabezado SOAPAction
    String soapAction = "http://www.banguat.gob.gt/variables/ws/TipoCambioDiaString"; // Asegúrate de usar la acción correcta

    String responsePayload = webServiceTemplate.sendSourceAndReceive(requestPayload,
            new SoapActionInterceptor(soapAction), // Usar el interceptor aquí
            source -> {
                StringWriter writer = new StringWriter();
                TransformerFactory.newInstance().newTransformer().transform(source, new StreamResult(writer));
                return writer.toString();
            });

    Solicitud solicitud = new Solicitud();
    solicitud.setTipoCambio(responsePayload);
    solicitud.setFechaSolicitud(LocalDateTime.now());
    solicitudRepository.save(solicitud);

    return responsePayload;
}
}
