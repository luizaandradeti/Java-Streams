package com.luiza.pedidos.controller;


import com.luiza.pedidos.dto.PedidoRequestDto;
import com.luiza.pedidos.dto.PedidoResponseDto;
import com.luiza.pedidos.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private PedidoService  pedidoService;

public ResponseEntity<PedidoResponseDto> criar(@RequestBody PedidoRequestDto pedidoRequestDto) {
    PedidoResponseDto responseDto = pedidoService.criar(pedidoRequestDto);
    return new ResponseEntity<>(responseDto, HttpStatus.CREATED);


}}
