package fr.Aaris.configureTest.repository;

import fr.Aaris.configureTest.model.Produits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produits,Long> {
    @Override
    List<Produits> findAll();

    @Override
    <S extends Produits> S save(S s);
}
