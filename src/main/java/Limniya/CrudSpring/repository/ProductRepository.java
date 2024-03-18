package Limniya.CrudSpring.repository;

import Limniya.CrudSpring.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products,Long> {


}
