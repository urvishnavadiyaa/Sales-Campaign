package com.example.sales.campaign.Repository;

import com.example.sales.campaign.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Product, Integer> {

}
