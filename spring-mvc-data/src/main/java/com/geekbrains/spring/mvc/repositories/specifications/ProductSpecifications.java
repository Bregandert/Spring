package com.geekbrains.spring.mvc.repositories.specifications;

import com.geekbrains.spring.mvc.model.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.OrderBy;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.SingularAttribute;

public class ProductSpecifications {
    public static Specification<Product> priceGEThan(int minPrice) {
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
            }
        };
    }

    public static Specification<Product> priceLEThan(int maxPrice) {
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Order descOrder = criteriaBuilder.desc(root.get("price"));
                criteriaQuery.orderBy(descOrder);

                return criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
            }
        };
    }

    public void applyOrderBy(CriteriaBuilder criteriaBuilder, Root<Product> root, CriteriaQuery<Product> criteriaQuery) {
        Order descOrder = criteriaBuilder.desc(root.get("price"));
        criteriaQuery.orderBy(descOrder);
    }


}
