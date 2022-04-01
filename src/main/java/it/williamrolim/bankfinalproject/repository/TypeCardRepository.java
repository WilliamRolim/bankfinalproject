package it.williamrolim.bankfinalproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import it.williamrolim.bankfinalproject.model.Account;
import it.williamrolim.bankfinalproject.model.Card;
import it.williamrolim.bankfinalproject.model.TypeCard;
import it.williamrolim.bankfinalproject.model.requestDTO.TypeCardRequestDTO;

public interface TypeCardRepository extends JpaRepository<TypeCard, Integer> {

	
//	@Query(value = "select registerId  from account a  where a.account_id = 1", nativeQuery = true)

	@Query(value ="select * from type_card WHERE name = :nome",
			nativeQuery = true)
	@Transactional(readOnly = true)
	Optional<TypeCard> findIDByName(@Param("nome") String nome);

	Optional<TypeCard> findTypeCardByName(String name);

	Optional<TypeCard> findByName(TypeCard name);

	@Query(value ="select * from type_card WHERE name = :nome",
			nativeQuery = true)
	@Transactional(readOnly = true)
	String compareTypeCardNames(@Param("nome") String nome);

	String findByName(String name);

	TypeCard save(TypeCardRequestDTO typeCardRequestDTO);
	
}
