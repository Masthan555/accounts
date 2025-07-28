package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Accounts details"
)
public class AccountsDto {

    @Schema(
            name = "Account Number"
    )
    @NotEmpty(message = "Account number should not be empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number should be 10 digits")
    private Long accountNumber;

    @Schema(
            name = "Account Type"
    )
    @NotEmpty(message = "Account type should not be empty")
    private String accountType;

    @Schema(
            name = "Branch Address"
    )
    @NotEmpty(message = "Branch address should not be empty")
    private String branchAddress;
}
