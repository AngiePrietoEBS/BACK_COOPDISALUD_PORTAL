package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.Acceso;
import com.ebssas.wsrestapicoopedac.domain.Usuario;
import com.ebssas.wsrestapicoopedac.general.ConnectionDBJPA;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
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
public class AccesoDataAccessImp extends GenericRepositoryJPAImp<Acceso> implements AccesoDataAccess {

    private EntityManager em = null;

    @Override
    public Acceso saveAcceso(Acceso acceso) {
        Acceso createAcceso = create(acceso);
        return createAcceso;
    }

    @Override
    public Acceso updateAcceso(Acceso acceso) {
        Acceso updateAcceso = update(acceso);
        return updateAcceso;
    }

    @Override
    public Acceso findAccesoById(Long id) {
        Acceso findAccesoById = find(id);
        return findAccesoById;
    }

    @Override
    public Acceso findAccesoByIdUser(Usuario usuario) {
        Acceso findAccesoByIdUser = new Acceso();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            TypedQuery<Acceso> consultDocument = em.createNamedQuery("Acceso.findByIUsuario", Acceso.class);
            consultDocument.setParameter("iUsuario", usuario);
            List<Acceso> listAcceso = consultDocument.getResultList();
            if (listAcceso != null && !listAcceso.isEmpty()) {
                for (Acceso acceso : listAcceso) {
                    if (acceso.getIUsuario().getICodigo().equals(usuario.getICodigo())) {
                        findAccesoByIdUser = acceso;
                        break;
                    }
                }
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

        return findAccesoByIdUser;
    }

    @Override
    public Acceso findAccesoByIUsuarioAndiTransaccion(Long idUser, int iTransaccion) {
        Acceso findAccesoByIUsuarioAndiTransaccio = new Acceso();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            Query consultDocument = em.createNativeQuery("SELECT a.*\n"
                    + "  FROM acceso a, usuario u, transaccion t\n"
                    + " WHERE a.i_usuario = u.i_codigo\n"
                    + "   AND a.i_transaccion = t.i_codigo\n"
                    + "   AND a.i_usuario = ? \n"
                    + "   AND a.i_transaccion = ?  ", Acceso.class);

            consultDocument.setParameter(1, idUser);
            consultDocument.setParameter(2, iTransaccion);

            List<Acceso> listAcceso = consultDocument.getResultList();
            if (listAcceso != null && !listAcceso.isEmpty()) {
                for (Acceso acceso : listAcceso) {
                    if (acceso.getIUsuario().getICodigo().equals(idUser) && acceso.getITransaccion().getICodigo().intValue() == iTransaccion) {
                        findAccesoByIUsuarioAndiTransaccio = acceso;
                        break;
                    }
                }
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
        return findAccesoByIUsuarioAndiTransaccio;
    }

    @Override
    public void deleteAcceso(Acceso acceso) {
        delete(acceso);
    }

    @Override
    public String getLlaveSeguridadAcceso(int tipoIdent, String sIdentificacion, String sTipoTransaccon, int iTipoPerfil, int iTipoCanal) {
        String sLlaveSeguridad = "";
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        
        try {
            em = connDBJPA.getEntityManager();
            Query query = em.createNativeQuery("SELECT PKG_VALIDACION.FNC_VAL_SEGURIDAD(?,?,?,?,?) FROM DUAL");
            query.setParameter(1, tipoIdent);
            query.setParameter(2, sIdentificacion);
            query.setParameter(3, sTipoTransaccon);
            query.setParameter(4, iTipoPerfil);
            query.setParameter(5, iTipoCanal);

            List result = query.getResultList();
            if (result != null && !result.isEmpty()) {
                for (Object object : result) {
                    sLlaveSeguridad = (String) object.toString();
                    if (sLlaveSeguridad != null && !sLlaveSeguridad.isEmpty()) {
                    } else {
                        sLlaveSeguridad = "";
                    }
                    
                }
            } else {
                sLlaveSeguridad = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            sLlaveSeguridad = "";
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return sLlaveSeguridad;
    }

    /**
     *
     * @param tipoIdent
     * @param sIdentificacion
     * @param sPrimeraClave
     * @param iTipoPerfil
     * @param iTipoCanal
     * @return
     */
    @Override
    public Usuario validarPrimeraClave(int tipoIdent, String sIdentificacion, String sPrimeraClave, int iTipoPerfil, int iTipoCanal) {

        Usuario usuarioValPrimeraClave = new Usuario();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            StoredProcedureQuery query = em.createStoredProcedureQuery("PKG_VALIDACION.PRC_VAL_PRIMERA_CLAVE");
            query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(4, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(5, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(6, Long.class, ParameterMode.OUT);
            query.registerStoredProcedureParameter(7, String.class, ParameterMode.OUT);
            query.registerStoredProcedureParameter(8, String.class, ParameterMode.OUT);
            query.registerStoredProcedureParameter(9, String.class, ParameterMode.OUT);
            query.registerStoredProcedureParameter(10, String.class, ParameterMode.OUT);

            query.setParameter(1, tipoIdent);
            query.setParameter(2, sIdentificacion);
            query.setParameter(3, sPrimeraClave);
            query.setParameter(4, iTipoPerfil);
            query.setParameter(5, iTipoCanal);

            query.execute();
            Long lCodUser;
            if (query.getOutputParameterValue(6) != null) {
                lCodUser = new Long(query.getOutputParameterValue(6).toString());
            } else {
                lCodUser = new Long(0);
            }

            Long lCodPersona;
            if (query.getOutputParameterValue(7) != null) {
                lCodPersona = new Long(query.getOutputParameterValue(7).toString());
            } else {
                lCodPersona = new Long(0);
            }

            Long lCodTipoPerfil;
            if (query.getOutputParameterValue(8) != null) {
                lCodTipoPerfil = new Long(query.getOutputParameterValue(8).toString());
            } else {
                lCodTipoPerfil = new Long(0);
            }

            int cod_mensaje = Integer.parseInt(query.getOutputParameterValue(9).toString());
            String mensaje = query.getOutputParameterValue(10).toString();

            if (cod_mensaje == 1 && mensaje.equals("true")) {
                UsuarioDataAccessImp usuarioDataAccessImp = new UsuarioDataAccessImp();
                Usuario findUsuarioById = usuarioDataAccessImp.findUsuarioById(lCodUser);
                if (findUsuarioById != null && findUsuarioById.getICodigo() != null) {
                    findUsuarioById.setcCodMensaje(cod_mensaje);
                    findUsuarioById.setbRta(Boolean.TRUE);
                    findUsuarioById.setsMensaje("Los datos son correctos.");
                    usuarioValPrimeraClave = findUsuarioById;
                } else {
                    usuarioValPrimeraClave.setbRta(Boolean.FALSE);
                    usuarioValPrimeraClave.setsMensaje("No se ha podido validar los datos enviados. Por favor intente de nuevo.");
                }
            } else {
                usuarioValPrimeraClave.setbRta(Boolean.FALSE);
                usuarioValPrimeraClave.setsMensaje(mensaje);
            }
        } catch (Exception e) {
            e.printStackTrace();
            usuarioValPrimeraClave.setbRta(Boolean.FALSE);
            usuarioValPrimeraClave.setsMensaje("Se ha presentado un inconveniente al procesar la petici??n solicitada, por favor vuelva a intentarlo, si el incidente persiste comuniquese con la entidad.");
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return usuarioValPrimeraClave;
    }

}
