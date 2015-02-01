package org.longxin.dao;

import java.util.List;

import org.longxin.domains.L3Component;
import org.longxin.domains.L3ComponentParameter;

public interface L3ComponentParameterDAO
{
	public L3Component getL3ComponentByID(Integer ID);
	
	public List<L3ComponentParameter> getL3Parameters(L3Component component);
	
	public void addParameter(L3ComponentParameter l3parameter);
}
