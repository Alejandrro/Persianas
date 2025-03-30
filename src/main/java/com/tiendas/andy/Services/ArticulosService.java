package com.tiendas.andy.Services;

import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.tiendas.andy.Dtos.Request.MercadoPagoRequest;

public interface ArticulosService {

    String addProducts(MercadoPagoRequest articulos) throws MPException, MPApiException;
}