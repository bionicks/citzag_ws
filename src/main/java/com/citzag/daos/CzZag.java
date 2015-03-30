package com.citzag.daos;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;


@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "cz_zag")
@RooDbManaged(automaticallyDelete = true)
public class CzZag {
	
	
	   @Column(name = "created")
	    private Long created;
	   
	   @Column(name = "content")
	    private String content;

	public Long getCreated() {
		return created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	   
	
	public static List<CzZag> findByTag(String tag) {								
		EntityManager em = CzZag.entityManager();  				 
		TypedQuery<CzZag> q = em.createQuery("SELECT o FROM CzZag o WHERE o.tags like :tag order by o.created DESC",CzZag.class);			 
		q.setParameter("tag", '%'+tag+'%');		
		return q.getResultList();
	}
	
	public static List<BigDecimal> findIds() {								
		EntityManager em = CzZag.entityManager();  		
		TypedQuery<BigDecimal> q = em.createQuery("SELECT o.idInstagram FROM CzZag as o",BigDecimal.class);			 			
		return q.getResultList();
	}
	

	public static void truncate() {								
		EntityManager em = CzZag.entityManager();  		
		Query q = em.  createQuery("Delete from CzZag");
		
		q.executeUpdate();
	}
	
	public static void deleteByIds(List<BigDecimal> ids) {								
		EntityManager em = CzZag.entityManager();  		
		Query q = em.  createQuery("Delete from CzZag as o where o.idInstagram in ( :ids )");
		q.setParameter("ids", ids);		
		q.executeUpdate();
	}
	
	public static List<CzZag> findByIdInstagramUser(Integer id) {								
		EntityManager em = CzZag.entityManager();  		
		TypedQuery<CzZag> q = em.createQuery("SELECT o FROM CzZag as o where o.idInstagramUser = :id order by o.created DESC",CzZag.class);
		q.setParameter("id", id);
		return q.getResultList();
	}
	
	public static List<Integer> getZagsByRadius( BigDecimal lat, BigDecimal lon, Integer radius ) {        
        EntityManager em = CzZag.entityManager();
        Query q = em.createNativeQuery(" select zag.id from cz_zag as zag where zag.`latitude` is not null AND zag.`longitude` is not null AND ( getDistance(:lat, :longi, zag.`latitude` , zag.`longitude` )* 1000 ) <= :radius ");        
        q.setParameter("lat", lat );
        q.setParameter("longi", lon );
        q.setParameter("radius", radius );                
        List<Integer> resultList = q.getResultList();                                            
        return resultList;
    }
	
	public static List<CzZag> findByIds(List<Integer> ids) {								
		EntityManager em = CzZag.entityManager();  		
		TypedQuery<CzZag> q = em.createQuery("SELECT o FROM CzZag as o where o.id in ( :ids ) order by o.created DESC",CzZag.class);
		q.setParameter("ids", ids);
		
		return q.getResultList();
	}
	  
	   
	   
}
