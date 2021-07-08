package com.baggio.projeto.cronosadminapi.dto;

import java.io.Serializable;
import java.time.Instant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.baggio.projeto.cronosadminapi.entities.FinantialMovement;
import com.baggio.projeto.cronosadminapi.entities.enums.Origin;
import com.baggio.projeto.cronosadminapi.entities.enums.Status;

public class FinantialMovementDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank(message = "Campo obrigatório")
	private Long invoiceNumber;
	
	@NotBlank(message = "Campo obrigatório")
	private Long portionNumber;
	
	@NotBlank(message = "Campo obrigatório")
	private Origin origin;
	
	@NotBlank(message = "Campo obrigatório")
	private Instant dueDate;
		
	private Instant paidDate;
	
	@NotBlank(message = "Campo obrigatório")
	private Instant moment;
	
	@NotBlank(message = "Campo obrigatório")
	private String description;
	
	private String attachmentUrl;	
	
	@NotBlank(message = "Campo obrigatório")
	@Positive(message = "O valor deve ser positivo")
	private Double value;
	
	@NotBlank(message = "Campo obrigatório")
	private Status status;
	
	@NotBlank(message = "Campo obrigatório")
	private Long personId;
	
	@NotBlank(message = "Campo obrigatório")
	private Long historicId;
	
	@NotBlank(message = "Campo obrigatório")
	private Long userId;
	
	public FinantialMovementDTO() {

	}

	public FinantialMovementDTO(Long id, Long invoiceNumber, Long portionNumber, Origin origin, Instant dueDate,
			Instant paidDate, Instant moment, String description, String attachmentUrl, Double value, Status status,
			Long personId, Long historicId, Long userId) {
		this.id = id;
		this.invoiceNumber = invoiceNumber;
		this.portionNumber = portionNumber;
		this.origin = origin;
		this.dueDate = dueDate;
		this.paidDate = paidDate;
		this.moment = moment;
		this.description = description;
		this.attachmentUrl = attachmentUrl;
		this.value = value;
		this.status = status;
		this.personId = personId;
		this.historicId = historicId;
		this.userId = userId;
	}

	public FinantialMovementDTO(FinantialMovement entity) {
		id = entity.getId();
		invoiceNumber = entity.getInvoiceNumber();
		portionNumber = entity.getPortionNumber();
		origin = entity.getOrigin();
		dueDate = entity.getDueDate();
		paidDate = entity.getPaidDate();
		moment = entity.getMoment();
		description = entity.getDescription();
		attachmentUrl = entity.getAttachmentUrl();
		value = entity.getValue();
		status = entity.getStatus();
		personId = entity.getPerson().getId();
		historicId = entity.getHistoric().getId();
		userId = entity.getUser().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(Long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Long getPortionNumber() {
		return portionNumber;
	}

	public void setPortionNumber(Long portionNumber) {
		this.portionNumber = portionNumber;
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public Instant getDueDate() {
		return dueDate;
	}

	public void setDueDate(Instant dueDate) {
		this.dueDate = dueDate;
	}

	public Instant getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Instant paidDate) {
		this.paidDate = paidDate;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAttachmentUrl() {
		return attachmentUrl;
	}

	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public Long getHistoricId() {
		return historicId;
	}

	public void setHistoricId(Long historicId) {
		this.historicId = historicId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
		
}
