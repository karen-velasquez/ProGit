package com.karen_velasquez.www.ProGit;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EmployeeController {

  private final MinibusRepository repository;

  EmployeeController(MinibusRepository repository) {
    this.repository = repository;
  }

  // Aggregate root

  @GetMapping("/employees")
  List<Minibus> all() {
    return repository.findAll();
  }

  @PostMapping("/employees")
  Minibus newMinibus(@RequestBody Minibus newMinibus) {
    return repository.save(newMinibus);
  }

  // Single item

  @GetMapping("/employees/{id}")
  Minibus one(@PathVariable Long id) {

    return repository.findById(id)
      .orElseThrow(() -> new MinibusNotFoundException(id));
  }

  @PutMapping("/minibuses/{id}")
  Minibus replaceMinibus(@RequestBody Minibus newMinibus, @PathVariable Long id) {

    return repository.findById(id)
      .map(minibus -> {
        minibus.setNumero(newMinibus.getNumero());
        minibus.setP_partida(newMinibus.getP_partida());
        return repository.save(minibus);
      })
      .orElseGet(() -> {
        newMinibus.setId(id);
        return repository.save(newMinibus);
      });
  }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}