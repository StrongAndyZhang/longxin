package org.longxin.domains;

// Generated 2015-1-5 21:21:32 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Department generated by hbm2java
 */
@Entity
@Table(name = "attachment", catalog = "longxin")
public class Attachment implements java.io.Serializable
{
    private static final long serialVersionUID = -8141854561188609535L;

    private Integer id;

    private Date createdat;

    private String fileName;

    private Users owner;

    private String category;

    private Integer referenceId;
    
    //private Boolean isDraft;

    public Attachment()
    {
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT", nullable = false, length = 19)
    public Date getCreatedat()
    {
        return createdat;
    }

    public void setCreatedat(Date createdat)
    {
        this.createdat = createdat;
    }

    @Column(name = "FILE_NAME")
    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade= CascadeType.PERSIST)
    @JoinColumn(name = "OWNER")
    public Users getOwner()
    {
        return owner;
    }

    public void setOwner(Users owner)
    {
        this.owner = owner;
    }

    @Enumerated(EnumType.STRING)
    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    @Column(name = "REFERENCE_ID")
    public Integer getReferenceId()
    {
        return referenceId;
    }

    public void setReferenceId(Integer referenceId)
    {
        this.referenceId = referenceId;
    }

}
