package com.example.demo.controllers;

import com.example.demo.model.dto.SessionDTORequest;
import com.example.demo.model.dto.SessionDTOResponse;
import com.example.demo.model.dto.SessionDTOUpdate;
import com.example.demo.service.SessionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
@RequiredArgsConstructor
@Tag(name = "Сеансы")
public class SessionController {

    public final SessionService sessionService;

    @PostMapping
    @Operation(summary = "Создание сеанса")// описание в svagger ui
    private ResponseEntity<SessionDTOResponse> createSession(@RequestBody SessionDTORequest sessionDTORequest){
        return ResponseEntity.ok(sessionService.create(sessionDTORequest));// обертка ответа со статусом ок

    }

    @PutMapping
    @Operation(summary = "Обновление данных сеанса")
    private ResponseEntity<SessionDTOResponse> updateSession(@RequestBody SessionDTOUpdate sessionDTOUpdate){
        return ResponseEntity.ok(sessionService.update(sessionDTOUpdate));

    }

    @GetMapping
    @Operation(summary = "Посмотреть сеанс")
    private ResponseEntity<SessionDTOResponse> getSession(@RequestParam String sessionNumber){//возвращает именно ответ CarDTOResponse
        return ResponseEntity.ok(sessionService.get(sessionNumber));

    }

    @DeleteMapping
    @Operation(summary = "Удаление сеанса")
    private ResponseEntity<HttpStatus> deleteSession(@RequestParam String sessionNumber){
        sessionService.delete(sessionNumber);
        return ResponseEntity.ok().build();

    }

    @PostMapping("/sessionToCinema")
    @Operation(summary = "Присваивание сеансу кинотеатр")
    private ResponseEntity<SessionDTOResponse> addToCinema(@RequestBody String sessionNumber, @RequestParam String nameCinema){
        return ResponseEntity.ok(sessionService.addToCinema(sessionNumber, nameCinema));// обертка ответа со статусом ок

    }

    @PostMapping("/sessionToMovie")
    @Operation(summary = "Присваивание сеансу фильма")
    private ResponseEntity<SessionDTOResponse> addToMovie(@RequestBody String sessionNumber, @RequestParam  String nameMovie){
        return ResponseEntity.ok(sessionService.addToMovie(sessionNumber, nameMovie));// обертка ответа со статусом ок

    }

    @PostMapping("/sessionToHall")
    @Operation(summary = "Присваивание сеансу зала")
    private ResponseEntity<SessionDTOResponse> addToHall(@RequestBody String sessionNumber, @RequestParam Integer numberHall){
        return ResponseEntity.ok(sessionService.addToHall(sessionNumber, numberHall));// обертка ответа со статусом ок

    }

    @GetMapping("/all")// пагинация и сортировка
    @Operation(summary = "Сортировать сеансы")
    public List<SessionDTOResponse> getAllSession(@RequestParam(required = false, defaultValue = "1") Integer page,
                                                 @RequestParam(required = false, defaultValue = "10") Integer perPage,
                                                 @RequestParam(required = false, defaultValue = "idSession") String sort,
                                                 @RequestParam(required = false, defaultValue = "ASC") Sort.Direction order){
        return sessionService.getAllSession(page, perPage, sort, order);

    }

}
