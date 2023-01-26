package com.bryan.api.rest.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bryan.api.rest.app.entity.Empleado;
import com.bryan.api.rest.app.service.IEmpleadoService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {

	@Autowired
	IEmpleadoService empleadoService;

	@GetMapping("/listar")
	public ResponseEntity<List<Empleado>> obtenerLista() {
		try {
			return new ResponseEntity<>(empleadoService.findByAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<Empleado> getById(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity<>(empleadoService.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/crear")
	public ResponseEntity<Empleado> crear(@Valid @RequestBody Empleado e) {

		if (e.getDias_trabajo() >= 20) {
			
			int sueldo_tot = e.getDias_trabajo() * 15;

			double aumento = sueldo_tot * 0.02;

			e.setSueldo(sueldo_tot + aumento);

			return new ResponseEntity<>(empleadoService.save(e), HttpStatus.CREATED);

		}

		if (e.getDias_trabajo() >= 30) {

			int sueldo_tot = e.getDias_trabajo() * 15;

			double aumento = sueldo_tot * 0.05;

			e.setSueldo(sueldo_tot + aumento);

			return new ResponseEntity<>(empleadoService.save(e), HttpStatus.CREATED);

		}

		return new ResponseEntity<>(empleadoService.save(e), HttpStatus.CREATED);

	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id) {

		try {
			empleadoService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Empleado> actualizarUsuario(@Valid @PathVariable Integer id, @RequestBody Empleado e) {
		Empleado Empleado = empleadoService.findById(id);
		if (Empleado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {

				if (e.getDias_trabajo() >= 20) {

					int sueldo_tot = e.getDias_trabajo() * 15;

					double aumento = sueldo_tot * 0.02;

					Empleado.setNombre(e.getNombre());
					Empleado.setApellido(e.getApellido());
					Empleado.setTelefono(e.getTelefono());
					Empleado.setDireccion(e.getDireccion());
					Empleado.setFecha_nacimiento(e.getFecha_nacimiento());
					Empleado.setObservacion(e.getObservacion());
					Empleado.setDias_trabajo(e.getDias_trabajo());
					Empleado.setSueldo(sueldo_tot + aumento);
					return new ResponseEntity<>(empleadoService.save(Empleado), HttpStatus.CREATED);

				}

				if (e.getDias_trabajo() >= 30) {

					int sueldo_tot = e.getDias_trabajo() * 15;

					double aumento = sueldo_tot * 0.05;

					e.setSueldo(sueldo_tot + aumento);

					Empleado.setNombre(e.getNombre());
					Empleado.setApellido(e.getApellido());
					Empleado.setTelefono(e.getTelefono());
					Empleado.setDireccion(e.getDireccion());
					Empleado.setFecha_nacimiento(e.getFecha_nacimiento());
					Empleado.setObservacion(e.getObservacion());
					Empleado.setDias_trabajo(e.getDias_trabajo());
					Empleado.setSueldo(sueldo_tot + aumento);
					return new ResponseEntity<>(empleadoService.save(Empleado), HttpStatus.CREATED);

				}

				Empleado.setNombre(e.getNombre());
				Empleado.setApellido(e.getApellido());
				Empleado.setTelefono(e.getTelefono());
				Empleado.setDireccion(e.getDireccion());
				Empleado.setFecha_nacimiento(e.getFecha_nacimiento());
				Empleado.setObservacion(e.getObservacion());
				Empleado.setDias_trabajo(e.getDias_trabajo());
				Empleado.setSueldo(e.getSueldo());
				return new ResponseEntity<>(empleadoService.save(Empleado), HttpStatus.CREATED);
			} catch (Exception ex) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}

	}
}