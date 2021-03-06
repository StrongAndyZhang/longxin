package org.longxin.domains;

// Generated 2015-1-17 19:49:59 by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product", catalog = "longxin")
public class Product implements java.io.Serializable, Cloneable
{
    private static final long serialVersionUID = 7261078295026874126L;

    private Integer id;

    private String name;

    private Date createdat;

    private Boolean template;

    private String description;

    private String functionName;

    private Users owner;

    private Set<Feature> features = new HashSet<Feature>(0);
    
    private Set<Requirements> requirements = new HashSet<Requirements>(0);

    private Boolean searched;
    
    private List<Feature> tempFeatures = new ArrayList<Feature>();

    public Product()
    {
    }

    public Product(String name, Date createdat)
    {
        this.name = name;
        this.createdat = createdat;
    }

    public Product(String name, Date createdat, Boolean template, Set<Feature> features)
    {
        this.name = name;
        this.createdat = createdat;
        this.template = template;
        this.features = features;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId()
    {
        return this.id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdat", nullable = false, length = 19)
    public Date getCreatedat()
    {
        return this.createdat;
    }

    public void setCreatedat(Date createdat)
    {
        this.createdat = createdat;
    }

    @Column(name = "TEMPLATE")
    public Boolean getTemplate()
    {
        return this.template;
    }

    public void setTemplate(Boolean template)
    {
        this.template = template;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Column(name = "FUNCTION_NAME")
    public String getFunctionName()
    {
        return functionName;
    }

    public void setFunctionName(String functionName)
    {
        this.functionName = functionName;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL)
    @OrderBy("id ASC")
    @JsonIgnore
    public Set<Feature> getFeatures()
    {
        return this.features;
    }

    public void setFeatures(Set<Feature> features)
    {
        this.features = features;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL)
    @OrderBy("id ASC")
    @JsonIgnore
    public Set<Requirements> getRequirements()
    {
        return requirements;
    }

    public void setRequirements(Set<Requirements> requirements)
    {
        this.requirements = requirements;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "owner")
    @JsonIgnore
    public Users getOwner()
    {
        return owner;
    }

    public void setOwner(Users owner)
    {
        this.owner = owner;
    }

    @Transient
    public Boolean getSearched()
    {
        return searched;
    }

    public void setSearched(Boolean searched)
    {
        this.searched = searched;
    }
    
    @Transient
    public List<Feature> getTempFeatures()
    {
        return tempFeatures;
    }

    public void setTempFeatures(List<Feature> tempFeatures)
    {
        this.tempFeatures = tempFeatures;
    }

    public Object clone() throws CloneNotSupportedException
    {
        Product cloned = (Product) super.clone();
        cloned.setId(null);
        cloned.setTemplate(Boolean.FALSE);
        cloned.createdat = new Date();
        cloned.setName("新产品");
        cloned.setCreatedat(new Date());
        if (this.features != null)
        {
            Set<Feature> clonedFeatures = new HashSet<Feature>();
            for (Feature feature : features)
            {
                Feature clonedFeature = (Feature) feature.clone();
                clonedFeature.setProduct(cloned);
                clonedFeatures.add(clonedFeature);
            }

            cloned.setFeatures(clonedFeatures);
        }
        
        if (this.requirements != null)
        {
        	Set<Requirements> clonedRequirements = new HashSet<Requirements>();
        	for(Requirements requirement : requirements)
        	{
        		Requirements clonedRequirement = (Requirements)requirement.clone();
        		clonedRequirement.setProduct(cloned);
        		clonedRequirements.add(clonedRequirement);
        	}
        	
        	cloned.setRequirements(clonedRequirements);
        }

        return cloned;
    }

}
