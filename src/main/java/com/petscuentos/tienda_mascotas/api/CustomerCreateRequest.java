package com.petscuentos.tienda_mascotas.api;
import jakarta.validation.constraints.Pattern;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Data
@AllArgsConstructor
@Builder
public class CustomerCreateRequest {
   @NotNull
   @Size( max = 35)
   private String firstName;

   @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
   private String emailAddress;
   
}
