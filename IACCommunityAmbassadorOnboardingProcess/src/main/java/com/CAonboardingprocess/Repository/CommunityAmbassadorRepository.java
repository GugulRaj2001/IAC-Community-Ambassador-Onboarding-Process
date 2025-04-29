package com.CAonboardingprocess.Repository;

import java.util.Optional;	

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.CAonboardingprocess.Model.CommunityAmbassador;

// Repository interface for CommunityAmbassador entity
@Repository
public interface CommunityAmbassadorRepository extends JpaRepository<CommunityAmbassador, Long> {
	
	// Repository interface for CommunityAmbassador entity
    Optional<CommunityAmbassador> findByEmail(String email);
}
