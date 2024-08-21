package com.mindhub.test;

import com.mindhub.test.exceptions.NotFoundTaskException;
import com.mindhub.test.models.EnumTask;
import com.mindhub.test.models.RolEnum;
import com.mindhub.test.models.Tasks;
import com.mindhub.test.models.UserEntity;
import com.mindhub.test.repositories.TaskRepository;
import com.mindhub.test.repositories.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Utils {


    @Bean
    public CommandLineRunner initData(UserEntityRepository userEntityRepository, TaskRepository taskRepository){
        return args ->{

            UserEntity user = new UserEntity("Rafael","12345","rafael@gmail.com", RolEnum.ADMIN);
            userEntityRepository.save(user);

            UserEntity user2 = new UserEntity("Jose","123456","jose@gmail.com", RolEnum.USER);
            userEntityRepository.save(user2);

            Tasks task = new Tasks("Tarea1","Ejercicio1", EnumTask.PENDING);
            user.addTasks(task);
            taskRepository.save(task);

            Tasks tarea = taskRepository.findById(1L).orElseThrow(()->new NotFoundTaskException("No se encontro la tarea con ese id"));
        };
    }
}
