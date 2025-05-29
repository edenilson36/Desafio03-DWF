package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.model.Alumno;
import sv.edu.udb.service.AlumnoService;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")  // Cambio de ruta: de "/alumnos" a "/api/alumnos"
@RequiredArgsConstructor
public class AlumnoController {

    private final AlumnoService alumnoService;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Alumno> findAll() {
        return alumnoService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Alumno findById(@PathVariable Long id) {
        return alumnoService.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Alumno save(@Valid @RequestBody Alumno alumno) {
        return alumnoService.save(alumno);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Alumno update(@PathVariable Long id, @Valid @RequestBody Alumno alumno) {
        return alumnoService.update(id, alumno);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public void delete(@PathVariable Long id) {
        alumnoService.delete(id);
    }
}