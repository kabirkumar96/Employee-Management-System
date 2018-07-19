/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadb;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author KABIR KUMAR
 */
@Entity
@Table(name = "DEPARTMENT", catalog = "", schema = "EXAMPLE")
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d")
    , @NamedQuery(name = "Department.findByDeptno", query = "SELECT d FROM Department d WHERE d.deptno = :deptno")
    , @NamedQuery(name = "Department.findByName", query = "SELECT d FROM Department d WHERE d.name = :name")
    , @NamedQuery(name = "Department.findByHodid", query = "SELECT d FROM Department d WHERE d.hodid = :hodid")})
public class Department implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DEPTNO")
    private String deptno;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "HODID")
    private String hodid;

    public Department() {
    }

    public Department(String deptno) {
        this.deptno = deptno;
    }

    public Department(String deptno, String name) {
        this.deptno = deptno;
        this.name = name;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        String oldDeptno = this.deptno;
        this.deptno = deptno;
        changeSupport.firePropertyChange("deptno", oldDeptno, deptno);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getHodid() {
        return hodid;
    }

    public void setHodid(String hodid) {
        String oldHodid = this.hodid;
        this.hodid = hodid;
        changeSupport.firePropertyChange("hodid", oldHodid, hodid);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptno != null ? deptno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.deptno == null && other.deptno != null) || (this.deptno != null && !this.deptno.equals(other.deptno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javadb.Department[ deptno=" + deptno + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
