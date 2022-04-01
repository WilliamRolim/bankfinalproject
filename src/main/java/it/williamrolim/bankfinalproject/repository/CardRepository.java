package it.williamrolim.bankfinalproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.williamrolim.bankfinalproject.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
	
	
	  @Query(value = "SELECT * "
				 + "FROM Account a "
				  + "INNER JOIN Card c "
				  + "ON  a.account_id = c.account_id "
				  + "WHERE a.account_id = :accountIdFK" , nativeQuery = true)
	Optional<Card> cardGetAccountId(@Param("accountIdFK") Integer accountIdFK);
	 
	
				
}
