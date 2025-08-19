package controller;


import domain.answer.Answer;
import domain.answer.dto.CreateAnswerDTO;
import domain.answer.dto.DetailAnswerDTO;
import domain.answer.dto.UpdateAnswerDTO;
import domain.answer.repository.AnswerRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/answers")
@SecurityRequirement(name = "bearer-key")
@Tag(name = "Answer", description = "Represents a response to a topic or question.")
public class AnswerController {

    @Autowired
    private AnswerRepository repository;

    // ✅ Criar resposta
    @PostMapping
    @Transactional
    @Operation(summary = "Create a new answer.")
    public ResponseEntity<DetailAnswerDTO> createAnswer(@RequestBody @Valid CreateAnswerDTO createAnswerDTO,
                                                        UriComponentsBuilder uriBuilder) {
        Answer answer = new Answer(createAnswerDTO);
        repository.save(answer);
        var uri = uriBuilder.path("/answers/{id}").buildAndExpand(answer.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailAnswerDTO(answer));
    }

    // ✅ Listar todas as respostas
    @GetMapping("/all")
    @Operation(summary = "List all answers.")
    public ResponseEntity<Page<DetailAnswerDTO<Object, Object, Object, Object, Object, Object, Object>>> listAllAnswers(Pageable pageable) {
        var page = repository.findAll(pageable).map(DetailAnswerDTO::new);
        return ResponseEntity.ok(page);
    }

    // ✅ Listar respostas ativas
    @GetMapping
    @Operation(summary = "List active answers.")
    public ResponseEntity<Optional<DetailAnswerDTO<Object, Object, Object, Object, Object, Object, Object>>> listActiveAnswers(Pageable pageable) {
        var page = repository.findAllByActiveTrue(pageable).map(DetailAnswerDTO::new);
        return ResponseEntity.ok(page);
    }

    // ✅ Buscar resposta por ID
    @GetMapping("/{id}")
    @Operation(summary = "Get an answer by its ID.")
    public ResponseEntity<DetailAnswerDTO> getAnswerById(@PathVariable Long id) {
        Answer answer = repository.getReferenceById(id);
        var answerDetails = new DetailAnswerDTO(answer);
        return ResponseEntity.ok(answerDetails);
    }

    // ✅ Atualizar resposta
    @PutMapping("/{id}")
    @Transactional
    @Operation(summary = "Update an answer.")
    public ResponseEntity<DetailAnswerDTO> updateAnswer(@PathVariable Long id,
                                                        @RequestBody @Valid UpdateAnswerDTO updateAnswerDTO) {
        Answer answer = repository.getReferenceById(id);
        answer.updateAnswer(updateAnswerDTO);
        var answerDetails = new DetailAnswerDTO(answer);
        return ResponseEntity.ok(answerDetails);
    }

    // ✅ Deletar resposta
    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Delete an answer.")
    public ResponseEntity<?> deleteAnswer(@PathVariable Long id) {
        Answer answer = repository.getReferenceById(id);
        answer.deleteAnswer();
        return ResponseEntity.noContent().build();
    }
}
