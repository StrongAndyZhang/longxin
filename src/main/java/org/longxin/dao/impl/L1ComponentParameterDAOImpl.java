package org.longxin.dao.impl;

import java.util.List;

import org.longxin.dao.L1ComponentParameterDAO;
import org.longxin.domains.L1Component;
import org.longxin.domains.L1ComponentParameter;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class L1ComponentParameterDAOImpl extends HibernateDaoSupport implements L1ComponentParameterDAO
{

    public L1ComponentParameter getL1ComponentParameterByID(Integer ID)
    {
        return this.getHibernateTemplate().get(L1ComponentParameter.class, ID);
    }

    @SuppressWarnings("unchecked")
    public List<L1ComponentParameter> getL1Parameters(L1Component component)
    {
        return this.getHibernateTemplate().find("FROM L1ComponentParameter l1 WHERE l1.l1Component= ?", component);
    }

    @Override
    public void addParameter(L1ComponentParameter l1parameter)
    {

        this.getHibernateTemplate().saveOrUpdate(l1parameter);
    }

    @Override
    public void deleteParameter(int id)
    {
        L1ComponentParameter parameter = this.getHibernateTemplate().get(L1ComponentParameter.class, id);
        this.getHibernateTemplate().delete(parameter);
    }

    @Override
    public void updateParameter(L1ComponentParameter l1parameter)
    {
        this.getHibernateTemplate().update(l1parameter);
    }
    
    @SuppressWarnings("unchecked")
    public List<L1ComponentParameter> searchByKeywords(String keywords)
    {
        keywords = "%" + keywords + "%";
        List<L1ComponentParameter> results = this
                .getHibernateTemplate()
                .find(
                    "FROM L1ComponentParameter parameter WHERE parameter.parameterName like ? OR parameter.parameterValue like ? OR parameter.options like ? OR parameter.minValue like ? OR parameter.maxValue like ? OR parameter.draftValue like ?",
                    keywords,
                    keywords,
                    keywords,
                    keywords,
                    keywords,
                    keywords);
        
        for(L1ComponentParameter parameter : results)
        {
            parameter.setSearched(true);
        }
        
        return results; 
    }
}
