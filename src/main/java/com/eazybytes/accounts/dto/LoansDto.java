package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Schema(
        name = "Loans",
        description = "Loan details"
)
public class LoansDto {

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile should be 10 digits")
    @Schema(
            name = "Mobile",
            description = "Mobile number of the customer"
    )
    private String mobile;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Loan Number should be 10 digits")
    @Schema(
            name = "Loan Number",
            description = "Generated loan number"
    )
    private String loanNumber;

    @NotEmpty(message = "Loan type should not be empty")
    @Schema(
            name = "Loan Type",
            description = "Type of loan"
    )
    private String loanType;

    @Positive(message = "Total loan should be positive")
    @NotNull(message = "Total loan should not be empty")
    @Schema(
            name = "Total Loan",
            description = "Total loan amount"
    )
    private int totalLoan;

    @PositiveOrZero(message = "Amount paid should be positive or zero")
    @NotNull(message = "Amount paid should not be empty")
    @Schema(
            name = "Amount Paid",
            description = "Total Amount paid"
    )
    private int amountPaid;

    @Schema(
            name = "Outstanding Amount",
            description = "Total Outstanding amount"
    )
    @Positive(message = "Outstanding amount should be positive")
    @NotNull(message = "Outstanding amount should not be empty")
    private int outstandingAmount;
}
