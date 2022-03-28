package it.williamrolim.bankfinalproject.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.google.common.net.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.williamrolim.bankfinalproject.exceptions.ErroPadrao;
import it.williamrolim.bankfinalproject.exceptions.ErrorConstraint;
import it.williamrolim.bankfinalproject.exceptions.ErrorHandling;
import it.williamrolim.bankfinalproject.model.Account;
import it.williamrolim.bankfinalproject.model.Card;
import it.williamrolim.bankfinalproject.model.requestDTO.AccountRequestDTO;
import it.williamrolim.bankfinalproject.service.AccountService;
@Api(value = "AccountController", description = "Persistir os dados, alterar, selecionar e excluir contas conforme regra de negocio proposta")
@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
    @ApiOperation(value= "Persistindo nova conta", notes = "Endpoint destinado a criar nova conta")
   @ApiResponses(value = {
		   @ApiResponse(code = 201, message = "Sucess"),
		   @ApiResponse(code = 400, message = "Bad Request", response = ErrorConstraint.class),
		   @ApiResponse(code = 404, message = "Not Found" , response = ErroPadrao.class),
		   @ApiResponse(code = 404, message = "Failure",response = ErroPadrao.class)
		   
   })
    @PostMapping
    public ResponseEntity<Account> insertAccount(@RequestBody final AccountRequestDTO accountRequestDTO) {
    	Account account = accountService.insertAccount(accountRequestDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getAccount_id())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value= "Pesquisando conta pelo ID", notes = "Endpoint destinado a buscar nova conta", response = Account.class)
    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable Integer accountId) {
    	Account acccount = accountService.getAccountById(accountId);
        return ResponseEntity.ok().body(acccount);
   
    }
    

	@GetMapping( "{register_id}" )
	public ResponseEntity<Account> searchAccountForRegisterId(@PathVariable String register_id) {
		Account doc = this.accountService.getAccountByRegisterId(register_id);
		return ResponseEntity.ok().body(doc);
	}

    @GetMapping("/getAll")
    public ResponseEntity<Page<Account>> getAllAccounts(Pageable pageable) {
    	Page<Account> acccount = accountService.getAllAccounts(pageable);
        return new ResponseEntity<>(acccount, HttpStatus.OK);
    }

    @PostMapping("/update/{accountId}")
    public ResponseEntity<Account> updateAccount(@RequestBody final AccountRequestDTO accountRequestDTO,
                                               @PathVariable final Integer accountId) {
    	Account account = accountService.updateAccount(accountId, accountRequestDTO);
		return ResponseEntity.ok().body(account);
    }

//    @PostMapping("/addCity/{cityId}/toZipcode/{zipcodeId}")
//    public ResponseEntity<Zipcode> addCity(@PathVariable final Long cityId,
//                                           @PathVariable final Long zipcodeId) {
//        Zipcode zipcode = zipcodeService.addCityToZipcode(zipcodeId, cityId);
//        return new ResponseEntity<>(zipcode, HttpStatus.OK);
//    }
//
//    @PostMapping("/deleteCity/{zipcodeId}")
//    public ResponseEntity<Zipcode> deleteCity(@PathVariable final Long zipcodeId) {
//        Zipcode zipcode = zipcodeService.removeCityFromZipcode(zipcodeId);
//        return new ResponseEntity<>(zipcode, HttpStatus.OK);
//    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Account> deleteAccount(@PathVariable final Integer id) {
    	accountService.deleteByAccountIDFK(id);
    	return ResponseEntity.ok().build();
    	}

}