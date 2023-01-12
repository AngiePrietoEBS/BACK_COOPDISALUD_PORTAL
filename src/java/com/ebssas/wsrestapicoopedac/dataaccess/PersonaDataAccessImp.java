package com.ebssas.wsrestapicoopedac.dataaccess;


import com.ebssas.wsrestapicoopedac.domain.Persona;
import com.ebssas.wsrestapicoopedac.general.ConnectionDBJPA;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

/**
 *
 * @author Brian Cardenas
 */
public class PersonaDataAccessImp extends GenericRepositoryJPAImp<Persona> implements PersonaDataAccess {

    private EntityManager em = null;

    @Override
    public Persona savePersona(Persona persona) {
        return create(persona);
    }

    @Override
    public Persona updatePersona(Persona persona) {
        return update(persona);
    }

    @Override
    public void deletePersona(Persona persona) {
        delete(persona);
    }

    @Override
    public Persona findPersonaById(Long id) {
        return find(id);
    }
    
    public List<Persona> listarTodasPersonas() {
        return findAll();
    }
    
    public List<Persona> listPersonas() {
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        List<Persona> listPersona = new ArrayList<Persona>();
        try {
            em = connDBJPA.getEntityManager();
            Query consultDocument = em.createNativeQuery("SELECT p.I_CODIGO, "
                    + "p.C_IDENTIFICACION, "
                    + "p.I_TIPO_IDENT, "
                    + "p.C_NOMBRES, "
                    + "p.C_APELLIDOS, "
                    + "p.C_ESTADO "
                    + "FROM persona p");
            listPersona = consultDocument.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return listPersona;
    }

    @Override
    public Persona personaWebFindByCIdentificacion(int xiTipoIden, String C_IDENTIFICACION) {
        Persona personaFind = new Persona();
        BigInteger iTipoIden = new BigInteger(String.valueOf(xiTipoIden));
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sql = "SELECT *\n"
                    + "  FROM persona\n"
                    + " WHERE i_tipo_ident = ? AND c_identificacion = ?";
            Query consultDocument = em.createNativeQuery(sql, Persona.class);
            consultDocument.setParameter(1, iTipoIden);
            consultDocument.setParameter(2, C_IDENTIFICACION);
            List<Persona> listPersona = consultDocument.getResultList();
            if (listPersona != null && !listPersona.isEmpty()) {
                for (Persona personaFindByIdent : listPersona) {
                    if (personaFindByIdent.getCIdentificacion().equals(C_IDENTIFICACION)) {
                        personaFind = personaFindByIdent;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            personaFind = null;
            iTipoIden = null;
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
            connDBJPA = null;
            iTipoIden = null;
        }
        return personaFind;
    }

    @Override
    public Persona personaWebFindByID(Long xiCodPersona) {
        Persona personaFind = new Persona();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            TypedQuery<Persona> consultDocument = em.createNamedQuery("Persona.findByICodigo", Persona.class);
            consultDocument.setParameter("iCodigo", xiCodPersona);
            List<Persona> listPersona = consultDocument.getResultList();
            if (listPersona != null && !listPersona.isEmpty()) {
                personaFind = listPersona.get(0);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return personaFind;
    }

    @Override
    public Persona personaWebFindByCIdentificacionAndPerfil(int perfil, int xiTipoIden, String c_identificacion) {
        Persona personaFind = new Persona();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sSQL = "SELECT p.*\n"
                    + "  FROM persona p, usuario u, tipo_perfil tp\n"
                    + " WHERE p.i_codigo = u.i_persona\n"
                    + "   AND u.i_perfil = tp.i_codigo\n"
                    + "   AND u.i_perfil = ?\n"
                    + "   AND p.i_tipo_ident = ?\n"
                    + "   AND p.c_identificacion = ?";
            Query query = em.createNativeQuery(sSQL, Persona.class);
            query.setParameter(1, perfil);
            query.setParameter(2, xiTipoIden);
            query.setParameter(3, c_identificacion);
            List<Persona> result = query.getResultList();
            if (result != null && !result.isEmpty()) {
                personaFind = result.get(0);
            } else {
                personaFind = null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return personaFind;
    }
    
    public RespuestaGenerica registrarNuevaPersona(Persona persona, String sClave, String sLlaveSeg, int iTipoPerfil, int iTipoCanal) {
        RespuestaGenerica generica = new RespuestaGenerica();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            StoredProcedureQuery query = em.createStoredProcedureQuery("PKG_OPERACION.PRC_OPER_REGISTRO_USUARIO");
            query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(2, BigInteger.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(8, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(9, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(10, Integer.class, ParameterMode.OUT);
            query.registerStoredProcedureParameter(11, String.class, ParameterMode.OUT);

            query.setParameter(1, persona.getICodigo());
            query.setParameter(2, persona.getITipoIdent());
            query.setParameter(3, persona.getCIdentificacion());
            query.setParameter(4, persona.getCNombres());
            query.setParameter(5, persona.getCApellidos());
            query.setParameter(6, sClave);
            query.setParameter(7, sLlaveSeg);
            query.setParameter(8, iTipoPerfil);
            query.setParameter(9, iTipoCanal);

            query.execute();

            int iCodRtaSP = Integer.parseInt(query.getOutputParameterValue(10).toString());
            String sMsjRtaSP = query.getOutputParameterValue(11).toString();

            if (iCodRtaSP == 1) {
                generica.setiCodigo(iCodRtaSP);
                generica.setbRta(Boolean.TRUE);
                generica.setsMsj(sMsjRtaSP);
            } else {
                generica.setiCodigo(iCodRtaSP);
                generica.setbRta(Boolean.FALSE);
                generica.setsMsj("No se ha podido generar el registro del nuevo usuario. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return generica;
    }

}
