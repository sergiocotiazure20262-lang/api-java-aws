package br.com.cotiinformatica.api_java_aws.dtos;

public record ClienteRequest(
        String nome,
        String email
) {
}
