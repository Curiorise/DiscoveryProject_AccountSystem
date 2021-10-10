package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.dto.AccountUserTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountUserTransaction;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.FetchAccountUserTransactionFlow;
import za.ac.nwu.ac.logic.flow.CreateAccountUserTransactionFlow;

import java.util.List;

@RestController
@RequestMapping("account-transaction")

public class AccountUserTransactionController {

    private final FetchAccountUserTransactionFlow fetchAccountUserTransactionFlow;
    private final CreateAccountUserTransactionFlow createAccountUserTransactionFlow;

    @Autowired
    public AccountUserTransactionController(CreateAccountUserTransactionFlow createAccountUserTransactionFlow,
                                            FetchAccountUserTransactionFlow fetchAccountUserTransactionFlow){
        this.createAccountUserTransactionFlow = createAccountUserTransactionFlow;
        this.fetchAccountUserTransactionFlow = fetchAccountUserTransactionFlow;
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new AccountUserTransaction.", notes = "Creates a new AccountUserTransaction in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountUserTransaction was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountUserTransactionDto>> create(
            @ApiParam(value = "Request body to create a new AccountUserTransaction.",
                    required = true)
            @RequestBody AccountUserTransactionDto AccountUserTransaction) {
        AccountUserTransactionDto AccountUserTransactionResponse = createAccountUserTransactionFlow.create(AccountUserTransaction);
        GeneralResponse<AccountUserTransactionDto> response = new GeneralResponse<>(true, AccountUserTransactionResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account Types", notes = "Returns a list of Account Types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account Types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountUserTransactionDto>>> getAll() {
        List<AccountUserTransactionDto> AccountUserTransactions = fetchAccountUserTransactionFlow.getAllAccountUserTransactions();
        GeneralResponse<List<AccountUserTransactionDto>> response = new GeneralResponse<>(true, AccountUserTransactions);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{transactionID}")
    @ApiOperation(value = "Fetches the specified Account User Transaction", notes = "Fetches the AccountUserTransaction corresponding to the given transactionID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AccountUserTransaction Found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountUserTransactionDto>> getAccountUserTransaction(
            @ApiParam(value = "The transactionID that uniquely identifies the AccountUserTransaction.",
                    example = "5002",
                    name = "transactionID",
                    required = true)
            @PathVariable("transactionID") final Long transactionID) {
        AccountUserTransactionDto AccountUserTransaction = fetchAccountUserTransactionFlow.getAccountUserTransaction(transactionID);
        GeneralResponse<AccountUserTransactionDto> response = new GeneralResponse<>(true, AccountUserTransaction);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
