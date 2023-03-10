package com.ebssas.wsrestapicoopedac.general;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Brayan F Silva R
 * @param <T>
 */
public class GenericRepositoryJPAImp<T> implements GenericRepository<T> {

    protected EntityManager entityManager;
    private Class<T> type;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public GenericRepositoryJPAImp() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    /**
     *
     * @param t
     * @return
     */
    @Override
    public T create(T t) {
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            this.entityManager = connDBJPA.getEntityManager();
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            connDBJPA.closeEntityManager();
            if (this.entityManager != null) {
                if (this.entityManager.isOpen()) {
                    this.entityManager.close();
                }
            }
            connDBJPA = null;
        }
        return t;
    }

    @Override
    public T update(T t) {
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            this.entityManager = connDBJPA.getEntityManager();
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(t);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (this.entityManager.getTransaction().isActive()) {
                this.entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            connDBJPA.closeEntityManager();
            if (this.entityManager != null) {
                if (this.entityManager.isOpen()) {
                    this.entityManager.close();
                }
            }
            connDBJPA = null;
        }
        return t;
    }

    @Override
    public void delete(final T t) {
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            this.entityManager = connDBJPA.getEntityManager();
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(entityManager.merge(t));
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (this.entityManager.getTransaction().isActive()) {
                this.entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            connDBJPA.closeEntityManager();
            if (this.entityManager != null) {
                if (this.entityManager.isOpen()) {
                    this.entityManager.close();
                }
            }
            connDBJPA = null;
        }

    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public T find(final Object id) {
        T findClass = null;
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            this.entityManager = connDBJPA.getEntityManager();
            findClass = (T) this.entityManager.find(type, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connDBJPA.closeEntityManager();
            if (this.entityManager != null) {
                if (this.entityManager.isOpen()) {
                    this.entityManager.close();
                }
            }
            connDBJPA = null;
        }
        return findClass;
    }

    @Override
    public List<T> findAll() {
        List<T> lstFindAll = new ArrayList<>();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            this.entityManager = connDBJPA.getEntityManager();
            CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
            CriteriaQuery<T> criteriaQuery = cb.createQuery(type);
            Root<T> root = criteriaQuery.from(type);
            criteriaQuery.select(root);
            criteriaQuery.orderBy(cb.asc(root.get("iCodigo")));
            TypedQuery<T> query = this.entityManager.createQuery(criteriaQuery);
            lstFindAll = query.getResultList();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            connDBJPA.closeEntityManager();
            if (this.entityManager != null) {
                if (this.entityManager.isOpen()) {
                    this.entityManager.close();
                }
            }
            connDBJPA = null;
        }

        return lstFindAll;
    }

    @Override
    public List<T> findAllOrderByCampo(String sTipoOrder, String sCampoOrder) {

        List<T> listFindAllOrderByCampo = new ArrayList<>();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            this.entityManager = connDBJPA.getEntityManager();
            CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
            CriteriaQuery<T> criteriaQuery = cb.createQuery(type);
            Root<T> root = criteriaQuery.from(type);
            criteriaQuery.select(root);
            switch (sTipoOrder.toUpperCase()) {
                case "ASC":
                    criteriaQuery.orderBy(cb.asc(root.get(sCampoOrder)));
                    break;
                case "DESC":
                    criteriaQuery.orderBy(cb.desc(root.get(sCampoOrder)));
                    break;
                default:
                    criteriaQuery.orderBy(cb.desc(root.get(sCampoOrder)));
                    break;
            }

            TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
//            query.setFirstResult(5);
            query.setMaxResults(100);
            listFindAllOrderByCampo = query.getResultList();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            connDBJPA.closeEntityManager();
            if (this.entityManager != null) {
                if (this.entityManager.isOpen()) {
                    this.entityManager.close();
                }
            }
            connDBJPA = null;
        }

        return listFindAllOrderByCampo;
    }

    @Override
    public List<T> findByNamedQueryForValueString(T t, String sNameQuery, String sCampoFind, String sValueFind) {
        List<T> list = new ArrayList<>();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            this.entityManager = connDBJPA.getEntityManager();
            TypedQuery<T> query = this.entityManager.createNamedQuery(sNameQuery, type);
            query.setParameter(sCampoFind, sValueFind);
            list = query.getResultList();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            connDBJPA.closeEntityManager();
            if (this.entityManager != null) {
                if (this.entityManager.isOpen()) {
                    this.entityManager.close();
                }
            }
            connDBJPA = null;
        }
        return list;
    }

    @Override
    public List<T> findByNamedQueryForValueEntity(T t, String sNameQuery, String sCampoFind, T valueEntity) {
        List<T> list = new ArrayList<>();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            this.entityManager = connDBJPA.getEntityManager();
            TypedQuery<T> query = this.entityManager.createNamedQuery(sNameQuery, type);
            query.setParameter(sCampoFind, valueEntity);
            list = query.getResultList();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            connDBJPA.closeEntityManager();
            if (this.entityManager != null) {
                if (this.entityManager.isOpen()) {
                    this.entityManager.close();
                }
            }
            connDBJPA = null;
        }
        return list;
    }

}
