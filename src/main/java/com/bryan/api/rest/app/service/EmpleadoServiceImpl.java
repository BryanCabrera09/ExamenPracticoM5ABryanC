package com.bryan.api.rest.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.bryan.api.rest.app.entity.Empleado;
import com.bryan.api.rest.app.repository.IEmpleadoRepository;

@Service
public class EmpleadoServiceImpl extends GenericServiceImpl<Empleado, Integer> implements IEmpleadoService {

	@Autowired
	IEmpleadoRepository empleadoRepository;

	@Override
	public CrudRepository<Empleado, Integer> getDao() {
		return empleadoRepository;
	}
}
