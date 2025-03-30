package com.tiendas.andy.Services.Impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadopago.client.preference.*;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import com.tiendas.andy.Dtos.Request.Articulos;
import com.tiendas.andy.Dtos.Request.MercadoPagoRequest;
import com.tiendas.andy.Services.ArticulosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ArticulosServiceImpl implements ArticulosService {

    private final ObjectMapper mapper;

    public ArticulosServiceImpl(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String addProducts(MercadoPagoRequest articulos) throws MPException, MPApiException {

        PreferenceClient client = new PreferenceClient();

        // Configurar URLs de retorno
        PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest.builder()
                .success("https://d6a3-201-151-154-250.ngrok-free.app/pagos/hook")
                .failure("https://d6a3-201-151-154-250.ngrok-free.app/pagos/hook")
                .pending("https://d6a3-201-151-154-250.ngrok-free.app/pagos/hook")
                .build();

        // Crear items de la preferencia
        List<PreferenceItemRequest> items = new ArrayList<>();

        BigDecimal total = BigDecimal.ZERO;

        for (Articulos itemDTO : articulos.getArticulos()) {

            BigDecimal itemTotal = itemDTO.getPrice().multiply(BigDecimal.valueOf(itemDTO.getQuantity()));

            total = total.add(itemTotal);

            PreferenceItemRequest item = PreferenceItemRequest.builder()
                    .title(itemDTO.getTitle())
                    .description(itemDTO.getTitle())
                    .quantity(itemDTO.getQuantity())
                    .unitPrice(itemDTO.getPrice())
                    .pictureUrl("https://primefaces.org/cdn/primereact/images/product/bamboo-watch.jpg")
                    .build();
            items.add(item);
        }

        log.info("List<PreferenceItemRequest> items ={}", items.getFirst().getUnitPrice());

        // Configurar pagador si está disponible
        PreferencePayerRequest payer = null;

        if (articulos.getEmail() != null && !articulos.getEmail().isEmpty()) {
            payer = PreferencePayerRequest.builder()
                    .email(articulos.getEmail())
                    .build();
        }

        //log.info("PreferencePayerRequest payer = {}", payer);

        // Construir la solicitud de preferencia
        PreferenceRequest request = PreferenceRequest.builder()
                .items(items)
                .backUrls(backUrls)
                .autoReturn("approved")
                .payer(payer)
                .statementDescriptor("MiTiendaOnline")
                .externalReference("REF-" + System.currentTimeMillis())
                .notificationUrl("https://d6a3-201-151-154-250.ngrok-free.app/pagos/hook")
                .build();

        //log.info("PreferenceRequest request = {}", request);

        String urlPago = "";

        // Crear la preferencia
        try {
            Preference preference = client.create(request);
            log.info("Preferencia creada: {}", mapper.convertValue(preference, JsonNode.class));
            urlPago = preference.getSandboxInitPoint();
        } catch (MPApiException ex) {
            log.error("Error de API de MercadoPago. Status: {}, Response: {}",
                    ex.getApiResponse().getStatusCode(),
                    ex.getApiResponse().getContent());
            throw ex;
        } catch (MPException ex) {
            log.error("Error general de MercadoPago", ex);
            throw ex;
        }

        // Guardar en base de datos
        /*Pago pago = new Pago();
        pago.setPreferenceId(preference.getId());
        pago.setDescripcion(items.get(0).getTitle());
        pago.setMonto(total);
        pago.setMoneda("ARS");
        pago.setEmailComprador(pagoRequest.getPayerEmail());
        pago.setStatus("pending");

        pagoRepository.save(pago);*/

        return urlPago;
    }
}