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
import javax.persistence.Transient;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import org.longxin.util.OperationType;


/**
 * Department generated by hbm2java
 */
@Entity
@Table(name = "change_history", catalog = "longxin")
public class ChangeHistory implements java.io.Serializable
{

    private static final long serialVersionUID = -1844716986875912213L;

    private Integer id;

    private Date updatedat;
    
    private String category;

    private Integer referenceId;

    private Users operator;

    private String oldValue;
    
    private String newValue;
    
    private OperationType operationType;
    
    private String comments;
    
    private String displayUpdateAt;

    public ChangeHistory()
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_AT", nullable = false, length = 19)
    public Date getUpdatedat()
    {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat)
    {
        this.updatedat = updatedat;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade= CascadeType.PERSIST)
    @JoinColumn(name = "OPERATOR")
    public Users getOperator()
    {
        return operator;
    }

    public void setOperator(Users operator)
    {
        this.operator = operator;
    }

    @Column(name = "OLD_VALUE")
    public String getOldValue()
    {
        return oldValue;
    }

    public void setOldValue(String oldValue)
    {
        this.oldValue = oldValue;
    }

    @Column(name = "NEW_VALUE")
    public String getNewValue()
    {
        return newValue;
    }

    public void setNewValue(String newValue)
    {
        this.newValue = newValue;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "OPERATION_TYPE")
    public OperationType getOperationType()
    {
        return operationType;
    }

    public void setOperationType(OperationType operationType)
    {
        this.operationType = operationType;
    }

    @Column(name = "COMMENTS")
    public String getComments()
    {
        return comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    @Transient
    public String getDisplayUpdateAt()
    {
        return displayUpdateAt;
    }

    public void setDisplayUpdateAt(String displayUpdateAt)
    {
        this.displayUpdateAt = displayUpdateAt;
    }
    
    
    
}
