package com.rapsShopping.shopping.successPOJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class SuccessPOJO {

	@JsonProperty("message")
	private String message;

	@JsonProperty("authorized")
	private Boolean authorized;

	public SuccessPOJO(String message, Boolean authorized) {
		this.message = message;
		this.authorized = authorized;
	}

	public SuccessPOJO(String message) {
		this.message = message;
	}
}

