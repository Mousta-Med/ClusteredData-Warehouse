package org.med.clustereddatawarehouse.repository;

import org.med.clustereddatawarehouse.model.entity.FxDeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FxDealRepository extends JpaRepository<FxDeal, String> {
}
