package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.Persona;

/**
 *
 * @author Brian Cardenas
 */
public interface PersonaDataAccess {

    Persona savePersona(Persona persona);

    Persona updatePersona(Persona persona);

    void deletePersona(Persona persona);

    Persona findPersonaById(Long id);

    Persona personaWebFindByCIdentificacion(int xiTipoIden, String C_IDENTIFICACION);

    Persona personaWebFindByCIdentificacionAndPerfil(int perfil, int xiTipoIden, String c_identificacion);

    Persona personaWebFindByID(Long xiCodPersona);

}
