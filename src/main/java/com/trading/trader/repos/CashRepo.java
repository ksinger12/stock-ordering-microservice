package com.trading.trader.repos;

import com.trading.trader.entities.Cash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashRepo extends JpaRepository<Cash, Integer> {
}
