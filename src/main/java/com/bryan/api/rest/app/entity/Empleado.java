package com.bryan.api.rest.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "empleado")
public class Empleado implements Serializable {

	private static final long serialVersionUID = -1690437396932680528L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_empleado")
	private Integer id;

	@Size(max = 45, message = "Apellido Longitud maxima permitida 45 caracteres")
	@NotNull(message = "Apellido No puede ser nulo")
	@Column(name = "apellido")
	private String apellido;

	@Size(max = 45, message = "Nombre Longitud maxima permitida 45 caracteres")
	@NotNull(message = "Nombre No puede ser nulo")
	@Column(name = "nombre")
	private String nombre;

	@Size(max = 15, message = "Telefono Longitud maxima permitida 15 caracteres")
	@NotNull(message = "Telefono No puede ser nulo")
	@Column(name = "telefono")
	private String telefono;

	@Size(max = 45, message = "Direccion Longitud maxima permitida 45 caracteres")
	@NotNull(message = "Direccion No puede ser nulo")
	@Column(name = "direccion")
	private String direccion;

	@NotNull(message = "Fecha de Nacimeinto No puede ser nulo")
	@Column(name = "fecha_nacimiento")
	private Date fecha_nacimiento;

	@Size(max = 45, message = "Observacion Longitud maxima permitida 45 caracteres")
	@NotNull(message = "Observacion No puede ser nulo")
	@Column(name = "observacion")
	private String observacion;

	@NotNull(message = "Dias de trabajo No puede ser nulo")
	@Column(name = "dias_trabajo")
	private Integer dias_trabajo;

	@NotNull(message = "Sueldo No puede ser nulo")
	@Column(name = "sueldo")
	private Double sueldo;

}
