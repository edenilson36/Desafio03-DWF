package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.model.Materia;
import sv.edu.udb.service.MateriaService;

import java.util.List;

@RestController
@RequestMapping("/api/materias")  // Cambio de ruta: de "/materias" a "/api/materias"
@RequiredArgsConstructor
public class MateriaController {

    private final MateriaService materiaService;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Materia> findAll() {
        return materiaService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Materia findById(@PathVariable Long id) {
        return materiaService.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Materia save(@Valid @RequestBody Materia materia) {
        return materiaService.save(materia);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Materia update(@PathVariable Long id, @Valid @RequestBody Materia materia) {
        return materiaService.update(id, materia);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public void delete(@PathVariable Long id) {
        materiaService.delete(id);
    }
}