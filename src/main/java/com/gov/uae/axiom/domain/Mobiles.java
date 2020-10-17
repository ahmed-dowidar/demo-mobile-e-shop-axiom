package com.gov.uae.axiom.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
public class Mobiles {
	@Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @JsonIgnore
	private Long objectId;
	
	private @JsonProperty Long id;
    private @JsonProperty String brand;
    private @JsonProperty String phone;
    private @JsonProperty String picture;
    private @JsonProperty String sim;
    private @JsonProperty String resolution;

    @Embedded
    private @JsonProperty Release release;
    @Embedded
    private @JsonProperty Hardware hardware;

}
