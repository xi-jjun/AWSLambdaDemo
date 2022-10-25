package me.practice.awslambdademo.repository;

import me.practice.awslambdademo.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
	Optional<Item> findByName(String name);
}
