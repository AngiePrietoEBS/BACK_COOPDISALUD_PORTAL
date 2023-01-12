/**
 * InformacionComercialWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ebssas.wsrestapicoopedac.cifin.service;

import com.ebssas.wsrestapicoopedac.cifin.dto.ParametrosConsultaDTO;
import java.rmi.RemoteException;

public interface InformacionComercialWS extends java.rmi.Remote {
    public java.lang.String consultaXml(ParametrosConsultaDTO in0) throws RemoteException;
    public java.lang.String consultaPlano(ParametrosConsultaDTO in0) throws RemoteException;
    public java.lang.String cambioPassword(String in0) throws RemoteException;
}
