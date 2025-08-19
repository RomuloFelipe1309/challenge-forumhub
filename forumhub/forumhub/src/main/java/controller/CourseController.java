package controller;

import domain.course.Course;
import domain.course.dto.CreateCourseDTO;
import domain.course.dto.DetailCourseDTO;
import domain.course.dto.UpdateCourseDTO;
import domain.course.repository.CourseRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/courses")
@SecurityRequirement(name = "bearer-key")
@Tag(name = "Curso", description = "It can belong to one of many defined categories.")
public class CourseController {

    @Autowired
    private CourseRepository repository;

    // ✅ Create course
    @PostMapping
    @Transactional
    @Operation(summary = "Do you want to create a new course in the Database?")
    public ResponseEntity<DetailCourseDTO> createCourse(@RequestBody @Valid CreateCourseDTO createCourseDTO,
                                                        UriComponentsBuilder uriBuilder) {
        Course course = new Course(createCourseDTO);
        repository.save(course);
        var uri = uriBuilder.path("/courses/{id}").buildAndExpand(course.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailCourseDTO(course));
    }

    // ✅ List all courses
    @GetMapping("/all")
    @Operation(summary = "Read all independent courses.")
    public ResponseEntity<Page<DetailCourseDTO>> listAllCourses(Pageable pageable) {
        var page = repository.findAll(pageable).map(DetailCourseDTO::new);
        return ResponseEntity.ok(page);
    }

    // ✅ List active courses
    @GetMapping
    @Operation(summary = "List of active courses.")
    public ResponseEntity<Optional<Object>> listActiveCourses(Pageable pageable) {
        Optional<Object> page = repository.findAllByActiveTrue(pageable).map(DetailCourseDTO::new);
        return ResponseEntity.ok(page);
    }

    // ✅ Search course by id
    @GetMapping("/{id}")
    @Operation(summary = "Read a single course by its ID")
    public ResponseEntity<DetailCourseDTO> getCourseById(@PathVariable Long id) {
        Course course = repository.getReferenceById(id);
        var courseDetails = new DetailCourseDTO(course);
        return ResponseEntity.ok(courseDetails);
    }

    // ✅ Update course
    @PutMapping("/{id}")
    @Transactional
    @Operation(summary = "Update the name and category of a course.")
    public ResponseEntity<DetailCourseDTO> updateCourse(@PathVariable Long id,
                                                        @RequestBody @Valid UpdateCourseDTO updateCourseDTO) {
        Course course = repository.getReferenceById(id);
        course.updateCourse(updateCourseDTO);
        var courseDetails = new DetailCourseDTO(course);
        return ResponseEntity.ok(courseDetails);
    }

    // ✅ Delete course
    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Delete a course by its ID.")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
        Course course = repository.getReferenceById(id);
        course.deleteCourse();
        return ResponseEntity.noContent().build();
    }
}

