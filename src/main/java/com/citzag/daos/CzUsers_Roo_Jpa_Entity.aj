// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.citzag.daos;

import com.citzag.daos.CzUsers;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

privileged aspect CzUsers_Roo_Jpa_Entity {
    
    declare @type: CzUsers: @Entity;
    
    declare @type: CzUsers: @Table(name = "cz_users");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer CzUsers.id;
    
    public Integer CzUsers.getId() {
        return this.id;
    }
    
    public void CzUsers.setId(Integer id) {
        this.id = id;
    }
    
}