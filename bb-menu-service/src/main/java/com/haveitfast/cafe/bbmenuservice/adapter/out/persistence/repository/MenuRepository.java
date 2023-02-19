package com.haveitfast.cafe.bbmenuservice.adapter.out.persistence.repository;

import com.haveitfast.cafe.bbmenuservice.adapter.out.persistence.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
}
