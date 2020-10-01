package fr.Aaris.configureTest.repository;

import fr.Aaris.configureTest.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Long> {
}
