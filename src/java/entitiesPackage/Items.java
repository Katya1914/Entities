/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitiesPackage;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ekaterina
 */
@Entity
@Table(name = "Items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Items.findAll", query = "SELECT i FROM Items i"),
    @NamedQuery(name = "Items.findByIdItem", query = "SELECT i FROM Items i WHERE i.idItem = :idItem"),
    @NamedQuery(name = "Items.findByName", query = "SELECT i FROM Items i WHERE i.name = :name"),
    @NamedQuery(name = "Items.findByKolStr", query = "SELECT i FROM Items i WHERE i.kolStr = :kolStr"),
    @NamedQuery(name = "Items.findByAuthor", query = "SELECT i FROM Items i WHERE i.author = :author"),
    @NamedQuery(name = "Items.findByUrl", query = "SELECT i FROM Items i WHERE i.url = :url")})
public class Items implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_item")
    private Integer idItem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kolStr")
    private int kolStr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "author")
    private String author;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "url")
    private String url;
    @JoinColumn(name = "id_category", referencedColumnName = "id_category")
    @ManyToOne(optional = false)
    private Category idCategory;

    public Items() {
    }

    public Items(Integer idItem) {
        this.idItem = idItem;
    }

    public Items(Integer idItem, String name, int kolStr, String author, String url) {
        this.idItem = idItem;
        this.name = name;
        this.kolStr = kolStr;
        this.author = author;
        this.url = url;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKolStr() {
        return kolStr;
    }

    public void setKolStr(int kolStr) {
        this.kolStr = kolStr;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItem != null ? idItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Items)) {
            return false;
        }
        Items other = (Items) object;
        if ((this.idItem == null && other.idItem != null) || (this.idItem != null && !this.idItem.equals(other.idItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiesPackage.Items[ idItem=" + idItem + " ]";
    }
    
}
