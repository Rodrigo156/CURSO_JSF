/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projeto.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import org.hibernate.Session;

/**
 *
 * @author Funcionario
 */
public class PhaseListener implements javax.faces.event.PhaseListener{

    
      // Depois da Pahase
    @Override
    public void beforePhase(PhaseEvent phase) {
         if(phase.getPhaseId().equals(PhaseId.RESTORE_VIEW)){
             System.err.println("Antes da Phas: "+getPhaseId());
             Session session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            FacesContextUtil.seRequestSession(session);
        }
        
    }
    
    // Antes da Phase 
    @Override
    public void afterPhase(PhaseEvent phase) {
            System.err.println("Depois da Phas: "+getPhaseId());
           if(phase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)){
            Session session= FacesContextUtil.geRequestSession();
               try {
                   session.getTransaction().commit();
                   
               } catch (Exception e) {
                    if(session.getTransaction().isActive()){
                        session.getTransaction().rollback();
                    }
               }finally{
                   session.close();
               }
        } 
    }

  

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}
