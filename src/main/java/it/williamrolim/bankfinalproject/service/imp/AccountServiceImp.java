package it.williamrolim.bankfinalproject.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.williamrolim.bankfinalproject.exceptions.CardExceptions;
import it.williamrolim.bankfinalproject.exceptions.Errors;
import it.williamrolim.bankfinalproject.model.Account;
import it.williamrolim.bankfinalproject.model.requestDTO.AccountRequestDTO;
import it.williamrolim.bankfinalproject.repository.AccontRepository;
import it.williamrolim.bankfinalproject.repository.CardRepository;
import it.williamrolim.bankfinalproject.service.AccountService;
import it.williamrolim.bankfinalproject.service.CardService;


@Service
public class AccountServiceImp implements AccountService{

	@Autowired
	AccontRepository accountRepository;

	@Autowired
	CardService cardService;

	@Autowired
	CardRepository cardRepository;
	
	@Override
	@Transactional
	public Account insertAccount(AccountRequestDTO accountRequestDTO) {
		Account account = new Account();
		account.setNameOwner(accountRequestDTO.getNameOwner());
		account.setAgencyCode(accountRequestDTO.getAgencyCode());
		account.setAccountCode(accountRequestDTO.getAccountCode());
		account.setDigitVerification(accountRequestDTO.getDigitVerification());
		account.setRegisterId(accountRequestDTO.getRegisterId());
		
		return accountRepository.save(account);
	}

	@Override
	public Page<Account> getAllAccounts(Pageable page) {
        Page<Account> AllAccounts = accountRepository.findAll(page);
        return AllAccounts;

	}

	@Override
	@Transactional(readOnly = false)
	public Account getAccountById(Integer accountId) {
		
		 Optional<Account> account = accountRepository.findById(accountId);
		 account.orElseThrow(() -> new RuntimeException("account não encontrado"));

	        return account.get();
	   
}
	

	@Override
	@Transactional
	public Account getAccountByRegisterId(String registerId) {
		 Optional<Account> findByRegisterId = this.accountRepository.findByRegisterIds(registerId);
		 findByRegisterId.orElseThrow(() -> new RuntimeException("Account dont find"));
		    return findByRegisterId.get();
		   
	}
	
	@Transactional
	@Override
	public void deleteByAccountIDFK(Integer id) {
	
		if (accountRepository.findById2(id) != accountRepository.findById2(id)) {
			throw new RuntimeException("Account Have Card");
		}else {
			accountRepository.deleteById(id);

		}

	}
	@Transactional
	@Override
	public Account updateAccount(Integer accountId, AccountRequestDTO accountRequestDTO) {
		Optional<Account> accountFind = accountRepository.findById(accountId);
		accountFind.orElseThrow(() -> new RuntimeException("Account dont find"));
		
		
		if (accountFind == null) throw new CardExceptions(Errors.NO_RECORD_FOUND.getErrorMessage());

		Account accountUpdate = getAccountById(accountId);
		
		accountUpdate.setNameOwner(accountRequestDTO.getNameOwner());
		accountUpdate.setAgencyCode(accountRequestDTO.getAgencyCode());
		accountUpdate.setAccountCode(accountRequestDTO.getAccountCode());
		accountUpdate.setDigitVerification(accountRequestDTO.getDigitVerification());
		accountUpdate.getRegisterId();

        if (accountId == null) {
			throw new IllegalArgumentException("Error: No RegisterId or No Id Account");
        }
       return accountRepository.save(accountUpdate);
	}

	@Override
	public Account addCardToAccount(Long accountId, Long cardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account removeCardFromAccount(Long cardId) {
		// TODO Auto-generated method stub
		return null;
	}

}
