// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.citzag.daos;

import com.citzag.daos.CzUsers;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

privileged aspect CzUsers_Roo_DbManaged {
    
    @Column(name = "id_instagram")
    @NotNull
    private Integer CzUsers.idInstagram;
    
    @Column(name = "content", length = 1024)
    @NotNull
    private String CzUsers.content;
    
    public Integer CzUsers.getIdInstagram() {
        return idInstagram;
    }
    
    public void CzUsers.setIdInstagram(Integer idInstagram) {
        this.idInstagram = idInstagram;
    }
    
    public String CzUsers.getContent() {
        return content;
    }
    
    public void CzUsers.setContent(String content) {
        this.content = content;
    }
    
}
