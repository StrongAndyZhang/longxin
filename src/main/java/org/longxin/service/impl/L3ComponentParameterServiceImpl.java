package org.longxin.service.impl;

import java.util.List;

import org.longxin.dao.L3ComponentParameterDAO;
import org.longxin.domains.L3ComponentParameter;
import org.longxin.domains.L3Component;
import org.longxin.service.L3ComponentParameterService;
import org.springframework.beans.factory.annotation.Autowired;

public class L3ComponentParameterServiceImpl implements L3ComponentParameterService
{
    @Autowired
    L3ComponentParameterDAO l3ComponentParameterDAO;

    public List<L3ComponentParameter> getL3Paramters(L3Component component)
    {
        return this.l3ComponentParameterDAO.getL3Parameters(component);
    }

    @Override
    public void addParameter(L3ComponentParameter l3parameter)
    {
        this.l3ComponentParameterDAO.addParameter(l3parameter);
    }

    @Override
    public void deleteParameter(int id)
    {
        this.l3ComponentParameterDAO.deleteParameter(id);
    }

    @Override
    public void updateParameter(L3ComponentParameter l3parameter)
    {
        this.l3ComponentParameterDAO.updateParameter(l3parameter);
    }
    
    public void deleteL3ParameterByL3Component(L3Component l3)
    {
        List<L3ComponentParameter> parameters = this.getL3Paramters(l3);
        
        if (parameters != null && parameters.size() > 0)
        {
            //this.deleteParameter()
        }
    }

    @Override
    public L3ComponentParameter getL3ComponentParamtersByID(Integer parameterId)
    {
        return l3ComponentParameterDAO.getL3ComponentParamtersByID(parameterId);
    }

    @Override
    public List<L3ComponentParameter> searchByKeywords(String keywords)
    {
        return this.l3ComponentParameterDAO.searchByKeywords(keywords);
    }
}
