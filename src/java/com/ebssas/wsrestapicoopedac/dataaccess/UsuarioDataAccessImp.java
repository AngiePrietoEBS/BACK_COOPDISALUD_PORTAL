package com.ebssas.wsrestapicoopedac.dataaccess;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.ebssas.wsrestapicoopedac.domain.Usuario;
import com.ebssas.wsrestapicoopedac.general.ConnectionDBJPA;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Brayan F Silva R
 */
public class UsuarioDataAccessImp extends GenericRepositoryJPAImp<Usuario> implements UsuarioDataAccess {

    private EntityManager em = null;

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        Usuario createUsuario = create(usuario);
        return createUsuario;
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        Usuario updateUsuario = update(usuario);
        return updateUsuario;
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        delete(usuario);
    }

    @Override
    public Usuario findUsuarioById(Long id) {
        Usuario usuario = find(id);
        return usuario;
    }

    @Override
    public List<Usuario> listUsuarios() {
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        List<Usuario> listUsuario = new ArrayList<Usuario>();
        try {
            em = connDBJPA.getEntityManager();
            Query consultDocument = em.createNativeQuery("SELECT u.I_CODIGO, "
                    + "p.C_IDENTIFICACION, "
                    + "p.C_E_Mail, "
                    + "p.C_NOMBRES, "
                    + "tp.C_DESCRIPCION, "
                    + "u.C_ESTADO "
                    + "FROM usuario u, persona p, tipo_perfil tp "
                    + "WHERE u.I_PERSONA = p.I_CODIGO "
                    + "AND u.I_PERFIL = tp.I_CODIGO");
            listUsuario = consultDocument.getResultList();
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
        return listUsuario;
    }

    @Override
    public Usuario findUserByPersonaIdent(int iTipoIdent, String sIdent) {
        Usuario findUserByPersonaIdent = new Usuario();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            Query consultDocument = em.createNativeQuery("SELECT u.* \n"
                    + "  FROM usuario u, persona p \n"
                    + " WHERE u.I_PERSONA = p.I_CODIGO \n"
                    + "   AND p.I_TIPO_IDENT = ? \n"
                    + "   AND p.C_IDENTIFICACION = ? \n"
                    + "   AND p.C_ESTADO = 'ACT' \n"
                    + "   AND u.C_ESTADO = 'ACT' ", Usuario.class);

            consultDocument.setParameter(1, iTipoIdent);
            consultDocument.setParameter(2, sIdent);

            List<Usuario> listUsuario = consultDocument.getResultList();
            if (listUsuario != null && !listUsuario.isEmpty()) {
                for (Usuario usuarioFindByPersonaIdent : listUsuario) {
                    if (usuarioFindByPersonaIdent.getIPersona().getCIdentificacion().equals(sIdent)) {
                        findUserByPersonaIdent = usuarioFindByPersonaIdent;
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
        return findUserByPersonaIdent;
    }
    
     @Override
    public Usuario findUserBysIdent(int iTipoIdent, String sIdent) {
        Usuario findUserByPersonaIdent = new Usuario();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            Query consultDocument = em.createNativeQuery("SELECT u.* \n"
                    + "  FROM usuario u, persona p \n"
                    + " WHERE u.I_PERSONA = p.I_CODIGO \n"
                    + "   AND p.I_TIPO_IDENT = ? \n"
                    + "   AND p.C_IDENTIFICACION = ? \n"
                    + "   AND u.I_PERFIL = 2 \n"
                    + "   AND p.C_ESTADO = 'ACT' \n"
                    + "   AND u.C_ESTADO = 'ACT' ", Usuario.class);

            consultDocument.setParameter(1, iTipoIdent);
            consultDocument.setParameter(2, sIdent);

            List<Usuario> listUsuario = consultDocument.getResultList();
            if (listUsuario != null && !listUsuario.isEmpty()) {
                for (Usuario usuarioFindByPersonaIdent : listUsuario) {
                    if (usuarioFindByPersonaIdent.getIPersona().getCIdentificacion().equals(sIdent)) {
                        findUserByPersonaIdent = usuarioFindByPersonaIdent;
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
        return findUserByPersonaIdent;
    }

    @Override
    public Usuario validaOlvidoClaveForUser(int xiTipoIdent, String xsIdent, int xiTipoPerfil, Long iTipoCanal) {
        Usuario usuarioValidaOlvidoClave = new Usuario();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("PKG_VALIDACION.PRC_VAL_OLVIDO_CONTRASENIA");
            storedProcedureQuery.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(4, Long.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(4, Integer.class, ParameterMode.OUT);
            storedProcedureQuery.registerStoredProcedureParameter(5, String.class, ParameterMode.OUT);
            storedProcedureQuery.registerStoredProcedureParameter(6, String.class, ParameterMode.OUT);

            storedProcedureQuery.setParameter(1, xsIdent);
            storedProcedureQuery.setParameter(2, xiTipoIdent);
            storedProcedureQuery.setParameter(3, xiTipoPerfil);
            storedProcedureQuery.setParameter(4, iTipoCanal);

            storedProcedureQuery.execute();

            Long lCodUser;
            if (storedProcedureQuery.getOutputParameterValue(5) != null) {
                lCodUser = new Long(storedProcedureQuery.getOutputParameterValue(5).toString());
            } else {
                lCodUser = new Long(0);
            }

            int cod_mensaje = Integer.parseInt(storedProcedureQuery.getOutputParameterValue(6).toString());
            String mensaje = storedProcedureQuery.getOutputParameterValue(7).toString();

            if (cod_mensaje == 1 && mensaje.equals("true")) {
                Usuario findUsuarioById = this.findUsuarioById(lCodUser);
                if (findUsuarioById != null && findUsuarioById.getICodigo() != null) {
                    findUsuarioById.setcCodMensaje(cod_mensaje);
                    findUsuarioById.setbRta(Boolean.TRUE);
                    findUsuarioById.setsMensaje("El usuario se encuentra registrado y puede continuar con el proceso de olvido contrase?a.");
                    usuarioValidaOlvidoClave = findUsuarioById;
                } else {
                    usuarioValidaOlvidoClave.setcCodMensaje(cod_mensaje);
                    usuarioValidaOlvidoClave.setbRta(Boolean.FALSE);
                    usuarioValidaOlvidoClave.setsMensaje("No se ha encontrado registro del usuario en la plataforma. Por favor intente de nuevo.");
                }
            } else {
                usuarioValidaOlvidoClave.setcCodMensaje(cod_mensaje);
                usuarioValidaOlvidoClave.setbRta(Boolean.FALSE);
                usuarioValidaOlvidoClave.setsMensaje("No se ha encontrado registro del usuario en la plataforma con los datos suministrados. Por favor intente de nuevo.");
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
        return usuarioValidaOlvidoClave;
    }

    @Override
    public List<Usuario> listarTodosUsuarios() {
        return findAll();
    }
    
    /**
     * Método que permite consultar un Usuario en base a su idCodigo.
     * @param iCodigo
     * @return un Objeto tipo Usuario.
     */
    public Usuario findUserByICodigo(Long iCodigo) {
        Usuario findUserByICodigo = new Usuario();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            Query consultDocument = em.createNativeQuery("SELECT u.* \n"
                    + "  FROM usuario u \n"
                    + " WHERE u.I_PERSONA = ?", Usuario.class);
            consultDocument.setParameter(1, iCodigo);
            
            List<Usuario> listUsuario = consultDocument.getResultList();
            if (listUsuario != null && !listUsuario.isEmpty()) {
               findUserByICodigo =listUsuario.get(0);
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
        return findUserByICodigo;
    }

}
