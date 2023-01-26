package com.bryan.api.rest.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bryan.api.rest.app.entity.Empleado;

public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {

}
