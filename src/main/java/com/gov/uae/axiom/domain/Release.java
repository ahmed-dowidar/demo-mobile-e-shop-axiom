package com.gov.uae.axiom.domain;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Setter
@Getter
public class Release {
	private @JsonProperty String announceDate;
	private @JsonProperty String priceEur;

}
