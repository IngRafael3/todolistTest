package com.mindhub.test.repositories;


import com.mindhub.test.models.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Tasks,Long> {


}
