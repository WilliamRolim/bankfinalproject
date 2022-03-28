package it.williamrolim.bankfinalproject.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.williamrolim.bankfinalproject.model.Account;
import it.williamrolim.bankfinalproject.model.requestDTO.AccountRequestDTO;
@Service
public interface AccountService {
    public Account insertAccount(AccountRequestDTO accountRequestDTO);
    public Page<Account> getAllAccounts(Pageable pageable);
    public Account getAccountById(Integer accountId);
    public  Account getAccountByRegisterId(String registerId);
    public void deleteByAccountIDFK(Integer accountId);
    public Account updateAccount(Integer accountId, AccountRequestDTO accountRequestDTO);
    public Account addCardToAccount(Long accountId, Long cardId);
    public Account removeCardFromAccount(Long zipcodeId);
}
