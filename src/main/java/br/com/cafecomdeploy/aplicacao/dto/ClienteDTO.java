package br.com.cafecomdeploy.aplicacao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClienteDTO {

    @NotEmpty(message = "O nome não pode ser nulo")
    private String nome;
    @NotEmpty(message = "O sobrenome não pode ser nulo")
    private String sobrenome;
    @NotEmpty(message = "O e-mail não deve ser nulo")
    @Email(message = "O e-mail não é válido")
    private String email;

}
