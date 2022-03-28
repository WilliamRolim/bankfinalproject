package it.williamrolim.bankfinalproject.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.williamrolim.bankfinalproject.model.Account;
import it.williamrolim.bankfinalproject.model.Card;

@Repository
public interface AccontRepository extends JpaRepository<Account, Integer> {
	
//	@Query(value ="SELECT * FROM Account a "+
//	"INNER JOIN Card c " 
//			+" ON  a.id = c.account_id WHERE a.id = :id", nativeQuery = true)
	/*@Query(value ="SELECT * FROM Account a "+
	"INNER JOIN Card c " 
			+" ON  a.id = c.account_id WHERE a.id = :id", nativeQuery = true)*/
	@Query(value ="SELECT * FROM Account a "
				+ "INNER JOIN Card c " 
				+ "ON  a.account_id = c.account_id "
				+" WHERE c.account_id = :id", nativeQuery = true)
	Optional<Account> findById2(@Param("id") Integer id);
	//public void findById2(@Param("id") Integer id);
	
	Optional<Account> findByRegisterId(String registerId);

	Page<Account> findAll(Pageable page);
	@Modifying
	@Query(value = "SELECT * " + 
					"FROM Account a " 
					+ "INNER JOIN Card c "  
					+ "ON  a.account_id = c.account_id "
					+ "INNER JOIN Type_Card tc "  
					+ "ON c.type_card_id = tc.type_card_id "
					+ " WHERE a.register_id = :register_id", nativeQuery = true)
	@Transactional(readOnly = true)
	Optional<Account> findByRegisterIds(@Param("register_id") String register_id);

	
//	@Query(value ="select registerId  "
//			+ "from account a  "
//			+ "where a.account_id = :id", nativeQuery = true)
//	Account findRegisterIdById(@Param("id") Integer id);
	
	
//	@Query(value = "select registerId  from account a  where a.account_id = 1", nativeQuery = true)
//	prublic void findRegisterIdById;


	// "delete * from account a where a.id = :id", nativeQuery = true)

//	  @Query(value = "delete from addresses u where u.ADDRESS_ID LIKE %:addressId%", nativeQuery = true)
//	  void deleteAddressByAddressId(@Param("addressId") String addressId);

}
