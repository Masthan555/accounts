package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Schema(
        name = "Customer Details",
        description = "Customer details"
)
public class CustomerDetailsDto {

    @Schema(
            name = "Name",
            description = "Name of the customer"
    )
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 5, max = 30, message = "Name should have at least 2 characters")
    private String name;

    @Schema(
            name = "Email",
            description = "Email of the customer"
    )
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    @Schema(
            name = "Mobile",
            description = "Mobile number of the customer"
    )
    @NotEmpty(message = "Mobile should not be empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile should be 10 digits")
    private String mobile;

    @Schema(
            name = "Account Details of the customer"
    )
    private AccountsDto accountsDto;

    @Schema(
            name = "Loans Details of the customer"
    )
    private List<LoansDto> loansDto;

    @Schema(
            name = "Cards Details of the customer"
    )
    private List<CardsDto> cardsDto;

}
