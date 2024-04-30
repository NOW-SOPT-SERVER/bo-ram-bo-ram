package sopt.cloneCoding.carrot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.cloneCoding.carrot.domain.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
