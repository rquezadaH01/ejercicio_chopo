package com.chopo.ejercicio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import jakarta.persistence.PersistenceException;
import jakarta.websocket.SessionException;

@RestControllerAdvice
public class RequestExcepcion {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationExceptions400(MethodArgumentNotValidException ex) {
		
		return new ResponseEntity<>("Error al procesar la solicitud.", HttpStatus.BAD_REQUEST);
	}

	/**
	 * Excepción de parámetro de solicitud de servlet faltante
	 * 
	 * @param ex de tipo MissingServletRequestParameterException
	 * @return regresa un ResponseEntity
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = { MissingServletRequestParameterException.class })
	public ResponseEntity<String> handleValidationExceptions404(MissingServletRequestParameterException ex) {
		return new ResponseEntity<>("Servicio no encontrado.", HttpStatus.NOT_FOUND);
	}

	/**
	 * Error interno
	 * 
	 * @param ex de tipo InternalServerError
	 * @return regresa un ResponseEntity
	 */
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { HttpServerErrorException.InternalServerError.class })
	public ResponseEntity<String> handleValidationExceptions500(HttpServerErrorException.InternalServerError ex) {
		
		return new ResponseEntity<>("Error interno del servidor.", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Excepción de persistencia SQL
	 * 
	 * @param ex de tipo PersistenceException
	 * @return regresa un ResponseEntity
	 */
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { PersistenceException.class })
	public ResponseEntity<String> handleValidationExceptions400(PersistenceException ex) {
		return new ResponseEntity<>("Error al realizar la transacción abase de datos.", HttpStatus.BAD_REQUEST);
	}


	/**
	 * Error interno
	 * 
	 * @param ex de tipo InternalServerError
	 * @return regresa un ResponseEntity
	 */
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { IllegalArgumentException.class })
	public ResponseEntity<String> handleValidationExceptions500(IllegalArgumentException ex) {

		return new ResponseEntity<>("Parametros de entrada no validos.", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Exception400
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exception400(Exception ex) {

		return new ResponseEntity<>("Error en parametros de entrada.", HttpStatus.BAD_REQUEST);
	}

	/**
	 * Null excepcion
	 * 
	 * @param ex de tipo NullPointerException ex
	 * @return regresa un ResponseEntity
	 */
	@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(value = { NullPointerException.class })
	public ResponseEntity<String> handleValidationExceptions405Null(NullPointerException ex) {

		return new ResponseEntity<>("Revisa que los parametros de entrada no sean nulos.", HttpStatus.BAD_REQUEST);
	}


	/**
	 * Null excepcion
	 * 
	 * @param ex de tipo NullPointerException ex
	 * @return regresa un ResponseEntity
	 */
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(value = { SessionException.class })
	public ResponseEntity<String> sessionException(SessionException ex) {

		return new ResponseEntity<>("Sesión no válida..", HttpStatus.UNAUTHORIZED);
	}
}
