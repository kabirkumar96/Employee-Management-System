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
@Table(name = "PROJECT", catalog = "", schema = "EXAMPLE")
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p")
    , @NamedQuery(name = "Project.findByPid", query = "SELECT p FROM Project p WHERE p.pid = :pid")
    , @NamedQuery(name = "Project.findByPname", query = "SELECT p FROM Project p WHERE p.pname = :pname")
    , @NamedQuery(name = "Project.findByDeptid", query = "SELECT p FROM Project p WHERE p.deptid = :deptid")})
public class Project implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PID")
    private String pid;
    @Basic(optional = false)
    @Column(name = "PNAME")
    private String pname;
    @Basic(optional = false)
    @Column(name = "DEPTID")
    private String deptid;

    public Project() {
    }

    public Project(String pid) {
        this.pid = pid;
    }

    public Project(String pid, String pname, String deptid) {
        this.pid = pid;
        this.pname = pname;
        this.deptid = deptid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        String oldPid = this.pid;
        this.pid = pid;
        changeSupport.firePropertyChange("pid", oldPid, pid);
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        String oldPname = this.pname;
        this.pname = pname;
        changeSupport.firePropertyChange("pname", oldPname, pname);
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        String oldDeptid = this.deptid;
        this.deptid = deptid;
        changeSupport.firePropertyChange("deptid", oldDeptid, deptid);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pid != null ? pid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javadb.Project[ pid=" + pid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
