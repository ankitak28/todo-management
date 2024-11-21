package net.javaguides.todo.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.todo.dto.TodoDto;
import net.javaguides.todo.entity.Todo;
import net.javaguides.todo.exception.ResourceNotFoundException;
import net.javaguides.todo.repository.TodoRepository;
import net.javaguides.todo.service.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository ;

    private ModelMapper modelMapper;
    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        Todo todo = modelMapper.map(todoDto, Todo.class);

        Todo savedTodo = todoRepository.save(todo);
        TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);
        return savedTodoDto;

    }

    @Override
    public TodoDto findTodoById(Long id) {

        Todo todo = todoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Todo not found with id : "+id)
        );

        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public List<TodoDto> findAll() {

        List<Todo> todoDtoList = todoRepository.findAll();
        return todoDtoList.stream().map(
                (todoDtoListItem)->modelMapper.map(todoDtoListItem,TodoDto.class)).
                collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo(Long id, TodoDto todoDto) {
        Todo todo = todoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Todo item not found to update with id : "+id)
        );
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setStatus(todoDto.getStatus());

        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public void deleteTodo(Long id) {

        Todo todo = todoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Todo not found with id : "+id)
        );
         todoRepository.deleteById(todo.getId());
    }

    @Override
    public TodoDto completeTodo(Long id) {

        Todo todo = todoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Todo not found with id : "+id)
        );

        todo.setStatus("Complete");
        Todo savedTodo = todoRepository.save(todo);

        return modelMapper.map(savedTodo, TodoDto.class);
    }

    @Override
    public TodoDto inCompleteTodo(Long id) {

        Todo todo = todoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Todo not found with id : "+id)
        );

        todo.setStatus("Incomplete");
        Todo savedTodo = todoRepository.save(todo);

        return modelMapper.map(savedTodo, TodoDto.class);
    }
}
