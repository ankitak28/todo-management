package net.javaguides.todo.controller;

import lombok.AllArgsConstructor;
import net.javaguides.todo.dto.TodoDto;
import net.javaguides.todo.entity.Todo;
import net.javaguides.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private TodoService todoService;
    @PostMapping()
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){

        TodoDto savedTodoDto = todoService.addTodo(todoDto);
        return  new ResponseEntity<>(savedTodoDto, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    private ResponseEntity<TodoDto> getTodo(@PathVariable Long id){
        TodoDto todoDto = todoService.findTodoById(id);
        return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

    @GetMapping()
    private ResponseEntity<List<TodoDto>> getAllTodos(){

        List<TodoDto> todoDtoList = todoService.findAll();
        return ResponseEntity.ok(todoDtoList);
    }

    @PutMapping("{id}")
    private ResponseEntity<TodoDto> updateTodo(@PathVariable("id") Long idToUpdate, @RequestBody TodoDto updatedTodoDto){

        TodoDto todoDto = todoService.updateTodo(idToUpdate, updatedTodoDto);
        return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId){
        todoService.deleteTodo(todoId);

        return ResponseEntity.ok("Todo Item Deleted!");
    }

    @PatchMapping("{id}/complete")
    private ResponseEntity<TodoDto> completeTodo(@PathVariable("id") Long todoId){

        TodoDto completeTodoDto = todoService.completeTodo(todoId);
        return ResponseEntity.ok(completeTodoDto);
    }

    @PatchMapping("{id}/incomplete")
    private ResponseEntity<TodoDto> inCompleteTodo(@PathVariable("id") Long todoId){

        TodoDto savedTodoDto = todoService.inCompleteTodo(todoId);
        return ResponseEntity.ok(savedTodoDto);
    }

}
