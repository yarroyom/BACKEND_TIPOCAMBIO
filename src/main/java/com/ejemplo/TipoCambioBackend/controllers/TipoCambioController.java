/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.TipoCambioBackend.controllers;

import com.ejemplo.TipoCambioBackend.models.Solicitud;
import com.ejemplo.TipoCambioBackend.repositories.SolicitudRepository;
import com.ejemplo.TipoCambioBackend.services.TipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/tipoCambio")
@CrossOrigin(origins = "http://localhost:3000")
public class TipoCambioController {

    private final TipoCambioService tipoCambioService;
    private final SolicitudRepository solicitudRepository;

    @Autowired
    public TipoCambioController(TipoCambioService tipoCambioService, SolicitudRepository solicitudRepository) {
        this.tipoCambioService = tipoCambioService;
        this.solicitudRepository = solicitudRepository;
    }

    @GetMapping("/actual")
    public ResponseEntity<String> obtenerTipoCambioActual() {
        String tipoCambio = tipoCambioService.obtenerYGuardarTipoCambio();
        return ResponseEntity.ok(tipoCambio);
    }

    @GetMapping("/historial")
    public ResponseEntity<List<Solicitud>> obtenerHistorial() {
        return ResponseEntity.ok(solicitudRepository.findAll());
    }
}
